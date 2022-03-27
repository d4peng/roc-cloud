package icu.d4peng.cloud.common.message;

import icu.d4peng.cloud.common.message.properties.EmailProperties;
import icu.d4peng.cloud.common.message.service.EmailService;
import icu.d4peng.cloud.common.message.service.impl.EmailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.standard.StandardDialect;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.util.Properties;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 15:39
 * @description EmailAutoConfiguration:邮件自动配置
 */
@Configuration
@EnableConfigurationProperties({EmailProperties.class})
@ConditionalOnProperty(prefix = EmailProperties.PREFIX, value = "enabled", havingValue = "true", matchIfMissing = true)
public class EmailAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean({TemplateEngine.class})
    public TemplateEngine templateEngine(EmailProperties emailProperties, @Autowired ResourceLoader resourceLoader) {
        FileTemplateResolver fileTemplateResolver = new FileTemplateResolver();
        fileTemplateResolver.setPrefix(emailProperties.getTemplatePrefix());
        fileTemplateResolver.setSuffix(emailProperties.getTemplateSuffix());
        fileTemplateResolver.setTemplateMode(TemplateMode.HTML);
        fileTemplateResolver.setCacheable(true);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setDialect(new StandardDialect());
        templateEngine.setTemplateResolver(fileTemplateResolver);
        return templateEngine;
    }

    @Bean
    @ConditionalOnMissingBean(JavaMailSender.class)
    public JavaMailSender mailSender(EmailProperties emailProperties) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailProperties.getHost());
        if (emailProperties.getPort() != null) {
            javaMailSender.setPort(emailProperties.getPort());
        }
        javaMailSender.setUsername(emailProperties.getUsername());
        javaMailSender.setPassword(emailProperties.getPassword());
        javaMailSender.setProtocol(emailProperties.getProtocol());
        if (emailProperties.getDefaultEncoding() != null) {
            javaMailSender.setDefaultEncoding(emailProperties.getDefaultEncoding().name());
        }
        if (!emailProperties.getProperties().isEmpty()) {
            Properties tmpProperties = new Properties();
            tmpProperties.putAll(emailProperties.getProperties());
            javaMailSender.setJavaMailProperties(tmpProperties);
        }
        return javaMailSender;
    }

    @Bean
    @ConditionalOnMissingBean({EmailService.class})
    public EmailService emailService(EmailProperties emailProperties, JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        return new EmailServiceImpl(emailProperties, javaMailSender, templateEngine);
    }
}
