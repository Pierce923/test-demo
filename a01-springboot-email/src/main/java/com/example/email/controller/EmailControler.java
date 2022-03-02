package com.example.email.controller;

import com.example.email.constant.MailVO;
import com.example.email.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Slf4j
public class EmailControler {

    @Autowired
    private IEmailService emailService;

    /**
     * 发送邮件
     * to[] 接收人
     * cc[] 抄送人
     * subject string
     * content string
     *
     * @param mailVO
     * @return
     */
    @PostMapping("/send")
    public String sendMail(@RequestBody MailVO mailVO) {
        log.info("sendMail-->" + mailVO.toString());
        return emailService.sent(mailVO);
    }

}
