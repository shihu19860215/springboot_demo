package com.shihu.springboot.demo.rocketmq.pull;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProducerMain {
    public static void main(String[] args) throws IOException {
        Producer producer=new Producer();
        producer.start();
        for(int i=0;i<100;i++){
            long oId=i%5;
            producer.sendMessage("oId:"+oId+"----Hello RocketMQ " + i, "TopicTest",
                    "TagTest", "Key" + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producer.stop();
    }
}
