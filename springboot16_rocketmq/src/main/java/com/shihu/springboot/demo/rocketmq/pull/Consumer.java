package com.shihu.springboot.demo.rocketmq.pull;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private static final Map<MessageQueue, Long> offseTable = new HashMap<MessageQueue, Long>();


    private String namesrvAddr="192.168.7.166:9876";

    private final DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("TestRocketMQPushConsumer");

    /**
     * 初始化
     *
     * @throws MQClientException
     */
    public void start() {
        try {
            LOGGER.info("MQ：启动消费者");

            consumer.setNamesrvAddr(namesrvAddr);
            // 启动消费端
            consumer.start();
        } catch (MQClientException e) {
            LOGGER.error("MQ：启动消费者失败：{}-{}", e.getResponseCode(), e.getErrorMessage());
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    public void pull() throws MQClientException {
        Set<MessageQueue> mqs = consumer.fetchSubscribeMessageQueues("TopicTest");
        for (MessageQueue mq : mqs) {
            System.out.println("Consume from the queue: " + mq);
            SINGLE_MQ:
            try {
                PullResult pullResult =
                        consumer.pullBlockIfNotFound(mq, null, getMessageQueueOffset(mq), 32);
                System.out.println(pullResult);
                putMessageQueueOffset(mq, pullResult.getNextBeginOffset());
                switch (pullResult.getPullStatus()) {
                    case FOUND:
                        for(MessageExt messageExt:pullResult.getMsgFoundList()){
                            System.out.println(new String(messageExt.getBody()));
                        }

                        break;
                    case NO_MATCHED_MSG:
                        break;
                    case NO_NEW_MSG:
                        break SINGLE_MQ;
                    case OFFSET_ILLEGAL:
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void stop() {
        if (consumer != null) {
            consumer.shutdown();
            LOGGER.error("MQ：关闭消费者");
        }
    }


    private static void putMessageQueueOffset(MessageQueue mq, long offset) {

        offseTable.put(mq, offset);

    }

    private static long getMessageQueueOffset(MessageQueue mq) {

        Long offset = offseTable.get(mq);

        if (offset != null) {
            return offset;
        }
        return 0;

    }

}
