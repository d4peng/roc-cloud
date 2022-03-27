package icu.d4peng.cloud.common.http.config;

import com.dtflys.forest.logging.ForestLogHandler;
import com.dtflys.forest.logging.ForestLogger;
import com.dtflys.forest.logging.RequestLogMessage;
import com.dtflys.forest.logging.ResponseLogMessage;

/**
 * <p> RocLogHandler:自定义handler
 *
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * @since 2022-03-27
 */
public class RocLogHandler implements ForestLogHandler {
    private final ForestLogger LOGGER = new ForestLogger();

    @Override
    public void logContent(String content) {

    }

    @Override
    public ForestLogger getLogger() {
        return LOGGER;
    }

    @Override
    public void setLogger(ForestLogger logger) {

    }

    @Override
    public void logRequest(RequestLogMessage requestLogMessage) {

    }

    @Override
    public void logResponseStatus(ResponseLogMessage responseLogMessage) {

    }

    @Override
    public void logResponseContent(ResponseLogMessage responseLogMessage) {

    }
}
