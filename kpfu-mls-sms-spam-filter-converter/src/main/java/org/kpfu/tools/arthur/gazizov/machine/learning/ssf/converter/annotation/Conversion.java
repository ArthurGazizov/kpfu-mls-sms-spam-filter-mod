package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.converter.annotation;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.Model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Conversion {
  Class<? extends Model> model();

  Class<? extends Dto> dto();
}
