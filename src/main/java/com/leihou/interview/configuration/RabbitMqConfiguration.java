package com.leihou.interview.configuration;

import com.leihou.interview.mq.consumer.UserConsumer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitMqConfiguration {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 定制化amqp模版      可根据需要定制多个
     *
     *
     * 此处为模版类定义 Jackson消息转换器
     * ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调   即消息发送到exchange  ack
     * ReturnCallback接口用于实现消息发送到RabbitMQ 交换器，但无相应队列与交换器绑定时的回调  即消息发送不到任何一个队列中  ack
     *
     * @return the amqp template
     */
//    @Primary
//    @Bean
//    public AmqpTemplate amqpTemplate() {
////        Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
////          使用jackson 消息转换器
//        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//        rabbitTemplate.setEncoding("UTF-8");
////        开启returncallback     yml 需要 配置    publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
//            String correlationId = message.getMessageProperties().getCorrelationIdString();
//            System.out.println(correlationId);
////            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
//        });
//        //        消息确认  yml 需要配置   publisher-returns: true
//        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
//            if (ack) {
//                System.out.println(correlationData.getId());
////                log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
//            } else {
////                log.debug("消息发送到exchange失败,原因: {}", cause);
//                System.out.println(cause);
//            }
//        });
//        return rabbitTemplate;
//    }




    @Bean
    public TopicExchange userTopic() {
        return new TopicExchange("userTopic");
    }


    @Bean
    public Queue addUserQueue() {
        return new Queue("addUser");
    }

    @Bean
    public Queue updateUserQueue() {
        return new Queue("updateUser");
    }



    @Bean
    public Binding bindingAddUser() {
        return BindingBuilder.bind(addUserQueue())
                .to(userTopic())
                .with("add.user");
    }

    @Bean
    public Binding bindUpdateUser() {
        return BindingBuilder.bind(updateUserQueue())
                .to(userTopic())
                .with("update.user");
    }



}


























