package icu.d4peng.cloud.common.auth.sa;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * <p> SaPathMatcherHolder:路径匹配Holder
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class SaPathMatcherHolder {
    public static PathMatcher pathMatcher;

    public static PathMatcher getPathMatcher() {
        if (pathMatcher == null) {
            pathMatcher = new AntPathMatcher();
        }
        return pathMatcher;
    }

    public static void setPathMatcher(PathMatcher pathMatcher) {
        SaPathMatcherHolder.pathMatcher = pathMatcher;
    }
}
