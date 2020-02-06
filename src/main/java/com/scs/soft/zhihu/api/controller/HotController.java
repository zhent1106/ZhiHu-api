package com.scs.soft.zhihu.api.controller;

import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.service.HotService;
import com.scs.soft.zhihu.api.service.SpecialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HotController
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/30
 **/
@RestController
@RequestMapping(value = "/api/hot")
public class HotController {
    @Resource
    private HotService hotService;
    /**
     * 展示所有专题
     * @return
     */
    @GetMapping(value = "/all")
    public Result getAll(){
        return  Result.success(hotService.selectAll());
    }
    /**
     * 展示最近专题
     * @return
     */
    @GetMapping
    public Result getRecent(){
        return Result.success(hotService.selectRecent());
    }

}