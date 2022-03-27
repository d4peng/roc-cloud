package icu.d4peng.cloud.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-27 10:39
 * @description RocLog:日志记录注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RocLog {
    String values() default "";
}
