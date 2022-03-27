package icu.d4peng.cloud.common.auth.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import icu.d4peng.cloud.common.auth.JustAuthApplication;
import me.zhyd.oauth.config.AuthDefaultSource;
import me.zhyd.oauth.model.AuthCallback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = JustAuthApplication.class)
@ActiveProfiles("just-auth")
public class JustAuthServiceTest {
    private final JustAuthService justAuthService;

    @Autowired
    public JustAuthServiceTest(JustAuthService justAuthService) {
        this.justAuthService = justAuthService;
    }

    @Test
    public void getAuthorizeUrl() {
        System.out.println(this.justAuthService.getAuthorizeUrl(AuthDefaultSource.GITEE));
    }

    @Test
    public void getUserInfo() {
        AuthCallback authCallback = new AuthCallback();
        authCallback.setCode("64210acd268c1c51491f429136e51e016b4c0ba209f41f3df6e5b4ce59346851");
        authCallback.setState("9a48b2b70ef1666a8157049c1cae96f3");
        System.out.println(JSON.toJSONString(this.justAuthService.getUserInfo(AuthDefaultSource.GITEE, authCallback), SerializerFeature.PrettyFormat));
    }
}