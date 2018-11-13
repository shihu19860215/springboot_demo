package com.shihu.springboot.demo.rocketmq.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TransactionListenerImpl implements TransactionListener {
    private AtomicInteger transactionIndex = new AtomicInteger(0);

    private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<>();

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        int value = new Random().nextInt(100);
        int status = value % 4;
        System.out.println(new String(msg.getBody())+"F----"+value+"----"+status);
        switch (status) {
            case 0:
                return LocalTransactionState.COMMIT_MESSAGE;
            case 1:
                return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        int value = new Random().nextInt(100);
        int status=value%4;
        System.out.println(new String(msg.getBody())+"F----"+value+"----"+status);
        switch (status) {
            case 0:
                return LocalTransactionState.COMMIT_MESSAGE;
            case 1:
                return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.UNKNOW;
    }
}
