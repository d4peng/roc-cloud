package icu.d4peng.cloud.common.core.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 09:44
 * @description ResultVO:基础结果视图集(单条数据, 或者没有数据)
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    /**
     * 静态构建(失败)
     *
     * @param data 数据
     * @param <D>  泛型
     * @return 结果视图
     *//*

    public static <D> ResultVO<D> fail(D data) {
        return build(400, "Bad Request", data);
    }

    */
/**
 * 静态构建(成功)
 *
 * @param data 数据
 * @param <D>  泛型
 * @return 结果视图
 *//*

    public static <D> ResultVO<D> success(D data) {
        return build(200, "OK", data);
    }
*/

}