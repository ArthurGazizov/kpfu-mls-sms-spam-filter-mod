package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class ImageModel extends BaseEntityModel {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private String name;

    private Builder() {
    }

    public static Builder anImageModel() {
      return new Builder();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder metaInfoModel(MetaInfoModel metaInfoModel) {
      this.metaInfoModel = metaInfoModel;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public ImageModel build() {
      ImageModel imageModel = new ImageModel();
      imageModel.setName(name);
      imageModel.setMetaInfoModel(metaInfoModel);
      imageModel.setId(id);
      imageModel.isDeleted = this.isDeleted;
      return imageModel;
    }
  }
}
