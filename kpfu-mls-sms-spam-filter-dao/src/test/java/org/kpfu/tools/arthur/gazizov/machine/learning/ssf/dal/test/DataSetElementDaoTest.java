package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class DataSetElementDaoTest extends AbstractDaoTest {
  @Autowired
  private DataSetElementDao dataSetElementDao;

  @Autowired
  private DataSetDao dataSetDao;

  @Ignore
  @Test
  public void testCRUD() {
    final DataSetModel dataSetModel = generateDataSet();
    final DataSetModel savedDataSet = dataSetDao.save(dataSetModel);

    final DataSetElementModel dataSetElementModel = generateDataSetElement();
    dataSetElementModel.setDatasetId(savedDataSet.getId());

    final DataSetElementModel saved = dataSetElementDao.save(dataSetElementModel);
    Assert.assertNotNull(saved.getId());
    Assert.assertEquals(savedDataSet.getId(), saved.getDatasetId());
  }
}
