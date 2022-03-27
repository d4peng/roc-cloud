package icu.d4peng.cloud.common.mvc.test;

import icu.d4peng.cloud.common.core.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p> DefaultErrorController:默认的错误处理机制
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
@RestController
public class DefaultErrorController extends AbstractErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultErrorController.class);

    public DefaultErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * 处理404的
     *
     * @param request 请求
     * @return 错误视图
     */
    @RequestMapping("/error")
    public ResultVO<String> error404(HttpServletRequest request) {
        Map<String, Object> errorAttributes = getErrorAttributes(request);
        int status = Integer.parseInt(errorAttributes.get("status").toString());
        String message = errorAttributes.get("error").toString();
        String data = errorAttributes.get("message").toString();
        return ResultVO.build(status, message, data);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request) {
        ErrorAttributeOptions options = ErrorAttributeOptions.defaults()
                .including(ErrorAttributeOptions.Include.EXCEPTION)
                .including(ErrorAttributeOptions.Include.STACK_TRACE)
                .including(ErrorAttributeOptions.Include.MESSAGE)
                .including(ErrorAttributeOptions.Include.BINDING_ERRORS);
        return super.getErrorAttributes(request, options);
    }
}