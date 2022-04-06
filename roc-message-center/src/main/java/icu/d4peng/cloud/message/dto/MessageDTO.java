package icu.d4peng.cloud.message.dto;

import icu.d4peng.cloud.common.db.request.SuperDTO;
import icu.d4peng.cloud.message.entity.Message;
import icu.d4peng.cloud.message.enums.StatusEnum;
import icu.d4peng.cloud.message.enums.TypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> MessageDTO:信息DTO
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class MessageDTO extends SuperDTO<Message> {
    /**
     * 状态
     */
    private StatusEnum status;
    /**
     * 类型
     */
    private TypeEnum type;

    public StatusEnum getStatus() {
        return status;
    }

    public MessageDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public TypeEnum getType() {
        return type;
    }

    public MessageDTO setType(TypeEnum type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("type", type)
                .toString();
    }
}
