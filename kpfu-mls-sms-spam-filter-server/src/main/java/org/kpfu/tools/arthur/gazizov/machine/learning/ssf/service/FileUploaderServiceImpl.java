package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.SmsTagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class FileUploaderServiceImpl implements FileUploaderService {
  @Autowired
  private DataSetDao dataSetDao;

  @Autowired
  private SmsTagDao smsTagDao;

  @Autowired
  private DataSetElementDao dataSetElementDao;

  @Override
  public DataSetModel uploadFile(Long datasetId, MultipartFile file) {
    final DataSetModel dataSetModel = Optional.of(datasetId)
            .map(dataSetDao::find)
            .orElseThrow(KpfuMlsSsfError.DATA_SET_NOT_FOUND::exception);
    final List<String> strings = read(file);
    strings.stream()
            .map(s -> parse(s, datasetId))
            .collect(Collectors.toList());
    return dataSetModel;
  }

  private DataSetElementModel parse(String row, Long dataSetId) {
    final int firstSpace = row.indexOf("\t");
    final String code = row.substring(0, firstSpace);
    final String sms = row.substring(firstSpace + 1);
    final SmsTagModel smsTagModel = Optional.of(code)
            .map(smsTagDao::findByCode)
            .orElseThrow(KpfuMlsSsfError.SMS_TAG_NOT_FOUND::exception);
    final DataSetElementModel elementModel = DataSetElementModel.Builder.aDataSetElementModel()
            .sms(sms)
            .smsTagId(smsTagModel.getId())
            .datasetId(dataSetId)
            .build();
    return dataSetElementDao.save(elementModel);
  }

  private List<String> read(MultipartFile file) {
    try {
      final BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
      List<String> rows = new ArrayList<>();
      String row = reader.readLine();
      while (Objects.nonNull(row)) {
        rows.add(row);
        row = reader.readLine();
      }
      return rows;
    } catch (IOException e) {
      throw KpfuMlsSsfError.IO_EXCEPTION.exception();
    }
  }
}
