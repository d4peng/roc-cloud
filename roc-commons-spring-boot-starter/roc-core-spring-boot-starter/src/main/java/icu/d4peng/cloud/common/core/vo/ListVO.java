package icu.d4peng.cloud.common.core.vo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-24 09:31
 * @description ListVO:列表视图
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class ListVO<T> extends BaseVO {
    /**
     * 数量
     */
    private Long counts;
    /**
     * 数据集合
     */
    private Collection<T> items;
/*
    *//**
     * 静态构建方法
     *
     * @param code    状态码
     * @param message 信息
     * @param size    数量
     * @param items   数据集合
     * @param <T>     数据泛型
     * @return 视图对象
     *//*
    public static <T> ListVO<T> build(Integer code, String message, Long size, Collection<T> items) {
        ListVO<T> listVO = new ListVO<>();
        listVO.setCode(code);
        listVO.setMessage(message);
        listVO.setCounts(size);
        listVO.setItems(items);
        return listVO;
    }

    *//**
     * 静态构建方法(成功)
     *
     * @param items 数据集合
     * @param <T>   数据泛型
     * @return 视图对象
     *//*
    public static <T> ListVO<T> success(Collection<T> items) {
        return build(200, "OK", ((long) items.size()), items);
    }

    *//**
     * 静态构建方法(失败)
     *
     * @return 视图对象
     *//*
    public static <T> ListVO<T> fail() {
        return build(400, "Bad Request", 0L, new ArrayList<>());
    }*/
}