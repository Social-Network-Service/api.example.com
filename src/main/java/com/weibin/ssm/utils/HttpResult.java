package com.weibin.ssm.utils;

public class HttpResult {

    private String code;
    private Object data;
    private String message;
    private Integer request_id;
    private Long time = System.currentTimeMillis();

    public HttpResult() {
        this.code = "0000";
        this.message = "success";
    }

    public HttpResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public HttpResult(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public HttpResult setData(Object data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
