//package icu.d4peng.cloud.common.core.util;
//
//import java.util.regex.Pattern;
//
///**
// * @author <a href="mailto:d4peng@qq.com">d4peng</a>
// *  @version 1.0.0
//
// * <p> RegexUtils:正则工具类
// */
//public class RegexUtils {
//    /**
//     * 验证是否匹配:大小写敏感
//     *
//     * @param regex   正则表达式
//     * @param context 需要匹配的内容
//     * @return true:匹配,false:不匹配
//     */
//    public static boolean isMatch(String regex, String context) {
//        return Pattern.compile(regex).matcher(context).find();
//    }
//
//    /**
//     * 验证是否匹配:大小写不敏感
//     *
//     * @param regex   正则表达式
//     * @param context 需要匹配的内容
//     * @return true:匹配,false:不匹配
//     */
//    public static boolean isCaseInsensitiveMatch(String regex, String context) {
//        return Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(context).find();
//    }
//}
