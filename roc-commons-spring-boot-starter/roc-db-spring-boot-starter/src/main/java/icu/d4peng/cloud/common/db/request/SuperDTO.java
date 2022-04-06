package icu.d4peng.cloud.common.db.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

/**
 * <p> SuperDTO:父类请求(用于构造列表)
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SuperDTO<T> extends PageDTO<T> {
    /**
     * 查询ID
     */
    private Long id;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;

    public Long getId() {
        return id;
    }

    public SuperDTO<T> setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public SuperDTO<T> setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public SuperDTO<T> setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("startTime", startTime).append("endTime", endTime).toString();
    }
}
