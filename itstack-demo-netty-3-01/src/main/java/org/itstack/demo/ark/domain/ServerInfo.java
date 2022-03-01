package org.itstack.demo.ark.domain;

import java.util.Date;

/**
 * @author ssqswyf
 * @date 2022/3/1
 */
public class ServerInfo {

    /**
     * 服务类型
     */
    private String typeInfo;

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

    public ServerInfo(String typeInfo, String ip, int port, Date openDate) {
        this.typeInfo = typeInfo;
        this.ip = ip;
        this.port = port;
        this.openDate = openDate;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
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
