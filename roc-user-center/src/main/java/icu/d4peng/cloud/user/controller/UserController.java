//package icu.d4peng.cloud.user.controller;
//
//import cn.dev33.satoken.stp.SaTokenInfo;
//import icu.d4peng.cloud.common.core.vo.ListVO;
//import icu.d4peng.cloud.common.core.vo.ResultVO;
//import icu.d4peng.cloud.common.core.constants.ControllerConstant;
//import icu.d4peng.cloud.user.entity.User;
//import icu.d4peng.cloud.user.request.*;
//import icu.d4peng.cloud.user.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @since 2022-01-01 11:39
// * @description UserController:用户Controller
// */
//@RestController
//@RequestMapping(ControllerConstant.USER_ROOT_PATH)
//public class UserController {
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    /**
//     * 验证码获取
//     *
//     * @param captchaRequest 验证码请求
//     * @return 验证码视图
//     */
//    @PostMapping(ControllerConstant.USER_CAPTCHA_PATH)
//    public ResultVO<String> captcha(@RequestBody CaptchaRequest captchaRequest) {
//        return this.userService.captcha(captchaRequest);
//    }
//
//    /**
//     * 注册接口
//     *
//     * @param registerRequest 注册DTO
//     * @return 注册视图
//     */
//    @PostMapping(ControllerConstant.USER_REGISTER_PATH)
//    public ResultVO<String> register(@RequestBody RegisterRequest registerRequest) {
//        return this.userService.register(registerRequest);
//    }
//
//    /**
//     * 登录接口
//     *
//     * @param loginRequest 登录DTO
//     * @return 登录视图
//     */
//    @PostMapping(ControllerConstant.USER_LOGIN_PATH)
//    public ResultVO<SaTokenInfo> login(@RequestBody LoginRequest loginRequest) {
//        return this.userService.login(loginRequest);
//    }
//
//
//    /**
//     * 信息接口
//     *
//     * @param id 登录ID
//     * @return 信息视图
//     */
//    @GetMapping(ControllerConstant.USER_INFO_PATH + "{/id}")
//    public ResultVO<String> info(@PathVariable Long id) {
//        return this.userService.info(id);
//    }
//
//    /**
//     * 登出
//     *
//     * @param id ID
//     * @return 登出视图
//     */
//    @PatchMapping(ControllerConstant.USER_LOGOUT_PATH + "/{id}")
//    public ResultVO<String> logout(@PathVariable Long id) {
//        return this.userService.logout(id);
//    }
//
//    /**
//     * 列表
//     *
//     * @param username 用户名
//     * @param nickName 昵称
//     * @param phone    手机
//     * @param id       ID
//     * @param current  当前页
//     * @param size     每页数量
//     * @return 列表视图
//     */
//    @GetMapping
//    public ListVO<User> list(@RequestParam(required = false) String username,
//                             @RequestParam(required = false) String nickName,
//                             @RequestParam(required = false) String phone,
//                             @RequestParam(required = false) Long id,
//                             @RequestParam(required = false, defaultValue = "1") Long current,
//                             @RequestParam(required = false, defaultValue = "20") Long size) {
//
//        ListRequest listRequest = new ListRequest();
//        listRequest.setUsername(username).setNickName(nickName)
//                .setPhone(phone).setId(id)
//                .setCurrent(current)
//                .setSize(size);
//        return this.userService.list(listRequest);
//    }
//
//    /**
//     * 单体查询
//     *
//     * @param id 主键
//     * @return 查询视图
//     */
//    @GetMapping("/{id}")
//    public ResultVO<User> get(@PathVariable Long id) {
//        return this.userService.get(id);
//    }
//
//
//    /**
//     * 删除
//     *
//     * @param id 主键
//     * @return 删除视图
//     */
//    @DeleteMapping("/{id}")
//    public ResultVO<String> delete(@PathVariable Long id) {
//        return this.userService.delete(id);
//
//    }
//
//    /**
//     * 修改
//     *
//     * @param id            主键
//     * @param modifyRequest 修改请求
//     * @return 修改视图
//     */
//    @PutMapping("/{id}")
//    public ResultVO<String> modify(@PathVariable Long id, @RequestBody ModifyRequest modifyRequest) {
//        modifyRequest.setId(id);
//        return this.userService.modify(modifyRequest);
//    }
//
//
//}
