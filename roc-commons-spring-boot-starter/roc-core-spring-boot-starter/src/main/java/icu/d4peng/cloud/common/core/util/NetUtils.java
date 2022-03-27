package icu.d4peng.cloud.common.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author d4peng
 * @version 1.0.0
 * @date 2022-03-21 21:48
 * @description NetUtils:网络工具
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

    public static String getLocalIP() {
        InetAddress inetAddress = getInetAddress();
        if (inetAddress != null) {
            return inetAddress.getHostAddress();
        } else {
            return "localhost";
        }
    }
}
