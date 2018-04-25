package com.shihu.demo.springboot.property.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "com.user")
public class User {
    private String name;
    private Map<String,String> workmap;
    private List<String> addrs;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", workmap=" + workmap +
                ", addrs=" + addrs +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getWorkmap() {
        return workmap;
    }

    public void setWorkmap(Map<String, String> workmap) {
        this.workmap = workmap;
    }

    public List<String> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<String> addrs) {
        this.addrs = addrs;
    }

}
