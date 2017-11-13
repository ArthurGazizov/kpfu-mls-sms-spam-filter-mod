package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class Probability {
  private Double value;
  private String word;
  private Long dataSetId;
  private Long smsTagId;

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public Long getDataSetId() {
    return dataSetId;
  }

  public void setDataSetId(Long dataSetId) {
    this.dataSetId = dataSetId;
  }

  public Long getSmsTagId() {
    return smsTagId;
  }

  public void setSmsTagId(Long smsTagId) {
    this.smsTagId = smsTagId;
  }

  public static final class Builder {
    private Double value;
    private String word;
    private Long dataSetId;
    private Long smsTagId;

    private Builder() {
    }

    public static Builder aProbability() {
      return new Builder();
    }

    public Builder value(Double value) {
      this.value = value;
      return this;
    }

    public Builder word(String word) {
      this.word = word;
      return this;
    }

    public Builder dataSetId(Long dataSetId) {
      this.dataSetId = dataSetId;
      return this;
    }

    public Builder smsTagId(Long smsTagId) {
      this.smsTagId = smsTagId;
      return this;
    }

    public Probability build() {
      Probability probability = new Probability();
      probability.setValue(value);
      probability.setWord(word);
      probability.setDataSetId(dataSetId);
      probability.setSmsTagId(smsTagId);
      return probability;
    }
  }
}
