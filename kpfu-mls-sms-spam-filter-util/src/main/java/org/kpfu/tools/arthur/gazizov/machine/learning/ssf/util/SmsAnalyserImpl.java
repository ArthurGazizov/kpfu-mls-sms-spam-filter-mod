package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class SmsAnalyserImpl implements SmsAnalyser {
  @Override
  public List<String> fetchWords(String s) {
    return Arrays.stream(s.split(" "))
            .map(String::trim)
            .filter(StringUtils::hasLength)
            .map(String::toLowerCase)
            .collect(Collectors.toList());
  }
}
