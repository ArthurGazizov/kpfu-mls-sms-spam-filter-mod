package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class SmsTagDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated sms tag ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Sms tag name"
          , name = "name"
          , example = "example name")
  @JsonProperty("name")
  private String name;

  @ApiModelProperty(
          notes = "Sms tag code"
          , name = "code"
          , example = "ESP0")
  @JsonProperty("code")
  private String code;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;
    private String name;
    private String code;

    private Builder() {
    }

    public static Builder aSmsTagDto() {
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

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public SmsTagDto build() {
      SmsTagDto smsTagDto = new SmsTagDto();
      smsTagDto.setMetaInfoDto(metaInfoDto);
      smsTagDto.setId(id);
      smsTagDto.setName(name);
      smsTagDto.setCode(code);
      return smsTagDto;
    }
  }
}
