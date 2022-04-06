package icu.d4peng.cloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author d4peng
 * @version 1.0.0
 * @description UserApplication:用户中心
 * @since 2021-12-27 20:28
 */
@SpringBootApplication
@MapperScan("icu.d4peng.cloud.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
