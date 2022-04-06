package icu.d4peng.cloud.common.core.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> ListVO:列表视图
 * @since 2022-03-27 15:43
 */
public class ListVO<T> extends BaseVO {
    /**
     * 数量
     */
    private Long counts;
    /**
     * 数据集合
     */
    private Collection<T> items;

    /**
     * 静态构建方法
     *
     * @param code    状态码
     * @param message 信息
     * @param items   数据集合
     * @param <T>     数据泛型
     * @return 视图对象
     */
    public static <T> ListVO<T> build(Integer code, String message, Collection<T> items) {
        ListVO<T> listVO = new ListVO<>();
        listVO.setCode(code);
        listVO.setMessage(message);
        listVO.setCounts((long) items.size());
        listVO.setItems(items);
        return listVO;
    }

    /**
     * 静态构建
     *
     * @param dbResult 结果:0-失败,1-成功
     * @param items    数据
     * @param <T>      泛型
     * @return 结果视图
     */
    public static <T> ListVO<T> build(int dbResult, Collection<T> items) {
        if (dbResult != 0) {
            return build(200, "OK", items);
        } else {
            return build(400, "Bad Request", items);
        }
    }

    public Long getCounts() {
        return counts;
    }

    public ListVO<T> setCounts(Long counts) {
        this.counts = counts;
        return this;
    }

    public Collection<T> getItems() {
        return items;
    }

    public ListVO<T> setItems(Collection<T> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("counts", counts)
                .append("items", items)
                .toString();
    }
}