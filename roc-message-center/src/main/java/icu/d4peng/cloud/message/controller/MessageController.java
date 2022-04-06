package icu.d4peng.cloud.message.controller;

import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.message.dto.EmailMessageDTO;
import icu.d4peng.cloud.message.dto.MessageDTO;
import icu.d4peng.cloud.message.dto.SmsMessageDTO;
import icu.d4peng.cloud.message.entity.Message;
import icu.d4peng.cloud.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> MessageController:控制器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public ListVO<Message> list(MessageDTO messageDTO) {
        return this.messageService.list(messageDTO);
    }

    @GetMapping("/{id}")
    public ResultVO<Message> detail(@PathVariable Long id) {
        return this.messageService.detail(id);
    }

    @PostMapping("/email")
    public ResultVO<String> sendEmail(@RequestBody EmailMessageDTO emailMessageDTO) {
        return this.messageService.sendEmail(emailMessageDTO);
    }

    @PostMapping("/sms")
    public ResultVO<String> sendSms(@RequestBody SmsMessageDTO smsMessageDTO) {
        return this.messageService.sendSms(smsMessageDTO);
    }

}
