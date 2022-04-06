package icu.d4peng.cloud.message.service;

import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.common.db.service.BaseService;
import icu.d4peng.cloud.message.dto.EmailMessageDTO;
import icu.d4peng.cloud.message.dto.MessageDTO;
import icu.d4peng.cloud.message.dto.SmsMessageDTO;
import icu.d4peng.cloud.message.entity.Message;

/**
 * <p> MessageService:服务接口
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public interface MessageService extends BaseService<Message, MessageDTO, Long> {
    /**
     * 发送邮件
     *
     * @param emailMessageDTO 请求
     * @return true:成功,false失败
     */

    ResultVO<String> sendEmail(EmailMessageDTO emailMessageDTO);

    /**
     * 发送短信
     *
     * @param smsMessageDTO 请求
     * @return true:成功,false失败
     */
    ResultVO<String> sendSms(SmsMessageDTO smsMessageDTO);

}