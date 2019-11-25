package com.czb.community.controller;

import com.czb.community.dto.NotificationDTO;
import com.czb.community.dto.PaginationDTO;
import com.czb.community.enums.NotificationTypeEnum;
import com.czb.community.model.User;
import com.czb.community.service.NotificationService;
import com.czb.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    //action动态切换路径去更换信息
    @GetMapping("/notification/{id}")
    public String profile(HttpServletRequest request,
                          @PathVariable(name = "id") Long id) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        NotificationDTO notificationDTO=notificationService.read(id,user);
        System.out.println("notificationDTO.getType()"+notificationDTO.getType());
        System.out.println("getType()"+NotificationTypeEnum.REPLY_COMMENT.getType());
        if (NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType() || NotificationTypeEnum.REPLY_QUESTION.getType() == notificationDTO.getType()){
              return "redirect:/question/"+notificationDTO.getOuterid();

        }else {
            return "redirect:/";
        }
    }

}
