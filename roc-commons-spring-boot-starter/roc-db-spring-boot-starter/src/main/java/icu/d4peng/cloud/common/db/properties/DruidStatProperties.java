package icu.d4peng.cloud.common.db.properties;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p> DruidStatProperties:数据库监控配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConfigurationProperties(prefix = DruidStatProperties.PREFIX)
public class DruidStatProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "roc.db.druid.stat";
    private StatViewServlet statViewServlet = new StatViewServlet();
    private WebStatFilter webStatFilter = new WebStatFilter();

    public StatViewServlet getStatViewServlet() {
        return statViewServlet;
    }

    public DruidStatProperties setStatViewServlet(StatViewServlet statViewServlet) {
        this.statViewServlet = statViewServlet;
        return this;
    }

    public WebStatFilter getWebStatFilter() {
        return webStatFilter;
    }

    public DruidStatProperties setWebStatFilter(WebStatFilter webStatFilter) {
        this.webStatFilter = webStatFilter;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("statViewServlet", statViewServlet)
                .append("webStatFilter", webStatFilter)
                .toString();
    }

    public static class StatViewServlet {
        private boolean enabled = true;
        private String urlPattern = "/druid/*";
        private String allow = "127.0.0.1";
        private String deny;
        private String loginUsername = "roc";
        private String loginPassword = "roc";
        private String resetEnable = "true";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getUrlPattern() {
            return urlPattern;
        }

        public void setUrlPattern(String urlPattern) {
            this.urlPattern = urlPattern;
        }

        public String getAllow() {
            return allow;
        }

        public void setAllow(String allow) {
            this.allow = allow;
        }

        public String getDeny() {
            return deny;
        }

        public void setDeny(String deny) {
            this.deny = deny;
        }

        public String getLoginUsername() {
            return loginUsername;
        }

        public void setLoginUsername(String loginUsername) {
            this.loginUsername = loginUsername;
        }

        public String getLoginPassword() {
            return loginPassword;
        }

        public void setLoginPassword(String loginPassword) {
            this.loginPassword = loginPassword;
        }

        public String getResetEnable() {
            return resetEnable;
        }

        public void setResetEnable(String resetEnable) {
            this.resetEnable = resetEnable;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("enabled", enabled)
                    .append("urlPattern", urlPattern)
                    .append("allow", allow)
                    .append("deny", deny)
                    .append("loginUsername", loginUsername)
                    .append("loginPassword", loginPassword)
                    .append("resetEnable", resetEnable)
                    .toString();
        }
    }

    public static class WebStatFilter {
        private boolean enabled = true;
        private String urlPattern = "/*";
        private String exclusions = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
        private String sessionStatMaxCount;
        private String sessionStatEnable;
        private String principalSessionName;
        private String principalCookieName;
        private String profileEnable;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getUrlPattern() {
            return urlPattern;
        }

        public void setUrlPattern(String urlPattern) {
            this.urlPattern = urlPattern;
        }

        public String getExclusions() {
            return exclusions;
        }

        public void setExclusions(String exclusions) {
            this.exclusions = exclusions;
        }

        public String getSessionStatMaxCount() {
            return sessionStatMaxCount;
        }

        public void setSessionStatMaxCount(String sessionStatMaxCount) {
            this.sessionStatMaxCount = sessionStatMaxCount;
        }

        public String getSessionStatEnable() {
            return sessionStatEnable;
        }

        public void setSessionStatEnable(String sessionStatEnable) {
            this.sessionStatEnable = sessionStatEnable;
        }

        public String getPrincipalSessionName() {
            return principalSessionName;
        }

        public void setPrincipalSessionName(String principalSessionName) {
            this.principalSessionName = principalSessionName;
        }

        public String getPrincipalCookieName() {
            return principalCookieName;
        }

        public void setPrincipalCookieName(String principalCookieName) {
            this.principalCookieName = principalCookieName;
        }

        public String getProfileEnable() {
            return profileEnable;
        }

        public void setProfileEnable(String profileEnable) {
            this.profileEnable = profileEnable;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("enabled", enabled)
                    .append("urlPattern", urlPattern)
                    .append("exclusions", exclusions)
                    .append("sessionStatMaxCount", sessionStatMaxCount)
                    .append("sessionStatEnable", sessionStatEnable)
                    .append("principalSessionName", principalSessionName)
                    .append("principalCookieName", principalCookieName)
                    .append("profileEnable", profileEnable)
                    .toString();
        }
    }
}