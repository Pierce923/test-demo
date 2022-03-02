package com.example.email.service;

import com.example.email.constant.MailVO;

/**
 * 邮件服务
 */
public interface IEmailService {

    // 发送
    String sent(MailVO vo);

}
