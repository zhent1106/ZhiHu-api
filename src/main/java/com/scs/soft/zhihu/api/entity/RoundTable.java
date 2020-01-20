package com.scs.soft.zhihu.api.entity;

import lombok.Builder;
import lombok.Data;
/**
 * @ClassName RoundTable
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/17
 **/
@Builder
@Data
public class RoundTable {
    private  Integer id;
    private  String name;
    private  String tinyBanner;
    private  String banner;
    private  String urlToken;
    private  Integer visitsCount;
    private  Integer includeCount;
}