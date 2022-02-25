package org.itstack.demo.netty.future;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public class SyncWriteMap {

    public static Map<String,WriteFuture> syncKey = new ConcurrentHashMap<>();

}
