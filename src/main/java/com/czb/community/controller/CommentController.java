package com.czb.community.controller;

import com.czb.community.dto.CommentCreateDTO;
import com.czb.community.dto.CommentDTO;
import com.czb.community.dto.ResultDTO;
import com.czb.community.enums.CommentTypeEnum;
import com.czb.community.exception.CustomizeErrorCode;
import com.czb.community.model.Comment;
import com.czb.community.model.User;
import com.czb.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(HttpServletRequest request, @RequestBody CommentCreateDTO commentCreateDTO) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NOT_LOGIN);
        }
        // StringUtils新插件判断是否为空
        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.COMMENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.create(comment,user);
        return ResultDTO.OkOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)//获得点击评论的id
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id") Long id) {
        List<CommentDTO> commentDTOS = commentService.listByTagId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.OkOf(commentDTOS);
    }
}
