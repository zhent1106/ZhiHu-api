package com.scs.soft.zhihu.api.controller;

import com.scs.soft.zhihu.api.common.Result;
import com.scs.soft.zhihu.api.service.RoundTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RoundTableController
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/17
 **/

@RestController
@RequestMapping(value = "/api/roundtable")
public class RoundTableController {
    @Resource
    private RoundTableService roundTableService;

    /**
     * 展示所有发现
     * @return
     */
    @GetMapping
    public Result getAll(){
        return  Result.success(roundTableService.selectallroundtable());
    }
}