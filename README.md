# 手写RPC说明
    基于TCP/IP协议实现RPC
# 结构

## rpc-api
用于暴露服务端的接口


## rpc-client
客户端

流程 代理-序列化-数据传输
1. 通过代理类代理原始接口
2. 根据代理获得调用的类名、方法名、参数等信息封装到RpcRequest类
3. 最后通过Socket调用ServerSocket实现接口远程调用

## rpc-server-provider
服务端

流程： 序列化 - 代理 - 调用接口实现
1. 服务端实现API接口能力
2. 通过代理的方式用ServerSocket提供服务能力
3. 所有的请求通过多线程接收处理
4. RpcRequest作为统一接口参数类，包含调用的类名、方法名、参数。
5. 根据参数通过反射机制调用实现远程调用。