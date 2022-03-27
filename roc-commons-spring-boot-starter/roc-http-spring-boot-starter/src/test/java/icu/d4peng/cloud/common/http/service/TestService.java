package icu.d4peng.cloud.common.http.service;

import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.http.ForestResponse;

/**
 * <p> TestService:测试接口
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface TestService {

    @Request("http://www.httpbin.org/get")
    ForestResponse<String> get();
}
