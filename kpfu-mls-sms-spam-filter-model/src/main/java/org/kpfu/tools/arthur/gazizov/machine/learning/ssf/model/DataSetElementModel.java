package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class DataSetElementModel extends BaseEntityModel {
  private Long datasetId;
  private Long smsTagId;
  private String sms;

  public Long getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(Long datasetId) {
    this.datasetId = datasetId;
  }

  public Long getSmsTagId() {
    return smsTagId;
  }

  public void setSmsTagId(Long smsTagId) {
    this.smsTagId = smsTagId;
  }

  public String getSms() {
    return sms;
  }

  public void setSms(String sms) {
    this.sms = sms;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private Long datasetId;
    private Long smsTagId;
    private String sms;

    private Builder() {
    }

    public static Builder aDataSetElementModel() {
      return new Builder();
    }

    public Builder datasetId(Long datasetId) {
      this.datasetId = datasetId;
      return this;
    }

    public Builder metaInfoModel(MetaInfoModel metaInfoModel) {
      this.metaInfoModel = metaInfoModel;
      return this;
    }

    public Builder smsTagId(Long smsTagId) {
      this.smsTagId = smsTagId;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder sms(String sms) {
      this.sms = sms;
      return this;
    }

    public Builder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public DataSetElementModel build() {
      DataSetElementModel dataSetElementModel = new DataSetElementModel();
      dataSetElementModel.setDatasetId(datasetId);
      dataSetElementModel.setMetaInfoModel(metaInfoModel);
      dataSetElementModel.setSmsTagId(smsTagId);
      dataSetElementModel.setId(id);
      dataSetElementModel.setSms(sms);
      dataSetElementModel.isDeleted = this.isDeleted;
      return dataSetElementModel;
    }
  }
}
