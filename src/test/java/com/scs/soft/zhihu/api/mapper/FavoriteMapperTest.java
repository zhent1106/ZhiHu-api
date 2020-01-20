package com.scs.soft.zhihu.api.mapper;

import com.scs.soft.zhihu.api.ZhihuApiApplication;
import com.scs.soft.zhihu.api.entity.Favorite;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ZhihuApiApplication.class)
class FavoriteMapperTest {
@Resource
private  FavoriteMapper favoriteMapper;
    @Test
    void selectallfavorite() {
        List<Favorite> favoriteList=favoriteMapper.selectallfavorite();
        favoriteList.forEach(System.out::println);
    }

    @Test
    void selectRecent() {
        List<Favorite> favoriteList=favoriteMapper.selectRecent();
        favoriteList.forEach(System.out::println);
    }
}