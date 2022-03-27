//package icu.d4peng.cloud.common.core.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
//import org.springframework.core.type.classreading.MetadataReader;
//import org.springframework.core.type.classreading.MetadataReaderFactory;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author <a href="mailto:d4peng@qq.com">d4peng</a>
// *  @version 1.0.0
//
// * <p> ClassUtils:Class工具类
// */
//public class ClassUtils {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtils.class);
//
//    private static final String RESOURCE_PATTERN = "/**/*.class";
//    // 资源路径解决器
//    private static final ResourcePatternResolver RESOURCE_PATTERN_RESOLVER = new PathMatchingResourcePatternResolver();
//    // 元信息解决工厂
//    private static final MetadataReaderFactory METADATA_READER_FACTORY = new CachingMetadataReaderFactory(RESOURCE_PATTERN_RESOLVER);
//
//    /**
//     * 通过包名获得该路径下所有的类信息
//     *
//     * @param packageName 包名
//     * @return 类信息的Map
//     */
//    public static Map<String, Class<?>> getClassesByPackageName(String packageName) {
//        Map<String, Class<?>> resultMap = new HashMap<String, Class<?>>();
//        String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + packageName.replace('.', '/') + RESOURCE_PATTERN;
//        try {
//            // 获得该路径下所有的资源
//            Resource[] resources = RESOURCE_PATTERN_RESOLVER.getResources(pattern);
//            //MetadataReader 的工厂类
//            for (Resource resource : resources) {
//                //用于读取类信息
//                MetadataReader reader = METADATA_READER_FACTORY.getMetadataReader(resource);
//                String className = reader.getClassMetadata().getClassName();
//                Class<?> clazz = Class.forName(className);
//                resultMap.put(className, clazz);
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            LOGGER.error("get classes error,error is : {}", e.getMessage());
//        }
//        return resultMap;
//    }
//}
