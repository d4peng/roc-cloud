package icu.d4peng.cloud.common.core.vo;

import com.alibaba.fastjson.JSON;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> ResultVO:基础结果视图集(单条数据, 或者没有数据)
 * @since 2022-03-27 15:43
 */
public class ResultVO<T> extends BaseVO {
    /**
     * 结果
     */
    private T data;

    /**
     * 静态构建
     *
     * @param code    状态码
     * @param message 信息
     * @param data    数据
     * @param <T>     泛型
     * @return 结果视图
     */

    public static <T> ResultVO<T> build(Integer code, String message, T data) {
        ResultVO<T> resultVO = new ResultVO<T>().setData(data);
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }

    /**
     * 静态构建
     *
     * @param dbResult 结果:0-失败,1-成功
     * @param data     数据
     * @param <T>      泛型
     * @return 结果视图
     */
    public static <T> ResultVO<T> build(Integer dbResult, T data) {
        if (dbResult != 0) {
            return build(200, "OK", data);
        } else {
            return build(400, "Bad Request", data);
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public T getData() {
        return data;
    }

    public ResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }
}