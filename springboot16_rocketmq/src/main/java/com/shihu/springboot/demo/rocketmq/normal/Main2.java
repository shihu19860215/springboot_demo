package com.shihu.springboot.demo.rocketmq.normal;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Consumer consumer=new Consumer();
        consumer.start();
        System.in.read();
        consumer.stop();
    }
}
