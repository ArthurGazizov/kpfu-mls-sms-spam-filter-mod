package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface DictionaryService {
  void process(Long dataSetId);

  TagsStat getTagStat(Long dataSetId);

  WordsStat getWordStat(Long dataSetId);
}
