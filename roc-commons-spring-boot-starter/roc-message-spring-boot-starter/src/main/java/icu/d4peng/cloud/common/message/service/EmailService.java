package icu.d4peng.cloud.common.message.service;

import java.util.Map;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 15:43
 * @description EmailService:邮件服务实现
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
