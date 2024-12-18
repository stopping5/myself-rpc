package com.rpc.core;

import com.rpc.common.RpcRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

/**
 * Rpc 远程调用
 */
@AllArgsConstructor
@Data
public class RpcNetTransport {

    private String host;

    private Integer port;


    /**
     * 调用远程服务
     * @param request
     * @return
     */
    public Object send(RpcRequest request){
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            Socket socket = new Socket(host, port);
            //写入数据
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            //读取返回值
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object o = objectInputStream.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (Objects.nonNull(objectInputStream)){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (Objects.nonNull(objectInputStream)){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }
}
