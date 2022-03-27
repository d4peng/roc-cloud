package icu.d4peng.cloud.common.http.service;

import com.dtflys.forest.annotation.Request;
import com.dtflys.forest.http.ForestResponse;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-27 11:08
 * @description TestService:测试接口
 */
public interface TestService {

    @Request("http://www.httpbin.org/get")
    ForestResponse<String> get();
}
