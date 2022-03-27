package icu.d4peng.cloud.common.message.service;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-19 15:58
 * @description SmsService:短信服务
 */
public interface SmsService {
    /**
     * 发送短信
     *
     * @param phoneNumbers  手机号,使用,分割
     * @param templateParam 模板值
     */
    void sendSms(Collection<String> phoneNumbers, JSONObject templateParam);

    /**
     * 查询某个手机在某天发送的前最近50条短信
     *
     * @param phoneNumber 手机号
     * @param sendDate    发送日期,可以传空,就是当天
     * @return 查询的结果为JSON字符串
     */
    JSONObject querySms(String phoneNumber, LocalDateTime sendDate);
}
