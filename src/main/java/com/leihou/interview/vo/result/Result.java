package com.leihou.interview.vo.result;

import com.leihou.interview.constant.ResultConst;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {

    private String status;

    private String code;

    private String msg;


    public Result() {
        this.status = ResultConst.status.TRUE;
        this.code = ResultConst.code.SUCCESS;
    }

    public void setInvild(String msg) {
        this.status = ResultConst.status.FALSE;
        this.msg = msg;
    }



}
