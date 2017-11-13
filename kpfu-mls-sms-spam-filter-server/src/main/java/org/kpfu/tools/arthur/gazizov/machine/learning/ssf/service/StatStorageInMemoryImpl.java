package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.exception.KpfuMlsSsfError;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class StatStorageInMemoryImpl implements StatStorage {
  private final Map<Long, WordsStat> wordsStatMap = new ConcurrentHashMap<>();
  private final Map<Long, TagsStat> tagsStatMap = new ConcurrentHashMap<>();

  @Override
  public WordsStat getWordsStat(Long dataSetId) {
    return Optional.of(dataSetId)
            .map(wordsStatMap::get)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);
  }

  @Override
  public WordsStat saveWordsStat(Long dataSetId, WordsStat wordsStat) {
    wordsStatMap.put(dataSetId, wordsStat);
    return wordsStat;
  }

  @Override
  public TagsStat getTagsStat(Long dataSetId) {
    return Optional.of(dataSetId)
            .map(tagsStatMap::get)
            .orElseThrow(KpfuMlsSsfError.STAT_NOT_FOUND::exception);
  }

  @Override
  public TagsStat saveTagsStat(Long dataSetId, TagsStat tagsStat) {
    tagsStatMap.put(dataSetId, tagsStat);
    return tagsStat;
  }
}
