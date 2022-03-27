//package icu.d4peng.cloud.common.core.util;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//
///**
// * @author <a href="mailto:d4peng@qq.com">d4peng</a>
// *  @version 1.0.0
//
// * <p> AnnotationUtils:注解工具类
// */
//public class AnnotationUtils {
//    /**
//     * 判断某个类上是否存在注解
//     *
//     * @param clz 类信息
//     * @param ant 注解的class值
//     * @param <A> 注解的类型
//     * @return 该注解
//     */
//    public static <A extends Annotation> A getAnnotationByClz(Class<?> clz, Class<A> ant) {
//        if (clz.isAnnotationPresent(ant)) {
//            return clz.getAnnotation(ant);
//        }
//        return null;
//    }
//
//    /**
//     * 判断某个字段上是否存在某个注解
//     *
//     * @param field 字段
//     * @param ant   注解
//     * @param <A>   注解泛型
//     * @return 注解信息
//     */
//    public static <A extends Annotation> A getAnnotationByField(Field field, Class<A> ant) {
//        if (field.isAnnotationPresent(ant)) {
//            return field.getAnnotation(ant);
//        }
//        return null;
//    }
//}
