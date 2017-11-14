package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class ClassValue {
  private Long smsTagId;
  private Double probability;

  public Long getSmsTagId() {
    return smsTagId;
  }

  public void setSmsTagId(Long smsTagId) {
    this.smsTagId = smsTagId;
  }

  public Double getProbability() {
    return probability;
  }

  public void setProbability(Double probability) {
    this.probability = probability;
  }

  public static final class Builder {
    private Long smsTagId;
    private Double probability;

    private Builder() {
    }

    public static Builder aClassValue() {
      return new Builder();
    }

    public Builder smsTagId(Long smsTagId) {
      this.smsTagId = smsTagId;
      return this;
    }

    public Builder probability(Double probability) {
      this.probability = probability;
      return this;
    }

    public ClassValue build() {
      ClassValue classValue = new ClassValue();
      classValue.setSmsTagId(smsTagId);
      classValue.setProbability(probability);
      return classValue;
    }
  }
}
