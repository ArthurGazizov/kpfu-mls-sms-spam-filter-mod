package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
//persistence
public interface StatStorage {
  WordsStat getWordsStat(Long dataSetId);

  WordsStat saveWordsStat(Long dataSetId, WordsStat wordsStat);

  TagsStat getTagsStat(Long dataSetId);

  TagsStat saveTagsStat(Long dataSetId, TagsStat tagsStat);
}
