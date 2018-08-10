package com.leihou.interview.vo.result;

import com.leihou.interview.constant.ResultConst;

public class InfoResult<T> extends Result {

    protected T info;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        setStatus(ResultConst.status.TRUE);
        this.info = info;
    }




}
