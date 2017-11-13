package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.factory.ConverterFactory;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.factory.ConverterFactoryImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl.DataSetConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl.DataSetElementConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl.MetaInfoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.impl.SmsTagConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.SmsTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Configuration
public class ConverterConfig {
  @Bean
  public ConverterFactory converterFactory(List<Converter<? extends Model, ? extends Dto>> converters) {
    return new ConverterFactoryImpl(converters);
  }

  @Bean
  public MetaInfoConverter metaInfoConverter() {
    return new MetaInfoConverterImpl();
  }

  @Bean
  public DataSetConverter dataSetConverter() {
    return new DataSetConverterImpl();
  }

  @Bean
  public DataSetElementConverter dataSetElementConverter() {
    return new DataSetElementConverterImpl();
  }

  @Bean
  public SmsTagConverter smsTagConverter() {
    return new SmsTagConverterImpl();
  }
}
