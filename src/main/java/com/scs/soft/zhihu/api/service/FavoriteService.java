package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.Favorite;
import com.scs.soft.zhihu.api.entity.RoundTable;

import java.util.List;

/**
 * @ClassName FavoriteService
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
public interface FavoriteService {
    /**
     * 查询所有的发现页
     * @return
     */
    List<Favorite> selectallFavorite();

    /**
     * 查询前四篇
     * @return
     */
    List<Favorite> selectFourth();

    /**
     * 根据页数查找
     * @param currentPage
     * @param count
     * @return
     */
    List<Favorite> selectByPage(int currentPage,int count);
}
