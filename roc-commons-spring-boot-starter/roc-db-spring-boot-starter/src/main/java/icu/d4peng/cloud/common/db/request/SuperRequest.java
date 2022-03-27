package icu.d4peng.cloud.common.db.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import icu.d4peng.cloud.common.db.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p> SuperRequest:父类请求(用于构造列表)
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
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
