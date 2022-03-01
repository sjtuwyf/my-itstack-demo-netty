package org.itstack.demo.ark.domain;

import java.util.Date;

/**
 * @author ssqswyf
 * @date 2022/3/1
 */
public class Device {

    /**
     * 通信管道ID
     */
    private String channelId;

    /**
     * 设备编号
     */
    private String number;

    /**
     * 设备IP
     */
    private String ip;

    /**
     * 设备端口
     */
    private int port;

    /**
     * 连接时间
     */
    private Date connectTime;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Date getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }
}
