package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class SmsAnalyserRegexImpl implements SmsAnalyser {
  private static final Pattern PATTERN = Pattern.compile("\\w+");

  @Override
  public List<String> fetchWords(String s) {
    final Matcher matcher = PATTERN.matcher(s);
    List<String> list = new ArrayList<>();
    while (matcher.find()){
      String word = matcher.group();
      word = word.trim().toLowerCase();
      if (StringUtils.hasText(word)){
        list.add(word);
      }
    }
    return list;
  }
}
