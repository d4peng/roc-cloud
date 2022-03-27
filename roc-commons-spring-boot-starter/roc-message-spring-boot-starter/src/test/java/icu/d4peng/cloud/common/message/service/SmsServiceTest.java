package icu.d4peng.cloud.common.message.service;

import com.alibaba.fastjson.JSONObject;
import icu.d4peng.cloud.common.message.SmsApplication;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest(classes = {SmsApplication.class})
@ActiveProfiles("sms")
public class SmsServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsServiceTest.class);
    private final SmsService smsService;

    @Autowired
    public SmsServiceTest(SmsService smsService) {
        this.smsService = smsService;
    }

    @Test
    public void testSendSms() {
        Collection<String> collections = new ArrayList<String>();
        collections.add("17719444996");

        JSONObject params = new JSONObject();
        params.put("code", "4396");
        this.smsService.sendSms(collections, params);
    }

    @Test
    public void testQuerySms() {
        System.out.println(this.smsService.querySms("17719444996", LocalDateTime.now()));
    }
}