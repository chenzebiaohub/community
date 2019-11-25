package com.czb.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    ERROR_CODE(2000, "error为0"),
    QUESTION_NOT_FOUND(2001, "你找的问题不存在？换一个试试"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论进行回复"),
    NOT_LOGIN(2003, "未登录不能进行评论,请先登录"),
    SYS_ERROR(2004, "服务出错了，稍后请重试！！"),
    TYPE_PARAM_WRONG(2005, "评论类型不确定"),
    COMMENT_NO_FIND(2006, "回复的评论找不到"),
    QUESTION_NO_FIND(2007, "回复的问题找不到"),
    COMMENT_IS_EMPTY(2008, "消息不翼而飞"),
    NOTIFICATION_IS_EMPTY(2010, "输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2009, "用户id不匹配");


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
