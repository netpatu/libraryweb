package com.example.library.demo.web.data;

import com.example.library.demo.entity.Book;
import com.example.library.demo.utils.DateUtil;

public class ReponseData<T> {
    private Integer status = 0;
    private Integer code = 0;
    private String msg;
    private T data;

    public ReponseData(Integer code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ReponseData(Integer code, Integer status,String msg,T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
