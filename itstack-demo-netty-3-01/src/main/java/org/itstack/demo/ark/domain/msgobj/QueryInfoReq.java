package org.itstack.demo.ark.domain.msgobj;

/**
 * @author ssqswyf
 * @date 2022/3/1
 */
public class QueryInfoReq {

    /**
     * 类型；Feedback=>{1\2}
     */
    private Integer stateType;

    public QueryInfoReq(Integer stateType) {
        this.stateType = stateType;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }
}
