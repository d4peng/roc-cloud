package icu.d4peng.cloud.common.auth.service.impl;

import com.alibaba.fastjson.JSON;
import icu.d4peng.cloud.common.auth.properties.JustAuthProperties;
import icu.d4peng.cloud.common.auth.service.JustAuthService;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.config.AuthDefaultSource;
import me.zhyd.oauth.enums.AuthResponseStatus;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.*;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 18:34
 * @description JustAuthServiceImpl:Auth服务实现
 */
public class JustAuthServiceImpl implements JustAuthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(JustAuthServiceImpl.class);
    /**
     * 属性
     */
    private final JustAuthProperties justAuthProperties;

    public JustAuthServiceImpl(JustAuthProperties justAuthProperties) {
        this.justAuthProperties = justAuthProperties;
    }

    @Override
    public String getAuthorizeUrl(AuthDefaultSource authDefaultSource) {
        return getAuthRequest(authDefaultSource).authorize(AuthStateUtils.createState());
    }

    @Override
    public AuthUser getUserInfo(AuthDefaultSource authDefaultSource, AuthCallback callbackInfo) {
        AuthResponse<?> response = getAuthRequest(authDefaultSource).login(callbackInfo);
        if (response.getCode() == AuthResponseStatus.SUCCESS.getCode()) {
            AuthUser authUser = JSON.parseObject(JSON.toJSONString(response.getData()), AuthUser.class);
            LOGGER.info(JSON.toJSONString(response.getData()));
            return authUser;
        } else {
            LOGGER.error(response.getMsg());
            throw new AuthException(response.getMsg());
        }
    }

    /**
     * 通过类型获得对应的请求
     *
     * @param authSourceType 类型
     * @return 请求
     */
    private AuthRequest getAuthRequest(AuthDefaultSource authSourceType) {
        AuthConfig authConfig = this.justAuthProperties.getTypes().get(authSourceType);
        if (authConfig == null) {
            LOGGER.error("auth not config,please check config!");
            throw new AuthException("auth not config,please check config!");
        }
        switch (authSourceType) {
            case GITHUB:
                return new AuthGithubRequest(authConfig);
            case WEIBO:
                return new AuthWeiboRequest(authConfig);
            case GITEE:
                return new AuthGiteeRequest(authConfig);
            case DINGTALK:
                return new AuthDingTalkRequest(authConfig);
            case BAIDU:
                return new AuthBaiduRequest(authConfig);
            case CODING:
                return new AuthCodingRequest(authConfig);
            case OSCHINA:
                return new AuthOschinaRequest(authConfig);
            case QQ:
                return new AuthQqRequest(authConfig);
            case TAOBAO:
                return new AuthTaobaoRequest(authConfig);
            case GOOGLE:
                return new AuthGoogleRequest(authConfig);
            case FACEBOOK:
                return new AuthFacebookRequest(authConfig);
            case DOUYIN:
                return new AuthDouyinRequest(authConfig);
            case LINKEDIN:
                return new AuthLinkedinRequest(authConfig);
            case MICROSOFT:
                return new AuthMicrosoftRequest(authConfig);
            case MI:
                return new AuthMiRequest(authConfig);
            case TOUTIAO:
                return new AuthToutiaoRequest(authConfig);
            case TEAMBITION:
                return new AuthTeambitionRequest(authConfig);
            case RENREN:
                return new AuthRenrenRequest(authConfig);
            case PINTEREST:
                return new AuthPinterestRequest(authConfig);
            case STACK_OVERFLOW:
                return new AuthStackOverflowRequest(authConfig);
            default:
                throw new AuthException("auth type is null,please check!");
        }
    }
}
