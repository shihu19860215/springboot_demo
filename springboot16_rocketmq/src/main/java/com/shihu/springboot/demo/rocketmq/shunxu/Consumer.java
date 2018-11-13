package com.shihu.springboot.demo.rocketmq.shunxu;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * RocketMQ消费者
 *
 * @Author Xusg
 * @Date 18/2/5 17:46
 */
public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private String namesrvAddr="192.168.7.160:9876";

    private final DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("TestRocketMQPushConsumer");

    /**
     * 初始化
     *
     * @throws MQClientException
     */
    public void start() {
        try {
            LOGGER.info("MQ：启动消费者");

            consumer.setNamesrvAddr(namesrvAddr);
            // 从消息队列头开始消费
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            // 集群消费模式
            consumer.setMessageModel(MessageModel.CLUSTERING);
            // 订阅主题
            consumer.subscribe("TopicTest", "*");
            // 注册消息监听器
            consumer.registerMessageListener(new MessageListenerOrderly() {
                AtomicLong consumeTimes = new AtomicLong(0);

                @Override
                public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                    // 设置自动提交
                    context.setAutoCommit(true);
                    for (MessageExt msg : msgs) {
                        System.out.println(msg + ",内容：" + new String(msg.getBody()));
                    }

                   /* try {
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    ;*/

                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
            // 启动消费端
            consumer.start();
        } catch (MQClientException e) {
            LOGGER.error("MQ：启动消费者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }

    }


    public void stop() {
        if (consumer != null) {
            consumer.shutdown();
            LOGGER.error("MQ：关闭消费者");
        }
    }

}
