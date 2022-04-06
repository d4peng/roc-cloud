package icu.d4peng.cloud.common.db.service;

import icu.d4peng.cloud.common.core.vo.ListVO;
import icu.d4peng.cloud.common.core.vo.ResultVO;
import icu.d4peng.cloud.common.db.domain.AbstractSuperEntity;
import icu.d4peng.cloud.common.db.request.SuperDTO;

/**
 * <p> BaseService: 基础服务
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public interface BaseService<ENTITY extends AbstractSuperEntity, DTO extends SuperDTO<ENTITY>, PK extends Comparable<PK>> {
    /**
     * 列表
     *
     * @param dto DTO参数
     * @return 列表返回
     */
    ListVO<ENTITY> list(DTO dto);

    /**
     * 详情
     *
     * @param pk 主键
     * @return 详情
     */
    ResultVO<ENTITY> detail(PK pk);

    /**
     * 删除
     *
     * @param pk 主键
     * @return 结果
     */
    ResultVO<String> delete(PK pk);

    /**
     * 更新
     *
     * @param dto DTO参数
     * @return 结果
     */
    ResultVO<String> update(DTO dto);
}
