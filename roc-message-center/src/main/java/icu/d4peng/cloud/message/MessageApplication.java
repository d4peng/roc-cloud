package icu.d4peng.cloud.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p> MessageApplication:启动中心
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@SpringBootApplication
@MapperScan("icu.d4peng.cloud.message.mapper")
public class MessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
