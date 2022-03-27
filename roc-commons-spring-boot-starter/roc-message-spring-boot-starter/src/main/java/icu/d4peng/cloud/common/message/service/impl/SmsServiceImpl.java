package icu.d4peng.cloud.common.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsRequest;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import icu.d4peng.cloud.common.core.constants.BaseConstant;
import icu.d4peng.cloud.common.message.properties.SmsProperties;
import icu.d4peng.cloud.common.message.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * <p> SmsServiceImpl:短信服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SmsServiceImpl implements SmsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);
    private final SmsProperties smsProperties;
    private final Client client;

    public SmsServiceImpl(SmsProperties smsProperties) {
        this.smsProperties = smsProperties;
        try {
            Config config = new Config().setAccessKeyId(this.smsProperties.getAccessKeyId())
                    .setAccessKeySecret(this.smsProperties.getAccessKeySecret())
                    .setEndpoint("dysmsapi.aliyuncs.com");
            this.client = new Client(config);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }
    @Override
    public void sendSms(Collection<String> phoneNumbers, JSONObject templateParam) {
        String targetPhoneNumbers = String.join(",", phoneNumbers);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(targetPhoneNumbers)
                .setSignName(this.smsProperties.getSignName())
                .setTemplateCode(this.smsProperties.getTemplateCode())
                .setTemplateParam(templateParam.toJSONString());
        SendSmsResponse sendSmsResponse = null;
        try {
            sendSmsResponse = this.client.sendSms(sendSmsRequest);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
        if (!sendSmsResponse.getBody().getCode().equals(BaseConstant.SUCCESS.getDesc())) {
            String msg = JSON.toJSONString(sendSmsResponse.getBody());
            LOGGER.error("send sms error:" + msg);
            throw new RuntimeException(msg);
        }
    }
    @Override
    public JSONObject querySms(String phoneNumber, LocalDateTime sendDate) {
        if (sendDate == null) {
            sendDate = LocalDateTime.now();
        }
        QuerySendDetailsRequest querySendDetailsRequest = new QuerySendDetailsRequest()
                .setPhoneNumber(phoneNumber)
                .setSendDate(sendDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")))
                .setCurrentPage(1L)
                .setPageSize(50L);
        QuerySendDetailsResponse querySendDetailsResponse = null;
        try {
            querySendDetailsResponse = this.client.querySendDetails(querySendDetailsRequest);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e.getCause());
        }
        if (!querySendDetailsResponse.getBody().getCode().equals(BaseConstant.SUCCESS.getDesc())) {
            String msg = JSON.toJSONString(querySendDetailsResponse.getBody());
            LOGGER.error("query sms error:" + msg);
            throw new RuntimeException(msg);
        } else {
            return (JSONObject) JSONObject.toJSON(querySendDetailsResponse.getBody().getSmsSendDetailDTOs());
        }
    }

}
