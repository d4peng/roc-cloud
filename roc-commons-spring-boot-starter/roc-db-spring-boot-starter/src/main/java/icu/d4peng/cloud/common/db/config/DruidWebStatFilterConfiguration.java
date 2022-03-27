package icu.d4peng.cloud.common.db.config;

import com.alibaba.druid.support.http.WebStatFilter;
import icu.d4peng.cloud.common.db.properties.DruidStatProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;

/**
 * <p> DruidWebStatFilterConfiguration:webFilter配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConditionalOnWebApplication
public class DruidWebStatFilterConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass({HttpServlet.class})
    public FilterRegistrationBean<WebStatFilter> webStatFilterRegistrationBean(DruidStatProperties druidStatProperties) {
        DruidStatProperties.WebStatFilter webStatFilter = druidStatProperties.getWebStatFilter();

        FilterRegistrationBean<WebStatFilter> registrationBean = new FilterRegistrationBean<WebStatFilter>();
        WebStatFilter filter = new WebStatFilter();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(webStatFilter.getUrlPattern() != null ? webStatFilter.getUrlPattern() : "/*");
        registrationBean.addInitParameter("exclusions", webStatFilter.getExclusions() != null ? webStatFilter.getExclusions() : "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        if (webStatFilter.getSessionStatEnable() != null) {
            registrationBean.addInitParameter("sessionStatEnable", webStatFilter.getSessionStatEnable());
        }
        if (webStatFilter.getSessionStatMaxCount() != null) {
            registrationBean.addInitParameter("sessionStatMaxCount", webStatFilter.getSessionStatMaxCount());
        }
        if (webStatFilter.getPrincipalSessionName() != null) {
            registrationBean.addInitParameter("principalSessionName", webStatFilter.getPrincipalSessionName());
        }
        if (webStatFilter.getPrincipalCookieName() != null) {
            registrationBean.addInitParameter("principalCookieName", webStatFilter.getPrincipalCookieName());
        }
        if (webStatFilter.getProfileEnable() != null) {
            registrationBean.addInitParameter("profileEnable", webStatFilter.getProfileEnable());
        }
        return registrationBean;
    }
}