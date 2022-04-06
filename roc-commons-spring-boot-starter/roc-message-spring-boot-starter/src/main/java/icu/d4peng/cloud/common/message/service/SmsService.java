package icu.d4peng.cloud.common.message.service;

import com.alibaba.fastjson.JSONObject;

import java.util.Collection;

/**
 * <p> SmsService:短信服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface SmsService {
    /**
     * 发送短信
     *
     * @param phoneNumbers  手机号,使用,分割
     * @param templateParam 模板值
     */
    void sendSms(Collection<String> phoneNumbers, JSONObject templateParam);

}
