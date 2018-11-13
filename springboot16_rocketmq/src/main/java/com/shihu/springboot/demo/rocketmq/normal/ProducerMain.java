package com.shihu.springboot.demo.rocketmq.normal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProducerMain {
    public static void main(String[] args) throws IOException {
        List<String> list=readFromFile("D:\\temp\\hz.txt");
        Producer producer=new Producer();
        producer.start();
        for(int i=0;i<list.size();i++){
            producer.sendMessage(list.get(i), "entnametest",
                    null, "Key" + i);
        }
        producer.stop();
    }

    public static List<String> readFromFile(String filePath) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream(filePath),"UTF-8");
        BufferedReader br=new BufferedReader(isr);
        List<String> list=new LinkedList<String>();
        String str=br.readLine();
        while(null!=str){
            if(!"".equals(str.trim())){
                list.add(str);
            }
            str=br.readLine();
        }
        br.close();
        return list;
    }
}
