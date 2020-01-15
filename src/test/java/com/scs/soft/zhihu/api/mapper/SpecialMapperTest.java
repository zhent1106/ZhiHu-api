package com.scs.soft.zhihu.api.mapper;

import com.scs.soft.zhihu.api.ZhihuApiApplication;
import com.scs.soft.zhihu.api.entity.Special;
import org.hibernate.validator.constraints.URL;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ZhihuApiApplication.class)
class SpecialMapperTest {
 @Resource
 private  SpecialMapper specialMapper;
    @Test
    void selectRecent() {
        List<Special> specails=specialMapper.selectRecent();
        specails.forEach(System.out::println);
    }

    @Test
    void selectAll(){
        List<Map> specails=specialMapper.selectAll();
        specails.forEach(System.out::println);
    }
}