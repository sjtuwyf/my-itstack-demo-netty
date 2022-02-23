package org.itstack.demo.netty.util;

import org.itstack.demo.netty.domain.FileBurstInstruct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class CacheUtil {

    public static Map<String, FileBurstInstruct> burstDataMap = new ConcurrentHashMap<>();

}
