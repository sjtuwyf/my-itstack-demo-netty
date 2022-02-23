package org.itstack.demo.netty.util;

import org.itstack.demo.netty.domain.Constants;
import org.itstack.demo.netty.domain.FileBurstData;
import org.itstack.demo.netty.domain.FileBurstInstruct;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author ssqswyf
 * @date 2022/2/23
 * 文件读写工具
 */
public class FileUtil {

    public static FileBurstData readFile(String fileUrl, Integer readPosition) throws IOException {
        File file = new File(fileUrl);
        // r: 只读模式 rw:读写模式
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        randomAccessFile.seek(readPosition);
        byte[] bytes = new byte[1024 * 100];
        int readSize = randomAccessFile.read(bytes);
        if (readSize <= 0) {
            randomAccessFile.close();
            return new FileBurstData(Constants.FileStatus.COMPLETE);
        }
        FileBurstData fileInfo = new FileBurstData();
        fileInfo.setFileUrl(fileUrl);
        fileInfo.setFileName(file.getName());
        fileInfo.setBeginPos(readPosition);
        fileInfo.setEndPos(readPosition + readSize);
        // 不足1024需要拷贝去掉空字节
        if (readSize < 1024 * 100) {
            byte[] copy = new byte[readSize];
            System.arraycopy(bytes, 0, copy, 0, readSize);
            fileInfo.setBytes(copy);
            fileInfo.setStatus(Constants.FileStatus.END);
        } else {
            fileInfo.setBytes(bytes);
            fileInfo.setStatus(Constants.FileStatus.CENTER);
        }
        randomAccessFile.close();
        return fileInfo;
    }

    public static FileBurstInstruct writeFile(String baseUrl, FileBurstData fileBurstData) throws IOException {
        if (Constants.FileStatus.COMPLETE == fileBurstData.getStatus()) {
            // Constants.FileStatus ｛0开始、1中间、2结尾、3完成｝
            return new FileBurstInstruct(Constants.FileStatus.COMPLETE);
        }

        File file = new File(baseUrl + "/" + fileBurstData.getFileName());
        // r: 只读模式 rw:读写模式
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        // 移动文件记录指针的位置,
        randomAccessFile.seek(fileBurstData.getBeginPos());
        // 调用了seek（start）方法，是指把文件的记录指针定位到start字节的位置。也就是说程序将从start字节开始写数据
        randomAccessFile.write(fileBurstData.getBytes());
        randomAccessFile.close();

        if (Constants.FileStatus.END == fileBurstData.getStatus()) {
            // Constants.FileStatus ｛0开始、1中间、2结尾、3完成｝
            return new FileBurstInstruct(Constants.FileStatus.COMPLETE);
        }

        // 文件分片传输指令
        FileBurstInstruct fileBurstInstruct = new FileBurstInstruct();
        // Constants.FileStatus ｛0开始、1中间、2结尾、3完成｝
        fileBurstInstruct.setStatus(Constants.FileStatus.CENTER);
        // 客户端文件URL
        fileBurstInstruct.setClientFileUrl(fileBurstData.getFileUrl());
        // 读取位置
        fileBurstInstruct.setReadPosition(fileBurstData.getEndPos() + 1);

        return fileBurstInstruct;
    }

}
