package com.scs.soft.zhihu.api.mapper;

import com.scs.soft.zhihu.api.entity.Section;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @ClassName SectionMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/15
 **/
public interface SectionMapper {
    /**
     * 根据专题id查询标签表
     * @param specialId
     * @return
     */

    @Select("select * from t_section where special_id=#{specialId}")
    List<Section> getSectionsBySpecialId(String specialId);
}
