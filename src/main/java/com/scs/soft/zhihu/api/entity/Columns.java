package com.scs.soft.zhihu.api.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Columns
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@Builder
@Data
public class Columns {
    private  Integer id;
    private  String title;
    private  String description;
    private  String url;
    private  String imageUrl;
    private  Integer followers;
    private  Integer articlesCount;
}