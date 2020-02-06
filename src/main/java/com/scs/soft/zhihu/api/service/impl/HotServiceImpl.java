package com.scs.soft.zhihu.api.service.impl;

import com.scs.soft.zhihu.api.entity.Special;
import com.scs.soft.zhihu.api.mapper.HotMapper;
import com.scs.soft.zhihu.api.mapper.SpecialMapper;
import com.scs.soft.zhihu.api.service.HotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HotServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/30
 **/
@Service
public class HotServiceImpl implements HotService {
    @Resource
    private HotMapper hotMapper;
    @Override
    public List<Map> selectAll() {
        return hotMapper.selectAll();
    }

    @Override
    public List<Special> selectRecent() {
        return hotMapper.selectRecent();
    }
}