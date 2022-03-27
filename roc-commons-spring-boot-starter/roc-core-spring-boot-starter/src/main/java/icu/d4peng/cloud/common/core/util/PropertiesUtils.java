//package icu.d4peng.cloud.common.core.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
///**
// * @author d4peng
// * @version 1.0.0
// * @date 2021-12-24 18:16
// * @description PropertiesUtils:properties工具类
// */
//public class PropertiesUtils {
//    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);
//
//    /**
//     * 获得classpath下的文件的properties
//     *
//     * @param fileName 文件名称
//     * @return 键值对
//     */
//    public static Properties loadAsProperties(String fileName) {
//        InputStream inputStream = null;
//        try {
//            inputStream = ResourceUtils.getClassPathFileAsResource(fileName).getInputStream();
//        } catch (IOException e) {
//            LOGGER.error("load file error,error is {}", e.getMessage());
//        }
//        return loadAsProperties(inputStream);
//
//    }
//
//    /**
//     * 获得输入流的信息
//     *
//     * @param inputStream 输入流
//     * @return 键值对
//     */
//    public static Properties loadAsProperties(InputStream inputStream) {
//        Properties properties = new Properties();
//        try {
//            properties.load(inputStream);
//        } catch (IOException e) {
//            LOGGER.error("load properties file error,error is {}", e.getMessage());
//        }
//        return properties;
//    }
//}
