package com.rpc.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * RPC调用锁需要的参数
 */
@AllArgsConstructor
@Data
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] param;
}