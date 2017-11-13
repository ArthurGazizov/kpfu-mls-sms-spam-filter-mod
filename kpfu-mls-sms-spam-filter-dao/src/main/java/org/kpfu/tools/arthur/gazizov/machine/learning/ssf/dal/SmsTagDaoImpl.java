package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.records.SmsTagRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.SmsTagMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.Tables.SMS_TAG;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
@Repository
public class SmsTagDaoImpl extends AbstractCRUDDao<SmsTagModel, SmsTagRecord> implements SmsTagDao {
  @Autowired
  private SmsTagMapper smsTagMapper;

  @Override
  protected Table<SmsTagRecord> table() {
    return SMS_TAG;
  }

  @Override
  protected Mapper<SmsTagModel, SmsTagRecord> mapper() {
    return smsTagMapper;
  }

  @Override
  protected Field<Long> idField() {
    return SMS_TAG.SMS_TAG_ID;
  }

  @Override
  public SmsTagModel findByCode(String code) {
    final Record record = getDslContext().select(selectFields())
            .from(table())
            .where(SMS_TAG.SMS_TAG_CODE.eq(code))
            .fetchOne();
    return mapper().mapToModel(record);
  }
}
