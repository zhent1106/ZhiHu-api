package com.scs.soft.zhihu.api.controller;

import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.service.ColumnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ColumnController
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@RestController
@RequestMapping(value = "/api/column")
public class ColumnController {
    @Resource
    private ColumnService columnService;
    /**
     *展示所有的专栏
     * @return
     */
    @GetMapping
    public Result getAll(){
        return  Result.success(columnService.selectallColumns());
    }

    @GetMapping("/fifth")
    public  Result getForth(){
        return  Result.success(columnService.selectFourth());
    }
    @GetMapping("/page")
    public  Result getByPage(int currentPage,int count){
        return  Result.success(columnService.selectByPage(currentPage,count));
    }
}