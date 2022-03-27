package icu.d4peng.cloud.common.auth.service;

import me.zhyd.oauth.config.AuthDefaultSource;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthUser;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 19:06
 * @description JustAuthService: 认证服务
 */
public interface JustAuthService {

    /**
     * 获得授权地址:返回给前端
     *
     * @param authSource 类型
     * @return 授权地址
     */
    String getAuthorizeUrl(AuthDefaultSource authSource);

    /**
     * 获得登录授权的用户信息
     *
     * @param authSource   类型
     * @param callbackInfo 回调信息
     * @return 用户信息
     */
    AuthUser getUserInfo(AuthDefaultSource authSource, AuthCallback callbackInfo);
}
