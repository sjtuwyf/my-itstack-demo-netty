package org.itstack.demo.netty.future;

import org.itstack.demo.netty.msg.Response;

import java.util.concurrent.Future;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public interface WriteFuture<T> extends Future<T> {

    Throwable cause();

    void setCause(Throwable cause);

    boolean isWriteSuccess();

    void setWriteResult(boolean result);

    String requestId();

    T response();

    void setResponse(Response response);

    boolean isTimeout();

}
