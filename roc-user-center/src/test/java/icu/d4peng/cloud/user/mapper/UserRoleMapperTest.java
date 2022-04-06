package icu.d4peng.cloud.user.mapper;

import icu.d4peng.cloud.user.UserApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = UserApplication.class)
@ActiveProfiles("user")
public class UserRoleMapperTest {
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleMapperTest(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Test
    public void test() {
        this.userRoleMapper.selectList(null);
    }


}