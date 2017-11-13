package org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.impl;

import org.jooq.Record;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.tables.records.SmsTagRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.mapper.interfaces.SmsTagMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.MetaInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.ssf.model.SmsTagModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.kpfu.tools.arthur.gazizov.machine.learning.ssf.dal.jooq.kpfu_sms_filter_data.Tables.SMS_TAG;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 13.11.17.
 */
public class SmsTagMapperImpl implements SmsTagMapper {
  @Override
  public SmsTagModel mapToModel(Record record) {
    if (record == null) {
      return null;
    }
    return SmsTagModel.Builder.aSmsTagModel()
            .id(record.getValue(SMS_TAG.SMS_TAG_ID))
            .name(record.getValue(SMS_TAG.SMS_TAG_NAME))
            .code(record.getValue(SMS_TAG.SMS_TAG_CODE))
            .isDeleted(record.getValue(SMS_TAG.SMS_TAG_IS_DELETED))
            .metaInfoModel(
                    MetaInfoModel.Builder.aMetaInfoEntity()
                            .createdTs(
                                    Optional.ofNullable(record.getValue(SMS_TAG.SMS_TAG_CREATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .updatedTs(
                                    Optional.ofNullable(record.getValue(SMS_TAG.SMS_TAG_UPDATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .deletedTs(
                                    Optional.ofNullable(record.getValue(SMS_TAG.SMS_TAG_DELETED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .build()
            )
            .build();
  }

  @Override
  public SmsTagRecord mapToEntity(SmsTagModel model) {
    final SmsTagRecord record = new SmsTagRecord();
    record.setSmsTagName(model.getName());
    record.setSmsTagCode(model.getCode());
    record.setSmsTagIsDeleted(Optional.ofNullable(model.getDeleted()).orElse(false));
    final MetaInfoModel metaInfoModel = model.getMetaInfoModel();
    if (Objects.nonNull(metaInfoModel)) {
      if (Objects.nonNull(metaInfoModel.getCreatedTs())) {
        record.setSmsTagCreatedTs(Timestamp.valueOf(metaInfoModel.getCreatedTs()));
      }
      if (Objects.nonNull(metaInfoModel.getDeletedTs())) {
        record.setSmsTagDeletedTs(Timestamp.valueOf(metaInfoModel.getDeletedTs()));
      }
    }
    record.setSmsTagUpdatedTs(Timestamp.valueOf(LocalDateTime.now()));
    return record;
  }
}
