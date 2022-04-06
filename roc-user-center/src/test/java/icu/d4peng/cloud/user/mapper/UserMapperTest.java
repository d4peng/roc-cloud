package icu.d4peng.cloud.user.mapper;

import icu.d4peng.cloud.user.UserApplication;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.enums.StatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = UserApplication.class)
@ActiveProfiles("user")
public class UserMapperTest {
    private final UserMapper userMapper;

    @Autowired
    public UserMapperTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    public void testInsert() {
        User user = new User()
                .setUsername("d4peng")
                .setPassword("d4peng")
                .setStatus(StatusEnum.NORMAL);
        int result = this.userMapper.insert(user);
        Assertions.assertEquals(1, result);

        // 插入用户
    }

    @Test
    public void testSelect() {
        this.userMapper.selectList(null);
    }


}