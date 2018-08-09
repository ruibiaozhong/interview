package com.leihou.interview.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {


    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }


}
