package icu.d4peng.cloud.user.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.service.CaptchaService;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.UserDTO;
import icu.d4peng.cloud.user.dto.CaptchaDTO;
import icu.d4peng.cloud.user.dto.LoginDTO;
import icu.d4peng.cloud.user.dto.RegisterDTO;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.enums.StatusEnum;
import icu.d4peng.cloud.user.exception.UserException;
import icu.d4peng.cloud.user.mapper.UserMapper;
import icu.d4peng.cloud.user.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> UserServiceImpl: 用户服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserMapper userMapper;
    private final CaptchaService captchaService;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, CaptchaService captchaService) {
        this.userMapper = userMapper;
        this.captchaService = captchaService;
    }

    @Override
    public ListVO<User> list(UserDTO userDTO) {
        // @formatter:off
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>()
                .eq(ObjectUtils.isNotEmpty(userDTO.getId()), "id", userDTO.getId())
                .between(ObjectUtils.isNotEmpty(userDTO.getStartTime()) && ObjectUtils.isNotEmpty(userDTO.getEndTime()), "create_time", userDTO.getStartTime(),userDTO.getEndTime())
                .like(StringUtils.isNotBlank(userDTO.getUsername()),"username",userDTO.getUsername())
                .like(StringUtils.isNotBlank(userDTO.getNickName()),"nickName",userDTO.getNickName())
                .like(StringUtils.isNotBlank(userDTO.getPhone()),"phone",userDTO.getPhone())
                ;
        // @formatter:on
        this.userMapper.selectPage(userDTO, userQueryWrapper);
        return ListVO.build(200, "OK", userDTO.getRecords());
    }

    @Override
    public ResultVO<User> detail(Long id) {
        User user = this.userMapper.selectById(id);
        return ResultVO.build(200, "OK", user);
    }

    @Override
    public ResultVO<String> delete(Long id) {
        this.userMapper.deleteById(id);
        return ResultVO.build(200, "OK", "");
    }

    @Override
    public ResultVO<String> update(UserDTO userDTO) {
        // @formatter:off
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>()
                .eq(true,"id", userDTO.getId())
                .set(StringUtils.isNotBlank(userDTO.getUsername()),"username",userDTO.getUsername())
                .set(StringUtils.isNotBlank(userDTO.getNickName()),"nickName",userDTO.getNickName())
                .set(StringUtils.isNotBlank(userDTO.getPhone()),"phone",userDTO.getPhone())
                .set(ObjectUtils.isNotEmpty(userDTO.getStatus()),"status",userDTO.getStatus());
        // @formatter:on
        this.userMapper.update(null, userUpdateWrapper);
        return ResultVO.build(200, "OK", "");
    }

    @Override
    public ResultVO<String> captcha(CaptchaDTO captchaDTO) {
        String username = captchaDTO.getUsername();
        Captcha captcha = this.captchaService.getCaptcha();
        LOGGER.info("captcha text is:{}", captcha.text());
        // TODO
        //this.cacheService.getCacheChannel().set(UserConstant.CAPTCHA.value(), cacheId, captcha.text(), false);
        return ResultVO.build(1, captcha.toBase64());
    }

    @Override
    public ResultVO<String> register(RegisterDTO registerDTO) {
        // TODO
        //validateCode(registerRequest.getUsername(), registerRequest.getCode());

        // @formatter:off
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq("username", registerDTO.getUsername());
        // @formatter:on
        List<User> users = this.userMapper.selectList(queryWrapper);
        if (users != null && users.size() > 0) {
            LOGGER.error("用户已存在,请检查!");
            throw new UserException("用户已存在,请检查!");
        }

        User user = new User().setUsername(registerDTO.getUsername())
                .setPassword(registerDTO.getPassword())
                .setStatus(StatusEnum.NORMAL);
        return ResultVO.build(this.userMapper.insert(user), "");
    }

    @Override
    public ResultVO<JSONObject> login(LoginDTO loginDTO) {
        // TODO
        //validateCode(loginRequest.getUsername(), loginRequest.getCode());
        // @formatter:off
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq(true,"username", loginDTO.getUsername());
        // @formatter:on
        User user = this.userMapper.selectOne(queryWrapper);
        if (user == null) {
            LOGGER.warn("用户不存在,请检查!");
            throw new UserException("用户不存在,请检查!");
        }
        if (StringUtils.equals(loginDTO.getPassword(), loginDTO.getPassword())) {
            LOGGER.warn("密码不正确,请检查!");
            throw new UserException("密码不正确,请检查!");
        }
        if (user.getStatus() == StatusEnum.DISABLE) {
            LOGGER.warn("该用户被禁用,请检查!");
            throw new UserException("该用户被禁用,请检查!");
        }

        StpUtil.login(user.getId());
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();

        return ResultVO.build(1, ((JSONObject) JSONObject.toJSON(tokenInfo)));
    }

    @Override
    public ResultVO<String> info(Long id) {
        return ResultVO.build(1, StpUtil.getTokenValueByLoginId(id));
    }

    @Override
    public ResultVO<String> logout(Long id) {
        StpUtil.logout(id);
        return ResultVO.build(1, "");
    }
}
