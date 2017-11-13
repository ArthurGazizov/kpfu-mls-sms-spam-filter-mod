package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal;

import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.base.CRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public interface SmsTagDao extends CRUDDao<Long, SmsTagModel> {
  SmsTagModel findByCode(String code);
}
