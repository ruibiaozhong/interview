package com.leihou.interview.util;

import java.util.Date;
import java.util.UUID;

public class IdUtil {


    public static String generateId() {
        return UUID.randomUUID().toString();
    }


}
