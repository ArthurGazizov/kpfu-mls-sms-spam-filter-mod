package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.factory;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public interface ConverterFactory {
  <E extends Model, T extends Dto> Converter<? super E, ? super T> getConverter(Class<? extends E> modelClass, Class<? extends T> dtoClass);
}

