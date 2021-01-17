package com.shida.labchecksys.common;

import java.io.Serializable;

public class JsonResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private JsonResponse(T data) {
        this.data = data;
        this.code = 200;//成功的状态码200
    }

    private JsonResponse(T data, String mes) {
        this.data = data;
        this.code = 200;//成功的状态码200
        this.msg = mes;
    }

    private JsonResponse(String msg) {
        this.code = 100;//失败的状态码100
        this.msg = msg;
    }

    public static <T> JsonResponse toSuccess(T data) {
        return new JsonResponse(data);
    }

    public static <T> JsonResponse toSuccess(T data, String mes) {
        return new JsonResponse(data, mes);
    }

    public static <T> JsonResponse toSuccess(String mes) {
        return new JsonResponse(mes);
    }

    public static <T> JsonResponse toFailed(String mes) {
        return new JsonResponse(mes);
    }

    public boolean isSuccess() {
        return this.code == 200 ? true : false;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

