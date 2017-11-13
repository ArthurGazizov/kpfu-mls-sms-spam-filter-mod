package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.config;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class KpfuMlsSsfServerConfigurationProperties {
  private Double aprioriProbability = 0.5;
  private Double weight = 1.0;

  public Double getAprioriProbability() {
    return aprioriProbability;
  }

  public void setAprioriProbability(Double aprioriProbability) {
    this.aprioriProbability = aprioriProbability;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }
}
