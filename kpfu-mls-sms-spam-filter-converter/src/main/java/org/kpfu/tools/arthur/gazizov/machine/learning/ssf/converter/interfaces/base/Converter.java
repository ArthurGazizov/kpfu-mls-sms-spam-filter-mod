package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.interfaces.base;

import jdk.nashorn.internal.objects.annotations.Function;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public interface Converter<E extends Model, T extends Dto> {
  @Function
  T convert(E model);

  @Function
  E convert(T dto);
}

