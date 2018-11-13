package com.shihu.springboot.demo.rocketmq.shunxu;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProducerMain {
    public static void main(String[] args) throws IOException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Producer producer=new Producer();
        producer.start();
        for(int i=0;i<100;i++){
            long oId=i%5;
            producer.sendMessage(dateFormat.format(new Date())+"oId:"+oId+"----Hello RocketMQ " + i, "TopicTest",
                    "TagTest", "Key" + i,i%5);
        }
        producer.stop();
    }
}
