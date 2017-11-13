package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.Model;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class Page<E extends Model> {
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
