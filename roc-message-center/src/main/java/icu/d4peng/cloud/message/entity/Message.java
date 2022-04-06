package icu.d4peng.cloud.message.entity;

import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import icu.d4peng.cloud.message.enums.StatusEnum;
import icu.d4peng.cloud.message.enums.TypeEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <p> Message:实体类
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class Message extends AbstractSuperEntity {
    /**
     * 信息内容
     */
    private String content;
    /**
     * 状态
     */
    private StatusEnum status;
    /**
     * 类型
     */
    private TypeEnum type;

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public Message setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public TypeEnum getType() {
        return type;
    }

    public Message setType(TypeEnum type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("content", content)
                .append("status", status)
                .append("type", type)
                .toString();
    }
}
