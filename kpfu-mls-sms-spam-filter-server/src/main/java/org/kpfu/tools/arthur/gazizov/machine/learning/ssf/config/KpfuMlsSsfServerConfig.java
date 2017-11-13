package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.config.ConverterConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.config.DaoConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.SmsAnalyser;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.SmsAnalyserImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.ValidationReportCheckerImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.config.ValidationConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Configuration
@Import({
        DaoConfig.class
        , ConverterConfig.class
        , ValidationConfig.class
})
@ComponentScan(
        basePackages = {
                "org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor",
                "org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service"
        }
)
public class KpfuMlsSsfServerConfig {
  @Bean
  @ConfigurationProperties
  public KpfuMlsSsfServerConfigurationProperties kpfuMlsSsfServerConfigurationProperties() {
    return new KpfuMlsSsfServerConfigurationProperties();
  }

  @Bean
  public ValidationReportChecker validationReportChecker() {
    return new ValidationReportCheckerImpl();
  }

  @Bean
  public SmsAnalyser smsAnalyser() {
    return new SmsAnalyserImpl();
  }
}
