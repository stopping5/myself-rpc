package com.rpc.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.rpc")
public class SpringConfig {

    @Bean
    public RpcServer rpcServer(){
        return new RpcServer(8080);
    }
}
