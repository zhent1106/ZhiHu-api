package com.scs.soft.zhihu.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.ClientException;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.common.ResultCode;
import com.scs.soft.zhihu.api.entity.User;
import com.scs.soft.zhihu.api.entity.dto.AdminDto;
import com.scs.soft.zhihu.api.entity.dto.UserDto;
import com.scs.soft.zhihu.api.mapper.UserMapper;
import com.scs.soft.zhihu.api.service.RedisService;
import com.scs.soft.zhihu.api.service.UserService;
import com.scs.soft.zhihu.api.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author
 * @Date 2019/12/1
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;

    /**
     * 登录（成功）
     *
     * @param
     * @param
     * @return
     */
    @Override
    public Result login(AdminDto adminDto) {
        User admin = null;
        try {
            admin = userMapper.findUserByMobile(adminDto.getMobile());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (admin != null) {
            if (DigestUtils.md5Hex(adminDto.getPassword()).equals(admin.getPassword())) {
                return Result.success(admin);

            } else {  //记录存在，密码输入错误
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {  //账号不存在
            return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }
    }

    /**
     * 注册
     *
     * @param userDto
     * @return
     */
    @Override
    public Result sign(UserDto userDto) {
        //调用验证功能
        Result result = userService.checkSms(userDto);
        //验证通过
        if (result.getCode() == 1) {
            String mobile = userDto.getMobile();
            User user;
            try {
                user = userMapper.findUserByMobile(mobile);
            } catch (SQLException e) {
                logger.error("根据手机号查询用户出现异常");
                return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
            }
            //用户手机号存在，注册失败
            if (user != null) {
                return Result.failure(ResultCode.USER_HAS_EXISTED);
            } else {
                User saveUser=new User();
                saveUser.setMobile(mobile);
                saveUser.setNickname("用户"+mobile);
                saveUser.setIntroduction("你和冬天一起来了");
                saveUser.setAvatar("https://niit-soft.oss-cn-hangzhou.aliyuncs.com/avatar/default.png");
                try {
                    userMapper.insert(saveUser);
                } catch (SQLException e) {
                    logger.error("新增用户出现异常");
                    return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
                }
                return  Result.success(saveUser);
            }
        }
        return  Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
    }
    @Override
    public Result sendSms(UserDto userDto) {
        String mobile = userDto.getMobile();
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAIaG9RkwvVwXq6",
                "5WPkPJ4JY0nWciRfDpMFxzScm3oJn2");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "个人空间系统的设计与实现");
        request.putQueryParameter("TemplateCode", "SMS_180060198");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (ClientException e) {
            log.error("短信发送异常");
            return Result.failure(ResultCode.SMS_ERROR);
        } catch (com.aliyuncs.exceptions.ClientException e) {
            e.printStackTrace();
        }
        //resData样例：{"Message":"OK","RequestId":"0F3A84A6-55CA-4984-962D-F6F54281303E","BizId":"300504175696737408^0","Code":"OK"}
        String resData = response.getData();
        //将返回的JSON字符串转成JSON对象
        JSONObject jsonObject = JSONObject.parseObject(resData);
        if ("OK".equals(jsonObject.get("Code"))) {
            System.out.println(verifyCode);
            //存入redis，3分钟有效
            redisService.set(mobile, verifyCode, 3L);
            return Result.success(verifyCode);
        } else {
            return Result.failure(ResultCode.SMS_ERROR);
        }
    }

    @Override
    public Result checkSms(UserDto userDto) {
        String mobile = userDto.getMobile();
        String sms = userDto.getCode();
        System.out.println(sms);
        String correctSms = redisService.getValue(mobile, String.class);
        if (correctSms != null) {
            //将客户端传来的短信验证码和redis取出的短信验证码比对
            if (correctSms.equals(sms)) {
                return Result.success();
            } else {
                //验证码错误
                Result.failure(ResultCode.USER_VERIFY_CODE_ERROR);
            }
        }
        //验证码失效
        return Result.failure(ResultCode.USER_CODE_TIMEOUT);
}

}