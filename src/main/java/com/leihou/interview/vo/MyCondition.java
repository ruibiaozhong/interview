package com.leihou.interview.vo;

import lombok.Data;

import java.util.List;

@Data
public class MyCondition {

    private String like;

    private String notLike;

    private List<Integer> between;

    private List<Integer> notBetween;

    private Boolean isNull;

    private Boolean isNotNull;

    private Integer greaterThan;

    private Integer greaterThanOrEqualTo;

    private Integer lessThan;

    private Integer lessThanOrEqualTo;

    private List<String> iin;

    private List<String> notInin;



}
