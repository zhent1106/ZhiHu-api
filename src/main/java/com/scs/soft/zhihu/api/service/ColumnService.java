package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.Columns;
import com.scs.soft.zhihu.api.entity.Favorite;

import java.util.List;

/**
 * @ClassName ColumnService
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
public interface ColumnService {
    /**
     * 查询所有的专栏
     * @return
     */
    List<Columns> selectallColumns();

    /**
     * 查询前四篇
     * @return
     */
    List<Columns> selectFourth();

}