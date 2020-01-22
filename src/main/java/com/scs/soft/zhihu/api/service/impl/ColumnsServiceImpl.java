package com.scs.soft.zhihu.api.service.impl;

import com.scs.soft.zhihu.api.entity.Columns;
import com.scs.soft.zhihu.api.mapper.ColumnMapper;
import com.scs.soft.zhihu.api.service.ColumnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ColumnsServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@Service
public class ColumnsServiceImpl implements ColumnService {
    @Resource
    private ColumnMapper columnMapper;
    @Override
    public List<Columns> selectallColumns() {
        return columnMapper.selectallcolumn();
    }

    @Override
    public List<Columns> selectFourth() {
        return columnMapper.selectRecent();
    }

    @Override
    public List<Columns> selectByPage(int currentPage, int count) {
        int dealCount=(currentPage-1)*count;
        return columnMapper.selectByPage(dealCount,count);
    }
}