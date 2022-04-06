package icu.d4peng.cloud.user.service;

import com.alibaba.fastjson.JSONObject;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.AclDTO;

/**
 * <p> AclService:服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
public interface AclService {
    /**
     * 验证码
     *
     * @param aclDTO 权限DTO
     * @return 验证码的base64
     */
    ResultVO<String> captcha(AclDTO aclDTO);

    /**
     * 注册
     *
     * @param aclDTO 权限DTO
     * @return 注册结果
     */
    ResultVO<String> register(AclDTO aclDTO);

    /**
     * 登录
     *
     * @param aclDTO 权限DTO
     * @return token信息
     */
    ResultVO<JSONObject> login(AclDTO aclDTO);

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
