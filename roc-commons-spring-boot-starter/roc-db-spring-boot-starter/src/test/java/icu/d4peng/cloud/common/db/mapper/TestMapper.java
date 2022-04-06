package icu.d4peng.cloud.common.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.d4peng.cloud.common.db.entity.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p> TestMapper:测试Mapper
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Mapper
public interface TestMapper extends BaseMapper<Test> {
}
