package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service
public class DataSetElementServiceImpl implements DataSetElementService {
  @Autowired
  private DataSetElementDao dataSetElementDao;

  @Override
  public DataSetElementModel get(Long id) {
    return Optional.of(id)
            .map(dataSetElementDao::find)
            .orElseThrow(KpfuMlsSsfError.DATA_SET_ELEMENT_NOT_FOUND::exception);
  }

  @Override
  public DataSetElementModel save(DataSetElementModel dataSetElementModel) {
    return dataSetElementDao.save(dataSetElementModel);
  }

  @Override
  public DataSetElementModel update(DataSetElementModel dataSetElementModel) {
    return dataSetElementDao.update(dataSetElementModel);
  }

  @Override
  public DataSetElementModel patch(DataSetElementModel dataSetElementModel) {
    final DataSetElementModel model = Optional.ofNullable(dataSetElementDao.find(dataSetElementModel.getId()))
            .orElseThrow(KpfuMlsSsfError.DATA_SET_ELEMENT_NOT_FOUND::exception);
    if (Objects.nonNull(dataSetElementModel.getSmsTagId())) {
      model.setSmsTagId(dataSetElementModel.getSmsTagId());
    }
    if (Objects.nonNull(dataSetElementModel.getDatasetId())) {
      model.setDatasetId(dataSetElementModel.getDatasetId());
    }
    if (Objects.nonNull(dataSetElementModel.getSms())) {
      model.setSms(dataSetElementModel.getSms());
    }
    return dataSetElementDao.update(model);
  }

  @Override
  public void delete(Long id) {
    dataSetElementDao.delete(id);
  }

  @Override
  public DataSetElementModel restore(Long id) {
    dataSetElementDao.restore(id);
    return get(id);
  }

  @Override
  public List<DataSetElementModel> findAll() {
    return StreamSupport.stream(dataSetElementDao.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }

  @Override
  public Page<DataSetElementModel> page(Long dataSetId, Integer offset, Integer limit) {
    return dataSetElementDao.page(dataSetId, offset, limit);
  }
}
