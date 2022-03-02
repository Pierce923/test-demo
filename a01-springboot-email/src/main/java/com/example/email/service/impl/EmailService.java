package com.example.email.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.email.constant.MailCode;
import com.example.email.constant.MailVO;
import com.example.email.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService implements IEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String sent(MailVO mailVO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mailVO.getTo());
        mailMessage.setCc(mailVO.getCc());
        mailMessage.setSubject(mailVO.getSubject());
        mailMessage.setText(mailVO.getContent());
        mailMessage.setFrom(mailVO.getSender());
        try {
            mailSender.send(mailMessage);
            return JSON.toJSONString(MailCode.SUCESS.getCode() + " " + MailCode.SUCESS.getValue());
        } catch (Exception e) {
            log.info("EmailService " + e.getMessage());
            return JSON.toJSONString(e.getMessage());
        }
    }

}
