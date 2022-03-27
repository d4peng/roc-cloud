package icu.d4peng.cloud.common.auth;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.action.SaTokenAction;
import cn.dev33.satoken.basic.SaBasicTemplate;
import cn.dev33.satoken.basic.SaBasicUtil;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.context.SaTokenContext;
import cn.dev33.satoken.context.second.SaTokenSecondContextCreator;
import cn.dev33.satoken.dao.SaTokenDao;
import cn.dev33.satoken.id.SaIdTemplate;
import cn.dev33.satoken.id.SaIdUtil;
import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.sso.SaSsoTemplate;
import cn.dev33.satoken.sso.SaSsoUtil;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.temp.SaTempInterface;
import icu.d4peng.cloud.common.auth.properties.SaTokenProperties;
import icu.d4peng.cloud.common.auth.sa.SaPathMatcherHolder;
import icu.d4peng.cloud.common.auth.sa.SaTokenContextForSpring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 09:34
 * @description SaTokenAutoconfiguration: sa自动配置
 */
@Configuration
@EnableConfigurationProperties({SaTokenProperties.class})
@ConditionalOnProperty(prefix = SaTokenProperties.PREFIX, name = {"enabled"}, havingValue = "true")
public class SaTokenAutoConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaTokenAutoConfiguration.class);

    @Autowired
    public void setConfig(SaTokenProperties saTokenProperties) {
        SaManager.setConfig(saTokenProperties);
        SaManager.setSaTokenContext(new SaTokenContextForSpring());
    }

    @Autowired(required = false)
    public void setSaTokenDao(SaTokenDao saTokenDao) {
        SaManager.setSaTokenDao(saTokenDao);
    }

    @Autowired(required = false)
    public void setStpInterface(StpInterface stpInterface) {
        SaManager.setStpInterface(stpInterface);
    }

    @Autowired(required = false)
    public void setSaTokenContext(SaTokenSecondContextCreator saTokenSecondContextCreator) {
        SaManager.setSaTokenSecondContext(saTokenSecondContextCreator.create());
    }

    @Autowired(required = false)
    public void setSaTokenListener(SaTokenListener saTokenListener) {
        SaManager.setSaTokenListener(saTokenListener);
    }

    @Autowired(required = false)
    public void setSaTemp(SaTempInterface saTemp) {
        SaManager.setSaTemp(saTemp);
    }

    @Autowired(required = false)
    public void setSaIdTemplate(SaIdTemplate saIdTemplate) {
        SaIdUtil.saIdTemplate = saIdTemplate;
    }

    @Autowired(required = false)
    public void setSaSsoTemplate(SaBasicTemplate saBasicTemplate) {
        SaBasicUtil.saBasicTemplate = saBasicTemplate;
    }

    @Autowired(required = false)
    public void setSaSsoTemplate(SaSsoTemplate saSsoTemplate) {
        SaSsoUtil.saSsoTemplate = saSsoTemplate;
    }

    @Autowired(required = false)
    public void setStpLogic(StpLogic stpLogic) {
        StpUtil.setStpLogic(stpLogic);
    }

    @Autowired(required = false)
    @Qualifier("mvcPathMatcher")
    public void setPathMatcher(PathMatcher pathMatcher) {
        SaPathMatcherHolder.setPathMatcher(pathMatcher);
    }
}
