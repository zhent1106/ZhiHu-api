package com.scs.soft.zhihu.api.entity.vo;

import com.scs.soft.zhihu.api.entity.Columns;
import com.scs.soft.zhihu.api.entity.Favorite;
import com.scs.soft.zhihu.api.entity.RoundTable;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Explore
 * @Description 发现页的四个模块的前四个数据截取
 * @Author 田震
 * @Date 2020/2/6
 **/
@Data
@Builder
public class ExploreVo {
    private List<Map> specials;
    private List<RoundTable> roundTables;
    private List<Favorite> favorites;
    private List<Columns> columns;
}