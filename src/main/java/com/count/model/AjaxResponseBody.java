package com.count.model;

import java.util.List;

public class AjaxResponseBody {

    String msg;
    List<Word> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Word> getResult() {
        return result;
    }

    public void setResult(List<Word> result) {
        this.result = result;
    }

}
