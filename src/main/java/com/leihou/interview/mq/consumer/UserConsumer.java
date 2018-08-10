package com.leihou.interview.mq.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leihou.interview.constant.MqConst;
import com.leihou.interview.entity.User;
import com.leihou.interview.mapper.UserMapper;
import com.leihou.interview.util.JsonUtil;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;


@Component
public class UserConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);


    @Resource
    private UserMapper userMapper;

    @Resource
    private ObjectMapper objectMapper;



    /**
     * DIRECT模式.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = MqConst.queue.USER_QUEUE_ADD)
    public void addUser1(Message message, Channel channel) throws IOException {


        User user = objectMapper.readValue(message.getBody(), User.class);

        userMapper.insert(user);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }


    @RabbitListener(queues = MqConst.queue.USER_QUEUE_ADD)
    public void addUser2(Message message, Channel channel) throws IOException {
        User user = objectMapper.readValue(message.getBody(), User.class);
        userMapper.insert(user);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }



    @RabbitListener(queues = MqConst.queue.USER_QUEUE_UPDATE)
    public void updateUser(Message message, Channel channel) throws IOException {
        System.out.println(new String(message.getBody()));


//        User user = JsonUtil.fromJson(new String(message.getBody()), User.class);
//        userMapper.updateByPrimaryKey(user);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

    }


    public static void main(String[] args) {
        String str = "{\"id\":\"ba3865ea-7695-436f-9f18-7e756a32a1ba\",\"loginid\":\"f063cdfa-9c3e-45ab-9ffd-d670c55af5da\",\"createTime\":\"Aug 10, 2018 2:32:49 PM\",\"lastUpdateTime\":\"Aug 10, 2018 2:32:49 PM\"}";
        User user = JsonUtil.fromJson(str, User.class);
        System.out.println(user);

    }


}
























