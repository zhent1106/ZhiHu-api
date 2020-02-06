package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.vo.ExploreVo;

/**
 * @ClassName ExploreService
 * @Description TODO
 * @Author 田震
 * @Date 2020/2/6
 **/
public interface ExploreService {
    /**
     * 获取发现视图对象
     * @param currentPage
     * @param count
     * @return
     */
    ExploreVo selectByPage(int currentPage, int count);
}
