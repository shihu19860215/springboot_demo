package com.shihu.springboot.demo.rocketmq.pull;



import org.apache.rocketmq.client.exception.MQClientException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws  IOException {
        Consumer consumer=new Consumer();
        consumer.start();
        while(true){
            try {
                consumer.pull();
                TimeUnit.SECONDS.sleep(1);
            } catch (MQClientException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
