package com.scs.soft.zhihu.api.controller;
import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.entity.dto.AdminDto;
import com.scs.soft.zhihu.api.entity.dto.UserDto;
import com.scs.soft.zhihu.api.service.UserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 田震
 * @Date 2020/2/8
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    private UserService userService;
    /***
     * 登录
     * @param adminDto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/login")
    public Result signIn(@RequestBody AdminDto adminDto) throws IOException {
        return  userService.login(adminDto);
    }

    /**
     * 注册
     * @param userDto
     * @return
     */
        @PostMapping(value = "/signup")
    Result signUp(@RequestBody UserDto userDto) {
        return userService.sign(userDto);
    }

    /**
     * 得到验证码
     */
    @PostMapping(value = "/sms")
    Result getSms(@RequestBody UserDto userDto) {
        return userService.sendSms(userDto);
    }
    /**
     *  检查验证码是否正确
     */
    @PostMapping(value = "/sms/check")
    Result checkSms(@RequestBody UserDto userDto) {
        return userService.checkSms(userDto);
    }

}