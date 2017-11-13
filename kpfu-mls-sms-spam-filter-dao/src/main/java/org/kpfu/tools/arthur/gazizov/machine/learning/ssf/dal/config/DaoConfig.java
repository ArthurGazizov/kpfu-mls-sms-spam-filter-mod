package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.SmsTagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.SmsTagDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.impl.DataSetElementMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.impl.DataSetMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.impl.SmsTagMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.DataSetMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.SmsTagMapper;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Configuration
public class DaoConfig {
  @Bean
  public DataSetMapper dataSetMapper() {
    return new DataSetMapperImpl();
  }

  @Bean
  public DataSetDao dataSetDao() {
    return new DataSetDaoImpl();
  }

  @Bean
  public DataSetElementMapper dataSetElementMapper() {
    return new DataSetElementMapperImpl();
  }

  @Bean
  public DataSetElementDao dataSetElementDao() {
    return new DataSetElementDaoImpl();
  }

  @Bean
  public SmsTagMapper smsTagMapper() {
    return new SmsTagMapperImpl();
  }

  @Bean
  public SmsTagDao smsTagDao() {
    return new SmsTagDaoImpl();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
