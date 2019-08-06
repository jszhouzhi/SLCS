package com.slzr.common.domain;

public class LogContentDo {

    private  String id;
    //插入的参数
    private  String params;

    //报错信息
    private  String errMeaaager;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getErrMeaaager() {
        return errMeaaager;
    }

    public void setErrMeaaager(String errMeaaager) {
        this.errMeaaager = errMeaaager;
    }
}
