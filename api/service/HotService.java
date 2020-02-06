package com.scs.soft.zhihu.api.service;

import com.scs.soft.zhihu.api.entity.Special;

import java.util.List;
import java.util.Map;

/**
 * @ClassName HotService
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/30
 **/
public interface HotService {
    /**
     * 查询所有专题
     * @return List<Map>
     */
    List<Map> selectAll();
    /**
     *查找最近专题
     * @return List<Special>
     */
    List<Special> selectRecent();
}
