package icu.d4peng.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.PermissionDTO;
import icu.d4peng.cloud.user.entity.Permission;
import icu.d4peng.cloud.user.mapper.PermissionMapper;
import icu.d4peng.cloud.user.service.PermissionService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> PermissionServiceImpl: 权限服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public ListVO<Permission> list(PermissionDTO permissionDTO) {
        // @formatter:off
        QueryWrapper<Permission> permissionQueryWrapper = new QueryWrapper<Permission>()
                .eq(ObjectUtils.isNotEmpty(permissionDTO.getId()), "id", permissionDTO.getId())
                .between(ObjectUtils.isNotEmpty(permissionDTO.getStartTime()) && ObjectUtils.isNotEmpty(permissionDTO.getEndTime()), "create_time", permissionDTO.getStartTime(),permissionDTO.getEndTime())
                .eq(StringUtils.isNotBlank(permissionDTO.getName()),"name",permissionDTO.getName())
                ;
        // @formatter:on
        this.permissionMapper.selectPage(permissionDTO, permissionQueryWrapper);
        return ListVO.build(200, "OK", permissionDTO.getRecords());
    }

    @Override
    public ResultVO<Permission> detail(Long id) {
        Permission permission = this.permissionMapper.selectById(id);
        return ResultVO.build(200, "OK", permission);
    }

    @Override
    public ResultVO<String> delete(Long id) {
        this.permissionMapper.deleteById(id);
        return ResultVO.build(200, "OK", "");
    }

    @Override
    public ResultVO<String> update(PermissionDTO permissionDTO) {
        // @formatter:off
        UpdateWrapper<Permission> permissionUpdateWrapper = new UpdateWrapper<Permission>()
                .eq(true,"id", permissionDTO.getId())
                .set(StringUtils.isNotEmpty(permissionDTO.getName()),"name",permissionDTO.getName());
        // @formatter:on
        this.permissionMapper.update(null, permissionUpdateWrapper);
        return ResultVO.build(200, "OK", "");
    }
}
