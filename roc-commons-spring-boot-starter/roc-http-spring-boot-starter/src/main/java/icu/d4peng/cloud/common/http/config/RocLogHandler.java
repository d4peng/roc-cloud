package icu.d4peng.cloud.common.http.config;

import com.dtflys.forest.logging.ForestLogHandler;
import com.dtflys.forest.logging.ForestLogger;
import com.dtflys.forest.logging.RequestLogMessage;
import com.dtflys.forest.logging.ResponseLogMessage;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-14 21:35
 * @description RocLogHandler:自定义handler
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
