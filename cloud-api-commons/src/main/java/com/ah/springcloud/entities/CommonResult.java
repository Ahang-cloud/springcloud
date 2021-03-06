package com.ah.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    /**
     * 查询为空的时候使用的构造器
     * @param code
     * @param messgae
     */
    public CommonResult(Integer code, String messgae){
        this(code, messgae, null);
    }
}
