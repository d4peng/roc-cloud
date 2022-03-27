package icu.d4peng.cloud.common.message.service.impl;

import icu.d4peng.cloud.common.message.properties.EmailProperties;
import icu.d4peng.cloud.common.message.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 15:43
 * @description EmailServiceImpl:邮件服务实现
 */
public class EmailServiceImpl implements EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;
    private final EmailProperties emailProperties;
    // 信息
    private final MimeMessage mimeMessage;
    // 信息助手
    private final MimeMessageHelper mimeMessageHelper;

    public EmailServiceImpl(EmailProperties emailProperties, JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.emailProperties = emailProperties;
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;

        this.mimeMessage = this.javaMailSender.createMimeMessage();
        try {
            this.mimeMessageHelper = new MimeMessageHelper(this.mimeMessage, true);
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }

    public void sendTextEmail(String to, String subject, String context) {
        try {
            this.mimeMessageHelper.setTo(to);
            this.mimeMessageHelper.setSubject(subject);
            this.mimeMessageHelper.setText(context, false);
            this.mimeMessageHelper.setFrom(this.emailProperties.getUsername());
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
        this.javaMailSender.send(this.mimeMessage);
        this.javaMailSender.send(this.mimeMessage);
    }

    public void sendHtmlEmail(String to, String subject, String templateName, Map<String, Object> context) {
        try {
            this.mimeMessageHelper.setTo(to);
            this.mimeMessageHelper.setSubject(subject);
            this.mimeMessageHelper.setText(mapConvertTemplate(templateName, context), true);
            this.mimeMessageHelper.setFrom(this.emailProperties.getUsername());
        } catch (MessagingException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
        this.javaMailSender.send(this.mimeMessage);
        this.javaMailSender.send(this.mimeMessage);
    }

    /**
     * map变成template里面属性
     *
     * @param templateName 模板名称
     * @param map          map里面的值
     * @return 解析HTML后的值
     */
    private String mapConvertTemplate(String templateName, Map<String, Object> map) {
        Context context = new Context();
        context.setVariables(map);
        return this.templateEngine.process(templateName, context);
    }

}