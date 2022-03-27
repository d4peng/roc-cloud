package icu.d4peng.cloud.common.db.config;

import com.alibaba.druid.support.http.StatViewServlet;
import icu.d4peng.cloud.common.db.properties.DruidStatProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.http.HttpServlet;

/**
 * <p> DruidStatViewServletConfiguration:statView配置
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@ConditionalOnWebApplication
public class DruidStatViewServletConfiguration {
    private static final String DEFAULT_ALLOW_IP = "127.0.0.1";

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass({HttpServlet.class})
    public ServletRegistrationBean<StatViewServlet> servletRegistrationBean(DruidStatProperties druidStatProperties) {
        DruidStatProperties.StatViewServlet statViewServlet = druidStatProperties.getStatViewServlet();

        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<StatViewServlet>();
        registrationBean.setServlet(new StatViewServlet());
        registrationBean.addUrlMappings(statViewServlet.getUrlPattern() != null ? statViewServlet.getUrlPattern() : "/druid/*");
        if (statViewServlet.getAllow() != null) {
            registrationBean.addInitParameter("allow", statViewServlet.getAllow());
        } else {
            registrationBean.addInitParameter("allow", DEFAULT_ALLOW_IP);
        }
        if (statViewServlet.getDeny() != null) {
            registrationBean.addInitParameter("deny", statViewServlet.getDeny());
        }
        if (statViewServlet.getLoginUsername() != null) {
            registrationBean.addInitParameter("loginUsername", statViewServlet.getLoginUsername());
        }
        if (statViewServlet.getLoginPassword() != null) {
            registrationBean.addInitParameter("loginPassword", statViewServlet.getLoginPassword());
        }
        if (statViewServlet.getResetEnable() != null) {
            registrationBean.addInitParameter("resetEnable", statViewServlet.getResetEnable());
        }
        return registrationBean;
    }
}