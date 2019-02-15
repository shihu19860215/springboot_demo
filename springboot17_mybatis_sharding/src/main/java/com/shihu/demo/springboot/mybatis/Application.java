package com.shihu.demo.springboot.mybatis;

import com.shihu.demo.springboot.mybatis.model.City;
import com.shihu.demo.springboot.mybatis.service.CityService;
import com.shihu.demo.springboot.mybatis.util.IdGenerate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.shihu.demo.springboot.mybatis.dao")
public class Application {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		CityService cityService=context.getBean(CityService.class);
		List<City> cityList=new ArrayList<>();
		for(int i=0;i<100;i++){
			long id=IdGenerate.getUid();
			City city=new City();
			city.setId(id);
			city.setCityName(id+"");
			cityList.add(city);
		}
		System.out.println(cityService.insertCollection(cityList));
	}
}
