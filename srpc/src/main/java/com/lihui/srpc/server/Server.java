package com.lihui.srpc.server;

import com.alibaba.fastjson.JSONObject;
import com.lihui.srpc.protof.ReqParam;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ex_lihui4
 * @date 2020-12-17  11:11
 */

public class Server {
    //开启RPC服务
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,10, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
          while (true){
              Socket socket = serverSocket.accept();
              InputStream inputStream = socket.getInputStream();
              byte[] bytes;
              bytes = new byte[inputStream.available()];
              inputStream.read(bytes);
              String str = new String(bytes);

              break;
          }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handle(String reqParamStr){
        ReqParam reqParam = JSONObject.parseObject(reqParamStr, ReqParam.class);
        reqParam.getServerAddress();
    }
}
