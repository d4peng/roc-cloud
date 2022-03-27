package icu.d4peng.cloud.common.core.constants;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-01-01 11:43
 * @description ControllerConstant:Controller常量
 */
public class ControllerConstant {
    // 版本信息
    public static final String API_VERSION = "/v1";

    // -----------------------------------------------------
    // 用户根路由
    public static final String USER_ROOT_PATH = "/users";
    // 用户:验证码 POST
    public static final String USER_CAPTCHA_PATH = "/captcha";
    // 用户:注册 POST
    public static final String USER_REGISTER_PATH = "/register";
    // 用户:登录 POST
    public static final String USER_LOGIN_PATH = "/login";
    // 用户:信息 GET
    public static final String USER_INFO_PATH = "/info";
    // 用户:登出 PATCH
    public static final String USER_LOGOUT_PATH = "/logout";

    // -----------------------------------------------------
    // 网关根路由
    public static final String GATEWAY_ROOT_PATH = "/gateways";


    // -----------------------------------------------------
    // 信息根路由
    public static final String MESSAGE_ROOT_PATH = "/message";


    // -----------------------------------------------------
    // 缓存根路由
    public static final String CACHE_ROOT_PATH = "/cache";


}
