package com.scs.soft.zhihu.api.mapper;

import com.scs.soft.zhihu.api.entity.Favorite;
import com.scs.soft.zhihu.api.entity.RoundTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName FavoriteMapper
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/

public interface FavoriteMapper {
    /**
     * 查询热门收藏
     * @return List<Favorite>
     */
    @Select("SELECT * FROM t_favorite")
    List<Favorite> selectallfavorite();
    /**
     *查询前四个
     */
    @Select("SELECT * FROM t_favorite ORDER BY id  LIMIT 2,4")
    List<Favorite> selectRecent();

}
