package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class Counter<T> extends HashMap<T, Integer> implements Map<T, Integer> {
  public void increment(T key) {
    put(key, getOrDefault(key, 0) + 1);
  }
}
