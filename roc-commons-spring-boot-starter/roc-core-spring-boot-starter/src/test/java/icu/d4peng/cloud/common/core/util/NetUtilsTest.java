package icu.d4peng.cloud.common.core.util;

import icu.d4peng.cloud.common.core.CoreApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class NetUtilsTest {

    @Test
    public void getLocalHostName() {
        System.out.println(NetUtils.getLocalHostName());
    }

    @Test
    public void getLocalIP() {
        System.out.println(NetUtils.getLocalIP());
    }
}