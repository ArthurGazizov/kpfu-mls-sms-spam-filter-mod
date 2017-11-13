package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.base.CRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support.Page;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public interface DataSetElementDao extends CRUDDao<Long, DataSetElementModel> {
  Page<DataSetElementModel> page(Long dataSetId, Integer offset, Integer limit);
}
