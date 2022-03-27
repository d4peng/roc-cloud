package icu.d4peng.cloud.common.mvc.test;

import icu.d4peng.cloud.common.mvc.MvcApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = MvcApplication.class)
@WebAppConfiguration
public class ControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    public void before(@Autowired WebApplicationContext webApplicationContext) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/test")
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

}