package com.scs.soft.zhihu.api.mapper;
import com.scs.soft.zhihu.api.entity.User;
import com.scs.soft.zhihu.api.entity.dto.AdminDto;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserMapper
 * @Description 用户Mapper
 * @Author
 * @Date 2019/12/1
 **/
public interface UserMapper {
    /**
     *
     * @author 田震
     * 登录接口
     * @date 2019.12.2
     */
    @Select("SELECT mobile,password FROM t_user WHERE mobile=#{mobile} and password=#{password}")
    User login(AdminDto adminDto) throws  SQLException;


    /**
     * 新增用户，并返回自增主键
     *
     * @param user
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user (mobile,nickname,avatar,introduction) " +
            "VALUES (#{mobile},#{nickname},#{avatar},#{introduction}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user) throws SQLException;

    /**
     * 根据手机号查找用户
     *
     * @param mobile
     * @return User
     * @throws SQLException
     * @author mq_xu
     * @date 2019.12.1
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(@Param("mobile") String mobile) throws SQLException;


    /**
     * 根据昵称模糊查询
     * @return
     * @throws SQLException
     * @param
     */
    @Select("SELECT * FROM t_user WHERE nickname  LIKE  CONCAT ('%',#{nickname},'%') ")
    List<User> findUserByNickName(@Param("nickname") String nickname) throws  SQLException;

}
