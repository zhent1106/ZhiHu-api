package com.scs.soft.zhihu.api.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Section
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/15
 **/
@Data
@Builder
public class Section {
    private  String sectionId;
    private  String specialId;
    private  String sectionTitle;

}