package com.czb.community.dto;

import com.czb.community.model.User;
import lombok.Data;

//传输层
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    public User user;
}
