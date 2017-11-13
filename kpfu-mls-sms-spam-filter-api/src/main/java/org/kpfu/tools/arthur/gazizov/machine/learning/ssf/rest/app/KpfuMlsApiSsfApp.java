package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.app;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.rest.config.KpfuMlsApiSsfAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@SpringBootApplication
@Import(KpfuMlsApiSsfAppConfig.class)
public class KpfuMlsApiSsfApp {
  public static void main(String[] args) {
    SpringApplication.run(KpfuMlsApiSsfApp.class, args);
  }
}
