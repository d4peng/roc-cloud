//package icu.d4peng.cloud.common.core.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2021-12-24 18:18
// * @description ReflectUtils:反射工具类
// */
//public class ReflectUtils {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtils.class);
//
//    /**
//     * 获得某个对象下所有的 字段和属性
//     *
//     * @param data 对象
//     * @param <T>  对象泛型
//     */
//    public static <T> Map<String, Object> getAllFields(T data) {
//        Map<String, Object> maps = new HashMap<>();
//        if (data == null) {
//            return maps;
//        }
//        Class<?> clz = data.getClass();
//        for (; clz != Object.class; clz = clz.getSuperclass()) {
//            Field[] fields = clz.getDeclaredFields();
//            for (Field field : fields) {
//                field.setAccessible(true);
//                try {
//                    maps.put(field.getName(), field.get(data));
//                } catch (IllegalAccessException e) {
//                    LOGGER.error(e.getMessage());
//                }
//            }
//        }
//        return maps;
//    }
//
//    /**
//     * 利用反射获取指定对象的指定属性
//     *
//     * @param data      目标对象
//     * @param fieldName 目标属性
//     * @return 目标属性的值
//     */
//    public static <T> Object getFieldValue(T data, String fieldName) {
//        Object value = null;
//        Class<?> clz = data.getClass();
//        for (; clz != Object.class; clz = clz.getSuperclass()) {
//            try {
//                Field field = clz.getDeclaredField(fieldName);
//                field.setAccessible(true);
//                value = field.get(data);
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                LOGGER.error(e.getMessage());
//            }
//        }
//        return value;
//    }
//
//    /**
//     * 利用反射设置指定对象的指定属性为指定的值
//     *
//     * @param data       目标对象
//     * @param fieldName  目标属性
//     * @param fieldValue 目标值
//     */
//    public static <T> void setFieldValue(T data, String fieldName, String fieldValue) {
//        Class<?> clz = data.getClass();
//        for (; clz != Object.class; clz = clz.getSuperclass()) {
//            try {
//                Field field = clz.getDeclaredField(fieldName);
//                field.setAccessible(true);
//                field.set(data, fieldValue);
//            } catch (NoSuchFieldException | IllegalAccessException e) {
//                LOGGER.error(e.getMessage());
//            }
//        }
//    }
//}
