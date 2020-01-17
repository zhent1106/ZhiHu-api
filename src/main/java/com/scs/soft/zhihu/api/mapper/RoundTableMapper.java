package com.scs.soft.zhihu.api.mapper;

import com.scs.soft.zhihu.api.entity.RoundTable;
import com.scs.soft.zhihu.api.entity.Special;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName RoundTableMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/17
 **/
public interface RoundTableMapper {

    /**
     * 查询最新专题
     * @return List<RoundTable>
     */
    @Select("SELECT * FROM t_round_table")
    List<RoundTable> selectallroundtable();
}