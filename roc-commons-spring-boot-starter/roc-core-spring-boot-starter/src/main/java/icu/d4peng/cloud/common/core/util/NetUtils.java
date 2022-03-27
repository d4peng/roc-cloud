package icu.d4peng.cloud.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author <a href="mailto:d4peng@qq.com">d4peng</a>
 * @version 1.0.0
 * <p> NetUtils:网络工具
 * @since 2022-03-27 15:43
 */
public class NetUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(NetUtils.class);

    private static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public static String getLocalHostName() {
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return inetAddress.getHostName();
        } else {
            return "localhost";
        }
    }

    public static String getLocalIp() {
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return inetAddress.getHostAddress();
        } else {
            return "localhost";
        }
    }
}
