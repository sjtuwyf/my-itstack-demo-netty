package org.itstack.demo.netty.domain;

/**
 * @author ssqswyf
 * @date 2022/2/23
 */
public class FileTransferProtocol {

    /**
     * 0请求传输文件、1文件传输指令、2文件传输数据
     */
    private Integer transferType;

    /**
     * 数据对象；(0)FileDescInfo、(1)FileBurstInstruct、(2)FileBurstData
     */
    private Object transferObj;

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Object getTransferObj() {
        return transferObj;
    }

    public void setTransferObj(Object transferObj) {
        this.transferObj = transferObj;
    }
}
