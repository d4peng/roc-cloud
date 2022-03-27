package icu.d4peng.cloud.common.log.annotation;

import java.lang.annotation.*;

/**
 * <p> RocLog:日志记录注解
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RocLog {
    String values() default "";
}
