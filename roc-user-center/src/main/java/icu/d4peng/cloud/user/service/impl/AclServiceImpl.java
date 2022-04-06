package icu.d4peng.cloud.user.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.captcha.base.Captcha;
import icu.d4peng.cloud.common.captcha.service.CaptchaService;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.AclDTO;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.enums.StatusEnum;
import icu.d4peng.cloud.user.exception.UserException;
import icu.d4peng.cloud.user.mapper.UserMapper;
import icu.d4peng.cloud.user.service.AclService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p> AclServiceImpl:服务实现
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public class AclServiceImpl implements AclService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AclServiceImpl.class);
    private final UserMapper userMapper;
    private final CaptchaService captchaService;

    @Autowired
    public AclServiceImpl(UserMapper userMapper, CaptchaService captchaService) {
        this.userMapper = userMapper;
        this.captchaService = captchaService;
    }

    @Override
    public ResultVO<String> register(AclDTO aclDTO) {
        // TODO
        //validateCode(registerRequest.getUsername(), registerRequest.getCode());

        // @formatter:off
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq("username", aclDTO.getUsername());
        // @formatter:on
        List<User> users = this.userMapper.selectList(queryWrapper);
        if (users != null && users.size() > 0) {
            LOGGER.error("用户已存在,请检查!");
            throw new UserException("用户已存在,请检查!");
        }

        User user = new User().setUsername(aclDTO.getUsername())
                .setPassword(aclDTO.getPassword())
                .setStatus(StatusEnum.NORMAL);
        return ResultVO.build(this.userMapper.insert(user), "");
    }

    @Override
    public ResultVO<String> captcha(AclDTO aclDTO) {
        String username = aclDTO.getUsername();
        Captcha captcha = this.captchaService.getCaptcha();
        LOGGER.info("captcha text is:{}", captcha.text());
        // TODO
        //this.cacheService.getCacheChannel().set(UserConstant.CAPTCHA.value(), cacheId, captcha.text(), false);
        return ResultVO.build(1, captcha.toBase64());
    }

    @Override
    public ResultVO<JSONObject> login(AclDTO aclDTO) {
        // TODO
        //validateCode(loginRequest.getUsername(), loginRequest.getCode());
        // @formatter:off
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>()
                .eq(true,"username", aclDTO.getUsername());
        // @formatter:on
        User user = this.userMapper.selectOne(queryWrapper);
        if (user == null) {
            LOGGER.warn("用户不存在,请检查!");
            throw new UserException("用户不存在,请检查!");
        }
        if (StringUtils.equals(aclDTO.getPassword(), aclDTO.getPassword())) {
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
        return ResultVO.build(1, null);
    }
}
