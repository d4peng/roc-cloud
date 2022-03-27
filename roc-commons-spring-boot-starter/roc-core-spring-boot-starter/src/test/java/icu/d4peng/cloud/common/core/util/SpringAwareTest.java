package icu.d4peng.cloud.common.core.util;

import icu.d4peng.cloud.common.core.CoreApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SpringAwareTest {

    @Test
    public void test() {
        Environment environment = SpringAware.getBean(Environment.class);
        Assertions.assertNotNull(environment);
    }
}