package icu.d4peng.cloud.user.service;

import com.alibaba.fastjson.JSONObject;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.common.db.service.BaseService;
import icu.d4peng.cloud.user.dto.UserDTO;
import icu.d4peng.cloud.user.dto.CaptchaDTO;
import icu.d4peng.cloud.user.dto.LoginDTO;
import icu.d4peng.cloud.user.dto.RegisterDTO;
import icu.d4peng.cloud.user.entity.User;

/**
 * <p> UserService: 用户服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-04-08
 */
public interface UserService extends BaseService<User, UserDTO, Long> {
    /**
     * 验证码
     *
     * @param captchaDTO 验证码DTO
     * @return 验证码的base64
     */
    ResultVO<String> captcha(CaptchaDTO captchaDTO);

    /**
     * 注册
     *
     * @param registerDTO 注册DTO
     * @return 注册结果
     */
    ResultVO<String> register(RegisterDTO registerDTO);

    /**
     * 登录
     *
     * @param loginDTO 登录DTO
     * @return token信息
     */
    ResultVO<JSONObject> login(LoginDTO loginDTO);

    /**
     * 用户信息
     *
     * @param id 用户ID
     * @return 用户Token信息
     */
    ResultVO<String> info(Long id);

    /**
     * 登出
     *
     * @param id 用户ID
     * @return 登出信息
     */
    ResultVO<String> logout(Long id);
}
