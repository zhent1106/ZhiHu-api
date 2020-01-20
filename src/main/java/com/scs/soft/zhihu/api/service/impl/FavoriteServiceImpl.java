package com.scs.soft.zhihu.api.service.impl;

import com.scs.soft.zhihu.api.entity.Favorite;
import com.scs.soft.zhihu.api.mapper.FavoriteMapper;
import com.scs.soft.zhihu.api.service.FavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName FavoriteServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Resource
    private FavoriteMapper favoriteMapper;
    @Override
    public List<Favorite> selectallFavorite() {
        return favoriteMapper.selectallfavorite();
    }

    @Override
    public List<Favorite> selectFourth() {
        return favoriteMapper.selectRecent();
    }
}