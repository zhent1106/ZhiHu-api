package com.scs.soft.zhihu.api.service.impl;

import com.scs.soft.zhihu.api.entity.vo.ExploreVo;
import com.scs.soft.zhihu.api.mapper.*;
import com.scs.soft.zhihu.api.service.ExploreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName ExploreServiceImpl
 * @Description TODO
 * @Author 田震
 * @Date 2020/2/6
 **/
@Service
public class ExploreServiceImpl implements ExploreService {
    @Resource
    private SpecialMapper exploreMapper;
    @Resource
    private RoundTableMapper roundTableMapper;
    @Resource
    private FavoriteMapper favoriteMapper;
    @Resource
    private ColumnMapper columnMapper;

    @Override
    public ExploreVo selectByPage(int currentPage, int count) {
        int dealCount = (currentPage - 1) * count;
        ExploreVo exploreVos = ExploreVo.builder().specials(exploreMapper.selectByPage(dealCount, count))
                .roundTables(roundTableMapper.selectByPage(dealCount, count))
                .favorites(favoriteMapper.selectByPage(dealCount, count))
                .columns(columnMapper.selectByPage(dealCount, count)).build();
        return exploreVos;
    }
}