package icu.d4peng.cloud.common.http.service;

import icu.d4peng.cloud.common.http.HttpApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {HttpApplication.class})
@ActiveProfiles({"http"})
public class TestServiceTests {
    /*@Resource
    private TestService testService;*/
    private final TestService testService;

    @Autowired(required = false)
    public TestServiceTests(TestService testService) {
        this.testService = testService;
    }

    @Test
    public void test() {
        System.out.println(this.testService.get());
    }

}