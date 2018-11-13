package com.shihu.springboot.demo.rocketmq.pull;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * RocketMQ生产者
 *
 * @Author Xusg
 * @Date 18/2/5 17:46
 */
public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private String namesrvAddr="192.168.7.166:9876";

    private final DefaultMQProducer producer = new DefaultMQProducer("TestRocketMQProducer");

    /**
     * 初始化
     */
    public void start() {
        try {
            LOGGER.info("MQ：启动生产者");
            producer.setNamesrvAddr(namesrvAddr);
            producer.start();
        } catch (MQClientException e) {
            LOGGER.error("MQ：启动生产者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 发送消息
     *
     * @param data  消息内容
     * @param topic 主题
     * @param tags  标签
     * @param keys  唯一主键
     */
    public void sendMessage(String data, String topic, String tags, String keys) {
        try {
            byte[] messageBody = data.getBytes(RemotingHelper.DEFAULT_CHARSET);

            Message mqMsg = new Message(topic, tags, keys, messageBody);

            producer.send(mqMsg);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    public void stop() {
        if (producer != null) {
            producer.shutdown();
            LOGGER.info("MQ：关闭生产者");
        }
    }
}
