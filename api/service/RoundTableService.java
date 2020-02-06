package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.RoundTable;

import java.util.List;

/**
 * @ClassName RoundTableService
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/17
 **/
public interface RoundTableService {
    /**
     * 查询所有的发现页
     * @return
     */
    List<RoundTable> selectallroundtable();

    /**
     * 查询前四篇
     * @return
     */
    List<RoundTable> selectFourth();
}
