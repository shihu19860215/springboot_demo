package com.shihu.demo.dynamic.datasource.bean;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MutilDataSource extends AbstractRoutingDataSource {
  public static  ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

  public MutilDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
    super.setDefaultTargetDataSource(defaultTargetDataSource);
    super.setTargetDataSources(targetDataSources);
    super.afterPropertiesSet();
  }

  @Override
  protected Object determineCurrentLookupKey() {
    return getDataSource();
  }


  public static void setDataSource(String dataSource) {
    CONTEXT_HOLDER.set(dataSource);
  }

  public static String getDataSource() {
    return CONTEXT_HOLDER.get();
  }

  public static void clearDataSource() {
    CONTEXT_HOLDER.remove();
  }

}
