package com.czb.community.controller;

import com.czb.community.dto.CommentDTO;
import com.czb.community.dto.QuestionDTO;
import com.czb.community.enums.CommentTypeEnum;
import com.czb.community.service.CommentService;
import com.czb.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;


    @GetMapping("/question/{id}")//{id}数据可以在下面直接调用
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comment = commentService.listByTagId(id, CommentTypeEnum.QUESTION);
        //增加累加阅读数
        questionService.intView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comment", comment);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
