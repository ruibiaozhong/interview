package com.leihou.interview.mq.producer;

import com.github.houbb.junitperf.core.annotation.JunitPerfConfig;
import com.github.houbb.junitperf.core.report.impl.ConsoleReporter;
import com.github.houbb.junitperf.core.report.impl.HtmlReporter;
import org.junit.Test;

public class HelloWorldTest {

    @JunitPerfConfig(duration = 1000, reporter = {ConsoleReporter.class, HtmlReporter.class}, threads = 10)
    public void helloTest() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Hello Junit5");
    }


}
