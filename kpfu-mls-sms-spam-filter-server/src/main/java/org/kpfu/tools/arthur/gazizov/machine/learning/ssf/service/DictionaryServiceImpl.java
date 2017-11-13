package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.support.Page;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordTagCounter;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util.SmsAnalyser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
  @Autowired
  private DataSetElementDao dataSetElementDao;

  @Autowired
  private SmsTagService smsTagService;

  @Autowired
  private SmsAnalyser smsAnalyser;

  @Autowired
  private StatStorage statStorage;

  @Override
  public void process(Long dataSetId) {
    final List<SmsTagModel> allTags = smsTagService.findAll();
    WordsStat wordsStat = new WordsStat();
    TagsStat tagsStat = defaultTagsStat(allTags);

    statStorage.saveTagsStat(dataSetId, tagsStat);
    statStorage.saveWordsStat(dataSetId, wordsStat);

    final Page<DataSetElementModel> page = dataSetElementDao.page(dataSetId, null, null);
    final List<DataSetElementModel> data = page.getData();
    for (DataSetElementModel elementModel : data) {
      final String sms = elementModel.getSms();
      final List<String> words = smsAnalyser.fetchWords(sms);
      for (String word : words) {
        wordsStat.computeIfAbsent(word, s -> defaultCounter(allTags)).increment(elementModel.getSmsTagId());
        tagsStat.increment(elementModel.getSmsTagId());
      }
    }
  }

  @Override
  public TagsStat getTagStat(Long dataSetId) {
    return statStorage.getTagsStat(dataSetId);
  }

  @Override
  public WordsStat getWordStat(Long dataSetId) {
    return statStorage.getWordsStat(dataSetId);
  }

  private WordTagCounter defaultCounter(List<SmsTagModel> smsTagModels) {
    final WordTagCounter wordTagCounter = new WordTagCounter();
    wordTagCounter.putAll(smsTagModels.stream().map(SmsTagModel::getId).collect(Collectors.toMap(Function.identity(), id -> 0)));
    return wordTagCounter;
  }

  private TagsStat defaultTagsStat(List<SmsTagModel> smsTagModels) {
    final TagsStat tagsStat = new TagsStat();
    tagsStat.putAll(smsTagModels.stream().map(SmsTagModel::getId).collect(Collectors.toMap(Function.identity(), id -> 0)));
    return tagsStat;
  }
}
