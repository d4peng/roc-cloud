package icu.d4peng.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.common.db.service.BaseService;
import icu.d4peng.cloud.user.dto.BaseDTO;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.mapper.UserMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> BaseServiceImpl:服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@Service
public class BaseServiceImpl implements BaseService<User, BaseDTO, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);
    private final UserMapper userMapper;

    @Autowired
    public BaseServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ListVO<User> list(BaseDTO baseDTO) {
        // @formatter:off
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .eq(ObjectUtils.isNotEmpty(baseDTO.getId()), "id", baseDTO.getId())
                .between(ObjectUtils.isNotEmpty(baseDTO.getStartTime()) && ObjectUtils.isNotEmpty(baseDTO.getEndTime()), "create_time", baseDTO.getStartTime(),baseDTO.getEndTime())
                .like(StringUtils.isNotBlank(baseDTO.getUsername()),"username",baseDTO.getUsername())
                .like(StringUtils.isNotBlank(baseDTO.getNickName()),"nickName",baseDTO.getNickName())
                .like(StringUtils.isNotBlank(baseDTO.getPhone()),"phone",baseDTO.getPhone())
                ;
        // @formatter:on
        this.userMapper.selectPage(baseDTO, userQueryWrapper);
        return ListVO.build(200, "OK", baseDTO.getRecords());
    }

    @Override
    public ResultVO<User> detail(Long id) {
        User user = this.userMapper.selectById(id);
        return ResultVO.build(200, "OK", user);
    }

    @Override
    public ResultVO<String> delete(Long id) {
        this.userMapper.deleteById(id);
        return ResultVO.build(200, "OK", null);
    }

    @Override
    public ResultVO<String> update(BaseDTO baseDTO) {
        // @formatter:off
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>()
                .eq(true,"id", baseDTO.getId())
                .set(StringUtils.isNotBlank(baseDTO.getUsername()),"username",baseDTO.getUsername())
                .set(StringUtils.isNotBlank(baseDTO.getNickName()),"nickName",baseDTO.getNickName())
                .set(StringUtils.isNotBlank(baseDTO.getPhone()),"phone",baseDTO.getPhone())
                .set(ObjectUtils.isNotEmpty(baseDTO.getStatus()),"status",baseDTO.getStatus());
        // @formatter:on
        this.userMapper.update(null, userUpdateWrapper);
        return ResultVO.build(200, "OK", null);
    }
}
