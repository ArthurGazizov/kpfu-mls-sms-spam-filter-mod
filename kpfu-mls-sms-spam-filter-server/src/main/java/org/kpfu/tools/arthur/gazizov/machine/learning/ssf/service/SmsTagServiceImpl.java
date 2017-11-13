package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.SmsTagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class SmsTagServiceImpl implements SmsTagService {
  @Autowired
  private SmsTagDao smsTagDao;

  @Override
  public SmsTagModel get(Long id) {
    return Optional.of(id)
            .map(smsTagDao::find)
            .orElseThrow(KpfuMlsSsfError.SMS_TAG_NOT_FOUND::exception);
  }

  @Override
  public SmsTagModel save(SmsTagModel smsTagModel) {
    return smsTagDao.save(smsTagModel);
  }

  @Override
  public SmsTagModel update(SmsTagModel smsTagModel) {
    return smsTagDao.update(smsTagModel);
  }

  @Override
  public SmsTagModel patch(SmsTagModel smsTagModel) {
    final SmsTagModel dataSetModel = Optional.ofNullable(smsTagDao.find(smsTagModel.getId()))
            .orElseThrow(KpfuMlsSsfError.DATA_SET_NOT_FOUND::exception);
    if (StringUtils.hasText(smsTagModel.getName())) {
      dataSetModel.setName(smsTagModel.getName());
    }
    if (StringUtils.hasText(smsTagModel.getCode())) {
      dataSetModel.setCode(smsTagModel.getCode());
    }
    return smsTagDao.update(dataSetModel);
  }

  @Override
  public void delete(Long id) {
    smsTagDao.delete(id);
  }

  @Override
  public SmsTagModel restore(Long id) {
    smsTagDao.restore(id);
    return get(id);
  }

  @Override
  public List<SmsTagModel> findAll() {
    return StreamSupport.stream(smsTagDao.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }
}
