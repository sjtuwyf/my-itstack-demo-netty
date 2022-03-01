package org.itstack.demo.ark.domain.msgobj;

/**
 * @author ssqswyf
 * @date 2022/3/1
 */
public class Feedback {

    /**
     * 设备ID{管道ID}
     */
    private String channelId;

    /**
     * 状态类型;1\2
     */
    private Integer stateType;

    /**
     * 状态信息
     */
    private String stateMsg;

    public Feedback(String channelId, Integer stateType, String stateMsg) {
        this.channelId = channelId;
        this.stateType = stateType;
        this.stateMsg = stateMsg;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public String getStateMsg() {
        return stateMsg;
    }

    public void setStateMsg(String stateMsg) {
        this.stateMsg = stateMsg;
    }
}
