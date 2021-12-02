package com.shihu.demo.dynamic.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.shihu.demo.dynamic.datasource.bean.MutilDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

  @Bean
  @Primary
  public MutilDataSource dataSource(){
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://192.168.70.61:3306/db_car?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
    dataSource.setUsername("root");
    dataSource.setPassword("5523003");

    Map<Object, Object> map = new HashMap<>();

    for(int i=0;i<2;i++){
      dataSource = new DruidDataSource();
      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
      dataSource.setUrl("jdbc:mysql://192.168.70.61:3306/db_car_"+i+"?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true");
      dataSource.setUsername("root");
      dataSource.setPassword("5523003");
      map.put("db"+i, dataSource);
    }
    return new MutilDataSource(dataSource, map);
  }
}
