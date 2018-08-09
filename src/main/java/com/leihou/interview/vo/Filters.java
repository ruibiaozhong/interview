package com.leihou.interview.vo;

import lombok.Data;

import java.util.Map;

@Data
public class Filters {


    private String myColumn;

    private Map<String, MyCondition> map;




}
