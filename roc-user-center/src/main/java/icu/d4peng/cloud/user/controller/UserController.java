package icu.d4peng.cloud.user.controller;

import com.alibaba.fastjson.JSONObject;
import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.user.dto.CaptchaDTO;
import icu.d4peng.cloud.user.dto.LoginDTO;
import icu.d4peng.cloud.user.dto.RegisterDTO;
import icu.d4peng.cloud.user.dto.UserDTO;
import icu.d4peng.cloud.user.entity.User;
import icu.d4peng.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> UserController:控制器
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27 15:43
 */
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 列表
     *
     * @param userDTO 用户DTO
     * @return 列表
     */
    @GetMapping
    public ListVO<User> list(UserDTO userDTO) {
        return this.userService.list(userDTO);
    }

    /**
     * 单体查询
     *
     * @param id 主键
     * @return 查询视图
     */
    @GetMapping("{id}")
    public ResultVO<User> detail(@PathVariable Long id) {
        return this.userService.detail(id);
    }


    /**
     * 删除
     *
     * @param id 主键
     * @return 删除视图
     */
    @DeleteMapping("{id}")
    public ResultVO<String> delete(@PathVariable Long id) {
        return this.userService.delete(id);

    }

    /**
     * 修改
     *
     * @param id      主键
     * @param userDTO 修改DTO
     * @return 修改视图
     */
    @PutMapping("{id}")
    public ResultVO<String> modify(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return this.userService.update(userDTO);
    }

    /**
     * 验证码获取
     *
     * @param captchaDTO 验证码请求
     * @return 验证码视图
     */
    @GetMapping("captcha")
    public ResultVO<String> captcha(@RequestBody CaptchaDTO captchaDTO) {
        return this.userService.captcha(captchaDTO);
    }

    /**
     * 注册接口
     *
     * @param registerDTO 注册DTO
     * @return 注册视图
     */
    @PostMapping("register")
    public ResultVO<String> register(@RequestBody RegisterDTO registerDTO) {
        return this.userService.register(registerDTO);
    }

    /**
     * 登录接口
     *
     * @param loginDTO 登录DTO
     * @return 登录视图
     */
    @PostMapping("login")
    public ResultVO<JSONObject> login(@RequestBody LoginDTO loginDTO) {
        return this.userService.login(loginDTO);
    }


    /**
     * 信息接口
     *
     * @param id 登录ID
     * @return 信息视图
     */
    @GetMapping("info/{id}")
    public ResultVO<String> info(@PathVariable Long id) {
        return this.userService.info(id);
    }

    /**
     * 登出
     *
     * @param id ID
     * @return 登出视图
     */
    @PostMapping("logout/{id}")
    public ResultVO<String> logout(@PathVariable Long id) {
        return this.userService.logout(id);
    }

}
