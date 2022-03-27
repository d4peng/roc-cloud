package icu.d4peng.cloud.common.message.service;

import icu.d4peng.cloud.common.message.SmsApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;

@SpringBootTest(classes = {SmsApplication.class})
@ActiveProfiles("email")
public class EmailServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceTest.class);
    private final EmailService emailService;

    @Autowired
    public EmailServiceTest(EmailService emailService) {
        this.emailService = emailService;
    }

    @Test
    public void testTextEmail() {
        this.emailService.sendTextEmail("d4peng@qq.com", "测试邮件", "textEmail");
    }

    @Test
    public void testHtmlEmail() {
        HashMap<String, Object> maps = new HashMap<>();
        maps.put("code", "htmlEmail");
        this.emailService.sendHtmlEmail("d4peng@qq.com", "测试邮件", "default", maps);
    }
}