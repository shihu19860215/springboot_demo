package com.shihu.demo.dynamic.datasource;

import com.msh.frame.client.base.BaseQO;
import com.shihu.demo.dynamic.datasource.bean.MutilDataSource;
import com.shihu.demo.dynamic.datasource.dao.single.AccountDao;
import com.shihu.demo.dynamic.datasource.model.AccountQO;
import java.util.Arrays;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan(basePackages = "com.shihu.demo.dynamic.datasource.dao.single")
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
    AccountDao bean = run.getBean(AccountDao.class);
    List list = bean.list(new AccountQO());
    MutilDataSource.setDataSource("db1");
    System.out.println(Arrays.toString(list.toArray()));
  }
}
