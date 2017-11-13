package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface DictionaryProcessor {
  ResponseEntity<Void> apply(Long dataSetId);

  ResponseEntity<TagsStat> getTagStat(Long dataSetId);

  ResponseEntity<WordsStat> getWordsStat(Long dataSetId);
}
