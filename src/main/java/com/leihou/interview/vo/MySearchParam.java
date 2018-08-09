package com.leihou.interview.vo;

import lombok.Data;

import java.util.List;

@Data
public class MySearchParam {


    private Integer pageNo;

    private Integer pageSize;

    private String sortItem;

    private String sortOrder;

    private List<Filters> filters;


}
