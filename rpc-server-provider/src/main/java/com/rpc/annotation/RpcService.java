package com.rpc.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    /**
     * 映射的接口
     * @return
     */
    Class<?> interfaceClass();
}
