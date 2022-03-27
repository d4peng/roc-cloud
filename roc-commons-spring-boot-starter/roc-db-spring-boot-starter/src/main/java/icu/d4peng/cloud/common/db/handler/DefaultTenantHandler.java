package icu.d4peng.cloud.common.db.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;

import java.util.List;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2021-12-29 17:29
 * @description DefaultTenantHandler:多租户处理器
 */
public class DefaultTenantHandler implements TenantLineHandler {
    private final String tenantId;
    private final String tenantColumn;
    private final List<String> ignoreTables;

    public DefaultTenantHandler(String tenantId, String tenantColumn, List<String> ignoreTables) {
        this.tenantId = tenantId;
        this.tenantColumn = tenantColumn;
        this.ignoreTables = ignoreTables;
    }

    @Override
    public Expression getTenantId() {
        return new StringValue(this.tenantId);
    }

    @Override
    public String getTenantIdColumn() {
        return this.tenantColumn;
    }

    @Override
    public boolean ignoreTable(String tableName) {
        return this.ignoreTables.contains(tableName);
    }
}
