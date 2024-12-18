package com.rpc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class User implements Serializable {

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;


}
