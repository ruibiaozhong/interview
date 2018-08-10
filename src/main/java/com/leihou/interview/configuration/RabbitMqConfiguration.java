package com.leihou.interview.configuration;

import com.leihou.interview.constant.MqConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Bean
    public AmqpTemplate amqpTemplate() {
        Logger log = LoggerFactory.getLogger(RabbitTemplate.class);
//          使用jackson 消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
//        开启returncallback     yml 需要 配置    publisher-returns: true
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationIdString();
            log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
        });
        //        消息确认  yml 需要配置   publisher-returns: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack) {
                log.debug("消息发送到exchange成功,id: {}", correlationData.getId());
            } else {
                log.debug("消息发送到exchange失败,原因: {}", cause);
            }
        });
        return rabbitTemplate;
    }

    /* ----------------------------------------------------------------------------Direct exchange test--------------------------------------------------------------------------- */

    /**
     * 声明Direct交换机 支持持久化.
     *
     * @return the exchange
     */
    @Bean
    public Exchange userTopicExchange() {
        return ExchangeBuilder.topicExchange(MqConst.exchange.TOPIC_USER_EXCHANGE).build();
    }

    /**
     * 声明一个队列 支持持久化.
     *
     * @return the queue
     */
    @Bean
    public Queue addUserQueue() {
        return QueueBuilder.durable(MqConst.queue.USER_QUEUE_ADD).build();
    }

    /**
     * 声明一个队列 支持持久化.
     *
     * @return the queue
     */
    @Bean
    public Queue updateUserQueue() {
        return QueueBuilder.durable(MqConst.queue.USER_QUEUE_UPDATE).build();
    }

    /**
     * 通过绑定键 将指定队列绑定到一个指定的交换机 .
     *
     */
    @Bean
    public Binding addUserBind() {
        return BindingBuilder.bind(addUserQueue()).to(userTopicExchange()).with(MqConst.topic.routingKey.USER_ADD).noargs();
    }

    @Bean
    public Binding updateUserBind() {
        return BindingBuilder.bind(addUserQueue()).to(userTopicExchange()).with(MqConst.topic.routingKey.USER_UPDATE).noargs();
    }


}


























