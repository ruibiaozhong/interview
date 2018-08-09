package com.leihou.interview.mq.producer;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicInteger;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MyTest {

    //用来并发技术 调用了多少次方法
    private static int num;

    private static AtomicInteger count = new AtomicInteger();

    @Test(timeout = 100)
    public void testExpression() {

        try {
            Thread.sleep(99);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("helloworld");



    }






}
