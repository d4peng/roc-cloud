package icu.d4peng.cloud.common.auth.sa;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 09:45
 * @description SaPathMatcherHolder:路径匹配Holder
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
