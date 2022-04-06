package icu.d4peng.cloud.message.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.d4peng.cloud.message.entity.Message;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> MessageMapper:Mapper
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
