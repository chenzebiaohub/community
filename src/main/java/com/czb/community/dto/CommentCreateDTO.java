package com.czb.community.dto;

import com.czb.community.model.User;
import lombok.Data;

//传入的数据
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;

}
