package icu.d4peng.cloud.common.db.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import icu.d4peng.cloud.common.db.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-01-01 11:15
 * @description SuperRequest:父类请求(用于构造列表)
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class SuperRequest<T> extends PageDTO<T> {
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
    /**
     * 状态
     */
    private StatusEnum status;

}
