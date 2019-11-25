package com.czb.community.mapper;

import com.czb.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    //新增语句，阅读量+1
    int incView(Question record);

    int incCommentCount(Question record);

    //
    List<Question> selectRelated(Question question);
//
//    Integer countBySearch(QuestionQueryDTO questionQueryDTO);
//
//    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}
