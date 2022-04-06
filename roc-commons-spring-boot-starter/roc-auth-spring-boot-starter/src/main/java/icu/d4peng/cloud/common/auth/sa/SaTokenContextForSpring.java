package icu.d4peng.cloud.common.auth.sa;

import cn.dev33.satoken.context.SaTokenContext;
import cn.dev33.satoken.context.model.SaRequest;
import cn.dev33.satoken.context.model.SaResponse;
import cn.dev33.satoken.context.model.SaStorage;
import cn.dev33.satoken.servlet.model.SaRequestForServlet;
import cn.dev33.satoken.servlet.model.SaResponseForServlet;
import cn.dev33.satoken.servlet.model.SaStorageForServlet;
import icu.d4peng.cloud.common.auth.utils.SpringMvcUtil;

/**
 * <p> SaTokenContextForSpring: Spring上下文配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SaTokenContextForSpring implements SaTokenContext {
    @Override
    public SaRequest getRequest() {
        return new SaRequestForServlet(SpringMvcUtil.getRequest());
    }

    @Override
    public SaResponse getResponse() {
        return new SaResponseForServlet(SpringMvcUtil.getResponse());
    }

    @Override
    public SaStorage getStorage() {
        return new SaStorageForServlet(SpringMvcUtil.getRequest());
    }

    @Override
    public boolean matchPath(String pattern, String path) {
        return SaPathMatcherHolder.getPathMatcher().match(pattern, path);
    }

    @Override
    public boolean isValid() {
        return SpringMvcUtil.isWeb();
    }
}
