package icu.d4peng.cloud.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.common.message.exception.MessageException;
import icu.d4peng.cloud.common.message.service.EmailService;
import icu.d4peng.cloud.common.message.service.SmsService;
import icu.d4peng.cloud.message.dto.EmailMessageDTO;
import icu.d4peng.cloud.message.dto.MessageDTO;
import icu.d4peng.cloud.message.dto.SmsMessageDTO;
import icu.d4peng.cloud.message.entity.Message;
import icu.d4peng.cloud.message.enums.StatusEnum;
import icu.d4peng.cloud.message.enums.TypeEnum;
import icu.d4peng.cloud.message.mapper.MessageMapper;
import icu.d4peng.cloud.message.service.MessageService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> MessageServiceImpl:服务接口实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    private final MessageMapper messageMapper;
    private final EmailService emailService;
    private final SmsService smsService;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMapper, EmailService emailService, SmsService smsService) {
        this.messageMapper = messageMapper;
        this.emailService = emailService;
        this.smsService = smsService;
    }

    @Override
    public ListVO<Message> list(MessageDTO messageDTO) {
        // @formatter:off
        QueryWrapper<Message> queryWrapper = new QueryWrapper<Message>()
                .eq(ObjectUtils.isNotEmpty(messageDTO.getId()),"id", messageDTO.getId())
                .between(ObjectUtils.isNotEmpty(messageDTO.getStartTime()) && ObjectUtils.isNotEmpty(messageDTO.getEndTime()), "create_time", messageDTO.getStartTime(), messageDTO.getEndTime())
                .eq(ObjectUtils.isNotEmpty(messageDTO.getStatus()),"status", messageDTO.getStatus())
                .eq(ObjectUtils.isNotEmpty(messageDTO.getType()),"type", messageDTO.getType());
        // @formatter:on
        this.messageMapper.selectPage(messageDTO, queryWrapper);
        return ListVO.build(1, messageDTO.getRecords());
    }

    @Override
    public ResultVO<Message> detail(Long id) {
        Message message = this.messageMapper.selectById(id);
        return ResultVO.build(200, "OK", message);
    }

    @Override
    public ResultVO<String> delete(Long id) {
        return ResultVO.build(200, "OK", null);
    }

    @Override
    public ResultVO<String> update(MessageDTO dto) {
        return ResultVO.build(200, "OK", null);
    }

    @Override
    public ResultVO<String> sendEmail(EmailMessageDTO emailMessageDTO) {
        Message message = new Message()
                .setStatus(StatusEnum.UNKNOWN)
                .setType(TypeEnum.EMAIL)
                .setContent(JSON.toJSONString(emailMessageDTO));
        this.messageMapper.insert(message);
        try {
            if (StringUtils.isNotBlank(emailMessageDTO.getTemplateName()) &&
                    ObjectUtils.isNotEmpty(emailMessageDTO.getHtmlContext())) {
                this.emailService.sendHtmlEmail(emailMessageDTO.getTo(), emailMessageDTO.getSubject(), emailMessageDTO.getTemplateName(), emailMessageDTO.getHtmlContext());
            } else if (StringUtils.isNotBlank(emailMessageDTO.getTextContext())) {
                this.emailService.sendTextEmail(emailMessageDTO.getTo(), emailMessageDTO.getSubject(), emailMessageDTO.getTextContext());
            } else {
                throw new MessageException("param is error!");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            message.setStatus(StatusEnum.FAILED);
            this.messageMapper.updateById(message);
            throw new MessageException(e);
        }
        message.setStatus(StatusEnum.SUCCESS);
        return ResultVO.build(this.messageMapper.updateById(message), "");
    }

    @Override
    public ResultVO<String> sendSms(SmsMessageDTO smsMessageDTO) {
        Message message = new Message()
                .setStatus(StatusEnum.UNKNOWN)
                .setType(TypeEnum.SMS)
                .setContent(JSON.toJSONString(smsMessageDTO));
        this.messageMapper.insert(message);
        try {
            this.smsService.sendSms(smsMessageDTO.getPhoneNumbers(), smsMessageDTO.getParams());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            message.setStatus(StatusEnum.FAILED);
            this.messageMapper.updateById(message);
            throw new MessageException(e);
        }
        message.setStatus(StatusEnum.SUCCESS);
        return ResultVO.build(this.messageMapper.updateById(message), "");
    }

}
