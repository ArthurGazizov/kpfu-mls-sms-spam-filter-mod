package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.TagsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean.WordsStat;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.processor.interfaces.DictionaryProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Service
public class DictionaryProcessorImpl implements DictionaryProcessor {
  @Autowired
  private DictionaryService dictionaryService;

  @Override
  public ResponseEntity<Void> apply(Long dataSetId) {
    dictionaryService.process(dataSetId);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @Override
  public ResponseEntity<TagsStat> getTagStat(Long dataSetId) {
    final TagsStat tagStat = dictionaryService.getTagStat(dataSetId);
    return ResponseEntity.ok(tagStat);
  }

  @Override
  public ResponseEntity<WordsStat> getWordsStat(Long dataSetId) {
    final WordsStat wordStat = dictionaryService.getWordStat(dataSetId);
    return ResponseEntity.ok(wordStat);
  }
}
