package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal;

import org.jooq.Field;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.DataSetElement;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.records.DataSetElementRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    return DataSetElement.DATA_SET_ELEMENT;
  }

  @Override
  protected Mapper<DataSetElementModel, DataSetElementRecord> mapper() {
    return dataSetElementMapper;
  }

  @Override
  protected Field<Long> idField() {
    return DataSetElement.DATA_SET_ELEMENT.DATA_SET_ELEMENT_ID;
  }
}
