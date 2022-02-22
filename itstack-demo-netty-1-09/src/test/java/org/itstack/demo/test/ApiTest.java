package org.itstack.demo.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author ssqswyf
 * @date 2022/2/22
 */
public class ApiTest {

//    public static void main(String[] args) {
//
//        System.out.println("hi 微信公众号：bugstack虫洞栈");
//
//        ByteBuf in = Unpooled.buffer(5);
//        byte[] bytes = {2, 50, 104, 105, 3};
//        in.writeBytes(bytes);
//        in.readBytes(1);
//        ByteBuf byteBuf = in.readBytes(1);
//
//        System.out.println(byteBuf.toString(Charset.forName("GBK")));
//    }


    //    public void test_01() {
    public static void main(String[] args) {
        ByteBuf in = Unpooled.buffer(5);
        byte[] bytes = {104, 105, 0x02, 104, 105, 0x03, 104};
        in.writeBytes(bytes);

        while (true) {
            int i = in.readerIndex();
            in.markReaderIndex();
            if (in.readByte() == 0x02) {
                break;
            }
            //未读到包头，略过一个字节
            in.resetReaderIndex();
            in.readByte();
        }

        // 假定我们的数据长度是2
        ByteBuf byteBuf = in.readBytes(2);
        int size = byteBuf.readableBytes();
        byte[] data = new byte[size];
        byteBuf.readBytes(data);
        in.readByte();
        System.out.println(Arrays.toString(data));

        // 余下数据
        int i = in.readableBytes();
        byte[] data2 = new byte[i];
        in.readBytes(data2);
        System.out.println(Arrays.toString(data2));
    }

}
