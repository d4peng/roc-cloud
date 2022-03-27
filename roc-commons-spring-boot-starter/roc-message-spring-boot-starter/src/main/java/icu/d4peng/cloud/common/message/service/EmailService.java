package icu.d4peng.cloud.common.message.service;

import java.util.Map;

/**
 * <p> EmailService:邮件服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface EmailService {
    /**
     * 发送文本邮件
     *
     * @param to      发给谁
     * @param subject 主题
     * @param context 内容
     */
    void sendTextEmail(String to, String subject, String context);

    /**
     * 发送HTML邮件
     *
     * @param to           发给谁
     * @param subject      主题
     * @param templateName 模板名称
     * @param context      内容
     */
    void sendHtmlEmail(String to, String subject, String templateName, Map<String, Object> context);
}
