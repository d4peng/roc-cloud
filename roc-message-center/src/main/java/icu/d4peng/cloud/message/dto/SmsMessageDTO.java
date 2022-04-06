package icu.d4peng.cloud.message.dto;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;

/**
 * <p> SmsMessageDTO:短信DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class SmsMessageDTO {
    // 发送参数
    /**
     * 手机号
     */
    private Collection<String> phoneNumbers;
    /**
     * 发送参数
     */
    private JSONObject params;

    public Collection<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public SmsMessageDTO setPhoneNumbers(Collection<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public JSONObject getParams() {
        return params;
    }

    public SmsMessageDTO setParams(JSONObject params) {
        this.params = params;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("phoneNumbers", phoneNumbers)
                .append("params", params)
                .toString();
    }
}
