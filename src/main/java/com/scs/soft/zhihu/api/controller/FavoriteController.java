package com.scs.soft.zhihu.api.controller;

import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.service.ColumnService;
import com.scs.soft.zhihu.api.service.FavoriteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName FavoriteController
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@RestController
@RequestMapping(value = "/api/favorite")
public class FavoriteController {
    @Resource
    private FavoriteService favoriteService;
    /**
     *展示所有的收藏
     * @return
     */
    @GetMapping
    public Result getAll(){
        return  Result.success(favoriteService.selectallFavorite());
    }

    @GetMapping("/forth")
    public  Result getForth(){
        return  Result.success(favoriteService.selectFourth());
    }
}