package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class PageResponse<E extends Dto> {
  private List<E> data;
  private Integer totalCount;
  private Integer offset;

  public List<E> getData() {
    return data;
  }

  public void setData(List<E> data) {
    this.data = data;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }
}
