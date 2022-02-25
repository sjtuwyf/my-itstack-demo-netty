package org.itstack.demo.netty.domain;

import java.util.Date;

/**
 * @author ssqswyf
 * @date 2022/2/25
 * 服务端信息
 */
public class ServerInfo {

    /**
     * IP
     */
    private String ip;

    /**
     * 端口
     */
    private int port;

    /**
     * 启动时间
     */
    private Date openDate;

    public ServerInfo(String ip, int port, Date openDate) {
        this.ip = ip;
        this.port = port;
        this.openDate = openDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
