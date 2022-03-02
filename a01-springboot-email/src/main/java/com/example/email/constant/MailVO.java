package com.example.email.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailVO implements Serializable {

    /**
     * 收件人
     */
    private String[] to;

    /**
     * 发件人
     */
    private String sender;

    /**
     * 抄送人
     */
    private String[] cc;

    /**
     * 密送人
     */
    private String[] secret;

    /**
     * 主题
     */
    private String subject;

    /**
     * 内容
     */
    private String content;


}
