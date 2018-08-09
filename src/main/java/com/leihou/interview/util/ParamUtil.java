package com.leihou.interview.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.leihou.interview.vo.MyParam;
import com.leihou.interview.vo.MySearchParam;
import com.leihou.interview.vo.Filters;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;

public class ParamUtil {



//    public static  toMySearchParam(MyParam myParam) {
//
//
//
//
//        myTable.setPageNo(myParam.getPageNo());
//        myTable.setPageSize(myParam.getPageSize());
//        if (StringUtils.isNotBlank(myParam.getSortItem())) {
//            mySearchParam.setSortItem(Arrays.asList(StringUtils.split(myParam.getSortItem(),",")));
//        }
//        if (StringUtils.isNotBlank(myParam.getSortOrder())) {
//            mySearchParam.setSortOrder(Arrays.asList(StringUtils.split(myParam.getSortOrder(), ",")));
//        }
//
//        if (StringUtils.isNotBlank(myParam.getFilters())) {
//            Gson gson = new Gson();
//            Map<String, Object> map = gson.fromJson(myParam.getIncludes(), Map.class);
//            mySearchParam.setFilters(map);
//        }
//        return mySearchParam;
//    }


    public static void main(String[] args) {

        String str = "{\n" +
                "'table':" +
                "{\n" +
                "'column1': { \n" +
                "like: '%abc%', \n" +
                "notLike: '' \n" +
                "between: [1, 10], \n" +
                "notBetween: [1, 10],\n" +
                "isNull: true, \n" +
                "isNotNull: true, \n" +
                "equalTo: \"abc\",\n" +
                "notEqualTo: \"abc\", \n" +
                "greaterThan: 10, \n" +
                "greaterThanOrEqualTo: Í10,\n" +
                "lessThan: 10, \n" +
                "lessThanOrEqualTo: 10,\n" +
                "in: [], \n" +
                "notIn: [] \n" +
                "}\n" +
                "}\n" +
                "}";
        JSONObject




    }



}
