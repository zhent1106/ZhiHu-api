package com.scs.soft.zhihu.api.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@Data
public class User {
    private Integer id;
    private String mobile;
    private String password;
    private String nickname;
    private String avatar;
    private String introduction;
    private String email;
    private String birthday;
    private String code;

}
