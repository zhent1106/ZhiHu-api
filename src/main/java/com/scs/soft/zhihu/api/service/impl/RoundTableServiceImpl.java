package com.scs.soft.zhihu.api.service.impl;

import com.scs.soft.zhihu.api.entity.RoundTable;
import com.scs.soft.zhihu.api.mapper.RoundTableMapper;
import com.scs.soft.zhihu.api.service.RoundTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName RoundTableServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/17
 **/
@Service
public class RoundTableServiceImpl implements RoundTableService {
    @Resource
    private RoundTableMapper roundTableMapper;

    /**
     * 查找发现的所有专题
     * @return
     */
    @Override
    public List<RoundTable> selectallroundtable() {
        return roundTableMapper.selectallroundtable();
    }

    @Override
    public List<RoundTable> selectFourth() {
        return roundTableMapper.selectRecent();
    }
}