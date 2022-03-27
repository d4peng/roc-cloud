//package icu.d4peng.cloud.common.core.util;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.reflect.MethodSignature;
//
//import java.lang.annotation.Annotation;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2021-12-24 18:12
// * @description AspectUtils:切面编程工具类
// */
//public class AspectUtils {
//
//    /**
//     * 获得切面上是否存在某个注解
//     *
//     * @param joinPoint       切面
//     * @param annotationClass 注解
//     * @param <T>             注解泛型
//     * @return 注解
//     */
//    public static <T extends Annotation> T getAnnotation(JoinPoint joinPoint, Class<T> annotationClass) {
//        return ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(annotationClass);
//    }
//}
