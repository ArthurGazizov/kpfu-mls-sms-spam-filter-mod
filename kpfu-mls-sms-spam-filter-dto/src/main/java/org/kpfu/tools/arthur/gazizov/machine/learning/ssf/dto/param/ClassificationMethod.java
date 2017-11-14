package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto.param;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public enum ClassificationMethod {
  FISHER_CLASSIFICATION("FISHER_CLASSIFICATION"),
  BAYES_CLASSIFICATION("BAYES_CLASSIFICATION");

  private String value;

  ClassificationMethod(String value) {
    this.value = value;
  }
}
