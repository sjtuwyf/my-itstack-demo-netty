package org.itstack.demo.netty.domain;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public class TransportProtocol {

    /**
     * 1 用户信息
     */
    private Integer type;

    /**
     * 传输对象
     */
    private Object obj;

    public TransportProtocol(Integer type, Object obj) {
        this.type = type;
        this.obj = obj;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
