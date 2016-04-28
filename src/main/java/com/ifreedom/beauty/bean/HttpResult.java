package com.ifreedom.beauty.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eavawu on 4/28/16.
 */
public class HttpResult {
    private int result;
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private Map<String,Object> data = new HashMap<>();
}
