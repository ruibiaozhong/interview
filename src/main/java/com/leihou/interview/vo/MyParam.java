package com.leihou.interview.vo;

import lombok.Data;

@Data
public class MyParam {

    private Integer pageNo;

    private Integer pageSize;

    private String sortItem;

    private String sortOrder;

    private String filters;

    private String includes;

    private String refers;



}
