package com.scs.soft.zhihu.api.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @ClassName Favorite
 * @Description TODO
 * @Author 田震
 * @Date 2020/1/19
 **/
@Builder
@Data
public class Favorite {
    private  Integer id;
    private  String title;
    private  String creatorName;
    private  String creatorAvatar;
    private  Integer followers;
    private  Integer totalCount;
    private  String question_title;
    private  String answerAuthorName;
    private  String answerContent;
    private  Integer voteupCount;
    private  Integer commentCount;
}