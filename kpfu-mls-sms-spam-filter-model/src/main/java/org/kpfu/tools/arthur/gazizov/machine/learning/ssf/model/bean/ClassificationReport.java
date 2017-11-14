package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class ClassificationReport {
  List<ClassValue> classValues;

  public List<ClassValue> getClassValues() {
    return classValues;
  }

  public void setClassValues(List<ClassValue> classValues) {
    this.classValues = classValues;
  }

  public static final class Builder {
    List<ClassValue> classValues;

    private Builder() {
    }

    public static Builder aClassificationReport() {
      return new Builder();
    }

    public Builder classValues(List<ClassValue> classValues) {
      this.classValues = classValues;
      return this;
    }

    public ClassificationReport build() {
      ClassificationReport classificationReport = new ClassificationReport();
      classificationReport.setClassValues(classValues);
      return classificationReport;
    }
  }
}
