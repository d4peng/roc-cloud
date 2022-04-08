package icu.d4peng.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.RoleDTO;
import icu.d4peng.cloud.user.entity.Role;
import icu.d4peng.cloud.user.mapper.RoleMapper;
import icu.d4peng.cloud.user.service.RoleService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> RoleServiceImpl: RoleService实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public ListVO<Role> list(RoleDTO roleDTO) {
        // @formatter:off
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<Role>()
                .eq(ObjectUtils.isNotEmpty(roleDTO.getId()), "id", roleDTO.getId())
                .between(ObjectUtils.isNotEmpty(roleDTO.getStartTime()) && ObjectUtils.isNotEmpty(roleDTO.getEndTime()), "create_time", roleDTO.getStartTime(),roleDTO.getEndTime())
                .eq(StringUtils.isNotBlank(roleDTO.getName()),"name",roleDTO.getName())
                ;
        // @formatter:on
        this.roleMapper.selectPage(roleDTO, roleQueryWrapper);
        return ListVO.build(200, "OK", roleDTO.getRecords());
    }

    @Override
    public ResultVO<Role> detail(Long id) {
        Role role = this.roleMapper.selectById(id);
        return ResultVO.build(200, "OK", role);
    }

    @Override
    public ResultVO<String> delete(Long id) {
        this.roleMapper.deleteById(id);
        return ResultVO.build(200, "OK", "");
    }

    @Override
    public ResultVO<String> update(RoleDTO roleDTO) {
        // @formatter:off
        UpdateWrapper<Role> roleUpdateWrapper = new UpdateWrapper<Role>()
                .eq(true,"id", roleDTO.getId())
                .set(StringUtils.isNotEmpty(roleDTO.getName()),"name",roleDTO.getName());
        // @formatter:on
        this.roleMapper.update(null, roleUpdateWrapper);
        return ResultVO.build(200, "OK", "");
    }
}
