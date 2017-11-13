package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class DataSetElementDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated data set element ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "SMS tag id"
          , name = "smsTagId"
          , example = "2345692")
  @JsonProperty("smsTagId")
  private Long smsTagId;

  @ApiModelProperty(
          notes = "Dataset id"
          , name = "datasetId"
          , example = "2345692")
  @JsonProperty("datasetId")
  private Long datasetId;

  @ApiModelProperty(
          notes = "Sms"
          , name = "sms"
          , example = "Hello, world")
  @JsonProperty("sms")
  private String sms;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSmsTagId() {
    return smsTagId;
  }

  public void setSmsTagId(Long smsTagId) {
    this.smsTagId = smsTagId;
  }

  public Long getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(Long datasetId) {
    this.datasetId = datasetId;
  }

  public String getSms() {
    return sms;
  }

  public void setSms(String sms) {
    this.sms = sms;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;
    private Long smsTagId;
    private Long datasetId;
    private String sms;

    private Builder() {
    }

    public static Builder aDataSetElementDto() {
      return new Builder();
    }

    public Builder metaInfoDto(MetaInfoDto metaInfoDto) {
      this.metaInfoDto = metaInfoDto;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder smsTagId(Long smsTagId) {
      this.smsTagId = smsTagId;
      return this;
    }

    public Builder datasetId(Long datasetId) {
      this.datasetId = datasetId;
      return this;
    }

    public Builder sms(String sms) {
      this.sms = sms;
      return this;
    }

    public DataSetElementDto build() {
      DataSetElementDto dataSetElementDto = new DataSetElementDto();
      dataSetElementDto.setMetaInfoDto(metaInfoDto);
      dataSetElementDto.setId(id);
      dataSetElementDto.setSmsTagId(smsTagId);
      dataSetElementDto.setDatasetId(datasetId);
      dataSetElementDto.setSms(sms);
      return dataSetElementDto;
    }
  }
}
