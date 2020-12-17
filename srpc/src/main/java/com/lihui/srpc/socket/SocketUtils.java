package com.lihui.srpc.socket;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author ex_lihui4
 * @date 2020-12-17  11:12
 */

public class SocketUtils {
    public static void sendMessage(String host,int port,Object message){
        try (Socket socket = new Socket(host, port)) {
            OutputStream outputStream = socket.getOutputStream();
            //先采用JSON进行数据传输
            String messageJson = JSONObject.toJSONString(message);
            outputStream.write(messageJson.getBytes("UTF-8"));
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            inputStream.close();
            outputStream.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
