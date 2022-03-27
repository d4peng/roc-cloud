//package icu.d4peng.cloud.common.core.util;
//
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//import ma.glasnost.orika.metadata.ClassMapBuilder;
//import org.apache.commons.lang3.ObjectUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.Collection;
//import java.util.Map;
//
///**
// * @author <a href="mailto:d4peng@qq.com">d4peng</a>
// *  @version 1.0.0
//
// * <p> OrikaFactory:Orika工具工厂类
// */
//public class OrikaFactory {
//    private static final Logger LOGGER = LoggerFactory.getLogger(OrikaFactory.class);
//
//    /**
//     * 工厂类
//     */
//    private static MapperFactory mapperFactory;
//
//    static {
//        mapperFactory = new DefaultMapperFactory.Builder().useAutoMapping(true).mapNulls(true).build();
//    }
//
//    public static MapperFactory getMapperFactory() {
//        return mapperFactory;
//    }
//
//    public static void setMapperFactory(MapperFactory mapperFactory) {
//        OrikaFactory.mapperFactory = mapperFactory;
//    }
//
//    /**
//     * 传入源对象和目标对象类型
//     *
//     * @param sourceObject 源对象
//     * @param targetClass  目标对象Class
//     * @param <S>          源对象泛型
//     * @param <T>          目标对象Class泛型
//     * @return 目标对象
//     */
//    public static <S, T> T map(S sourceObject, Class<T> targetClass) {
//        return map(sourceObject, targetClass, null, null);
//    }
//
//    /**
//     * 传入源对象和目标对象类型
//     *
//     * @param sourceObject 源对象
//     * @param targetClass  目标对象Class
//     * @param <S>          源对象泛型
//     * @param <T>          目标对象Class泛型
//     * @return 目标对象
//     */
//    public static <S, T> T map(S sourceObject, Class<T> targetClass, Map<String, String> mapFields) {
//        return map(sourceObject, targetClass, mapFields, null);
//    }
//
//    /**
//     * 传入源对象和目标对象类型
//     *
//     * @param sourceObject  源对象
//     * @param targetClass   目标对象Class
//     * @param excludeFields 需要排除的字段
//     * @param <S>           源对象泛型
//     * @param <T>           目标对象Class泛型
//     * @return 目标对象
//     */
//    public static <S, T> T map(S sourceObject, Class<T> targetClass, Collection<String> excludeFields) {
//        return map(sourceObject, targetClass, null, excludeFields);
//    }
//
//    /**
//     * 传入源对象和目标对象类型
//     *
//     * @param sourceObject  源对象
//     * @param targetClass   目标对象Class
//     * @param mapFields     不一致的字段
//     * @param excludeFields 需要排除的字段
//     * @param <S>           源对象泛型
//     * @param <T>           目标对象Class泛型
//     * @return 目标对象
//     */
//    public static <S, T> T map(S sourceObject, Class<T> targetClass, Map<String, String> mapFields, Collection<String> excludeFields) {
//        ClassMapBuilder<?, T> tClassMapBuilder = mapperFactory.classMap(sourceObject.getClass(), targetClass);
//        if (ObjectUtils.isNotEmpty(mapFields)) {
//            for (Map.Entry<String, String> item : mapFields.entrySet()) {
//                tClassMapBuilder = tClassMapBuilder.field(item.getKey(), item.getValue());
//            }
//        }
//        if (ObjectUtils.isNotEmpty(excludeFields)) {
//            for (String item : excludeFields) {
//                tClassMapBuilder = tClassMapBuilder.exclude(item);
//            }
//        }
//        tClassMapBuilder.byDefault().register();
//        return mapperFactory.getMapperFacade().map(sourceObject, targetClass);
//    }
//}
