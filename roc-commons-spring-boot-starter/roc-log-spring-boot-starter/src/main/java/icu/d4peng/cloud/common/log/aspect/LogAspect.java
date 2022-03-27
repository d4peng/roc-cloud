package icu.d4peng.cloud.common.log.aspect;

import com.alibaba.fastjson.JSON;
import icu.d4peng.cloud.common.log.annotation.RocLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> LogAspect:注解日志记录切面
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@Aspect
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("@annotation(icu.d4peng.cloud.common.log.annotation.RocLog)")
    public void annotationLog() {
    }

    @Pointcut("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")
    public void controllerLog() {
    }

    @Around("annotationLog() || controllerLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 参数
        ArrayList<String> parameters = new ArrayList<>();
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        // 时间统计
        long beginTime = System.currentTimeMillis();

        // 获得类名称
        String className = pjp.getTarget().getClass().getName();

        // 获得方法名称
        String methodName = signature.getName();

        // 获得入参
        Object[] args = pjp.getArgs();
        parameters.add(Arrays.toString(args));

        // 获得注解
        RocLog rocLog = signature.getMethod().getAnnotation(RocLog.class);
        if (rocLog != null) {
            String values = rocLog.values();
            parameters.add(values);
        }

        // 返回参数
        Object returnValue = null;

        // 异常记录
        Exception exception = null;
        try {
            returnValue = pjp.proceed();
            return returnValue;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            long cost = System.currentTimeMillis() - beginTime;
            if (exception != null) {
                LOGGER.error("[class: {}][method: {}][cost: {}ms][args: {}][exception: {}]", className, methodName, cost, parameters, exception);
            } else {
                LOGGER.info("[class: {}][method: {}][cost: {}ms][args: {}][return: {}]", className, methodName, cost, parameters, JSON.toJSONString(returnValue));
            }
        }
    }
}