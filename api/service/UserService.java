package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.entity.dto.AdminDto;
import com.scs.soft.zhihu.api.entity.dto.UserDto;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户服务接口
 * @Author
 * @Date 2019/12/1
 **/
public interface UserService {

    /***
     * 用户登录功能
     * @return
     */
    Result login(AdminDto adminDto);


    /**
     * 用户注册功能
     *
     * @param userDto
     * @return Result
     */
    Result sign(UserDto userDto);

    /**
     * 获取短信验证
     * @param userDto
     * @return
     */
    Result sendSms(UserDto userDto);


    /**
     * 验证短信是否正确（signDto中有手机号和验证码两部分内容）
     * @param userDto
     * @return Result
     */
    Result checkSms(UserDto userDto);

}
