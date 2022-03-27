package icu.d4peng.cloud.common.auth.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import icu.d4peng.cloud.common.auth.SaTokenApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-26 17:32
 * @description SaTokenServiceTest:
 */
@SpringBootTest(classes = SaTokenApplication.class)
@ActiveProfiles("sa-token")
public class SaTokenServiceTest {
    // 登录ID
    private static final Long USER_ID = 123456L;

    @Test
    public void testLogin() {
        // 登录
        StpUtil.login(USER_ID);
        System.out.println("login success");

        // 是否登录
        boolean isLogin = StpUtil.isLogin();
        System.out.println("is login:" + isLogin);

        // 登出
        StpUtil.logout(USER_ID);
        System.out.println("logout success");

        // 是否登录
        isLogin = StpUtil.isLogin();
        System.out.println("is login:" + isLogin);
    }

    @Test
    public void testDisable() {
        // 登录
        StpUtil.login(USER_ID);
        System.out.println("login success");

        // 登出
        StpUtil.kickout(USER_ID);
        System.out.println("kick out success");

        // 封禁账号
        StpUtil.disable(USER_ID, -1);
        System.out.println("disable:" + StpUtil.isDisable(USER_ID));
    }

    @Test
    public void testTokenInfo() {
        // 登录
        StpUtil.login(USER_ID);
        System.out.println("login success");

        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        System.out.println("token Info:" + tokenInfo);

        String tokenValue = StpUtil.getTokenValue();
        System.out.println("token value:" + tokenValue);
    }
}
