package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.records.DataSetElementRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.DataSetElement.DATA_SET_ELEMENT;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Repository
public class DataSetElementDaoImpl extends AbstractCRUDDao<DataSetElementModel, DataSetElementRecord> implements DataSetElementDao {
  @Autowired
  private DataSetElementMapper dataSetElementMapper;

  @Override
  protected Table<DataSetElementRecord> table() {
    return DATA_SET_ELEMENT;
  }

  @Override
  protected Mapper<DataSetElementModel, DataSetElementRecord> mapper() {
    return dataSetElementMapper;
  }

  @Override
  protected Field<Long> idField() {
    return DATA_SET_ELEMENT.DATA_SET_ELEMENT_ID;
  }

  @Override
  public Page<DataSetElementModel> page(Long dataSetId, Integer offset, Integer limit) {
    final SelectQuery<Record> selectQuery = getDslContext().selectQuery();
    selectQuery.addSelect(selectFields());
    selectQuery.addFrom(table());
    selectQuery.addSelect(DSL.count().over());
    if (Objects.nonNull(dataSetId)) {
      selectQuery.addConditions(DATA_SET_ELEMENT.DATA_SET_ID.eq(dataSetId));
    }
    if (Objects.nonNull(limit)) {
      if (Objects.nonNull(offset)) {
        selectQuery.addLimit(offset, limit);
      } else {
        selectQuery.addLimit(limit);
      }
    }
    final Result<Record> fetch = selectQuery.fetch();
    final List<DataSetElementModel> data = fetch.stream()
            .map(mapper()::mapToModel)
            .collect(Collectors.toList());
    final Page<DataSetElementModel> page = new Page<>();
    page.setData(data);
    page.setOffset(offset);
    page.setTotalCount(fetch.getValue(0, DSL.count().over()));
    return page;
  }
}
