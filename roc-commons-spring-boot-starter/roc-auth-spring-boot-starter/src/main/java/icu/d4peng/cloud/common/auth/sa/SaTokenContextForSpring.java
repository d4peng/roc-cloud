package icu.d4peng.cloud.common.auth.sa;

import cn.dev33.satoken.context.SaTokenContext;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.servlet.model.SaRequestForServlet;
import cn.dev33.satoken.servlet.model.SaResponseForServlet;
import cn.dev33.satoken.servlet.model.SaStorageForServlet;
import icu.d4peng.cloud.common.auth.utils.SpringMVCUtil;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 09:41
 * @description SaTokenContextForSpring: Spring上下文配置
 */
public class SaTokenContextForSpring implements SaTokenContext {

    public SaRequest getRequest() {
        return new SaRequestForServlet(SpringMVCUtil.getRequest());
    }

    public SaResponse getResponse() {
        return new SaResponseForServlet(SpringMVCUtil.getResponse());
    }

    public SaStorage getStorage() {
        return new SaStorageForServlet(SpringMVCUtil.getRequest());
    }

    public boolean matchPath(String pattern, String path) {
        return SaPathMatcherHolder.getPathMatcher().match(pattern, path);
    }

    public boolean isValid() {
        return SpringMVCUtil.isWeb();
    }
}
