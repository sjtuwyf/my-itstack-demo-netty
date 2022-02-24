package org.itstack.demo.test;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelFuture;
import org.itstack.demo.netty.client.ClientSocket;
import org.itstack.demo.netty.future.SyncWrite;
import org.itstack.demo.netty.msg.Request;
import org.itstack.demo.netty.msg.Response;

/**
 * @author ssqswyf
 * @date 2022/2/24
 */
public class StartClient {

    private static ChannelFuture future;

    public static void main(String[] args) {
        System.out.println("hi 微信公众号：bugstack虫洞栈");
        ClientSocket client = new ClientSocket();

        new Thread(client).start();

        while (true) {
            try {
                // 获取future, 线程有等待处理时间
                if (null == future) {
                    future = client.getFuture();
                    Thread.sleep(500);
                    continue;
                }
                // 构建发送参数
                Request request = new Request();
                request.setResult("查询｛bugstack虫洞栈｝用户信息");
                SyncWrite s = new SyncWrite();
                Response response = s.writeAndSync(future.channel(), request, 1000);
                System.out.println("调用结果：" + JSON.toJSON(response));
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
