package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface SmsAnalyser {
  List<String> fetchWords(String s);
}
