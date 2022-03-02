package com.example.email.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MailCode implements CodeEnum {

    SUCESS(0, "邮件发送成功"),
    error(1, "邮件发送失败");

    private final int code;
    private final String value;

}
