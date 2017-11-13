package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.impl.DataSetDtoValidatorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.impl.DataSetElementDtoValidatorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.impl.SmsTagDtoValidatorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.DataSetDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.DataSetElementDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.validator.interfaces.SmsTagDtoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Configuration
public class ValidationConfig {
  @Bean
  public DataSetDtoValidator dataSetDtoValidator() {
    return new DataSetDtoValidatorImpl();
  }

  @Bean
  public DataSetElementDtoValidator dataSetElementDtoValidator() {
    return new DataSetElementDtoValidatorImpl();
  }

  @Bean
  public SmsTagDtoValidator smsTagDtoValidator() {
    return new SmsTagDtoValidatorImpl();
  }
}
