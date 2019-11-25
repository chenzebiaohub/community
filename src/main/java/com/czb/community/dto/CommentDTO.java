package com.czb.community.dto;

import com.czb.community.model.User;
import lombok.Data;

//评论连接层，进行多表查询
//返回的数据
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long LikeCount;
    private Integer type;
    private Integer commentCount;
    private String content;
    private User user;
}
