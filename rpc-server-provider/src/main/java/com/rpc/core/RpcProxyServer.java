package com.rpc.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Rpc服务度发布者
 */
public class RpcProxyServer {


    // 通过Spring升级Bean管理
//    Executor threadPool = Executors.newCachedThreadPool();
//
//    public void publish(Object service,int port) {
//
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(port);
//            //不断接收请求
//            while (true){
//                threadPool.execute(new ProcessorHandler(serverSocket.accept(),service));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            //关闭serverSocket
//            if (Objects.nonNull(serverSocket)){
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//
//
//    }

}
