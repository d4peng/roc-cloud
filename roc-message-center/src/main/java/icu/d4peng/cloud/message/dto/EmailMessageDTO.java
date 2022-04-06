package icu.d4peng.cloud.message.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Map;

/**
 * <p> EmailMessageDTO:邮件DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class EmailMessageDTO {
    /**
     * 对象
     */
    private String to;
    /**
     * 主题
     */
    private String subject;
    /**
     * 默认名称(HTML)
     */
    private String templateName;
    /**
     * HTML内容(HTML)
     */
    private Map<String, Object> htmlContext;
    /**
     * 文件内容(文本)
     */
    private String textContext;

    public String getTo() {
        return to;
    }

    public EmailMessageDTO setTo(String to) {
        this.to = to;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public EmailMessageDTO setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getTemplateName() {
        return templateName;
    }

    public EmailMessageDTO setTemplateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public Map<String, Object> getHtmlContext() {
        return htmlContext;
    }

    public EmailMessageDTO setHtmlContext(Map<String, Object> htmlContext) {
        this.htmlContext = htmlContext;
        return this;
    }

    public String getTextContext() {
        return textContext;
    }

    public EmailMessageDTO setTextContext(String textContext) {
        this.textContext = textContext;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("to", to)
                .append("subject", subject)
                .append("templateName", templateName)
                .append("htmlContext", htmlContext)
                .append("textContext", textContext)
                .toString();
    }
}
