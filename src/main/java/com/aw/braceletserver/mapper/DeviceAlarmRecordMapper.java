package com.aw.braceletserver.mapper;

import com.aw.braceletserver.model.DeviceAlarmRecord;
import com.aw.braceletserver.model.DeviceAlarmRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceAlarmRecordMapper {
    long countByExample(DeviceAlarmRecordExample example);

    int deleteByExample(DeviceAlarmRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeviceAlarmRecord record);

    int insertSelective(DeviceAlarmRecord record);

    List<DeviceAlarmRecord> selectByExample(DeviceAlarmRecordExample example);

    DeviceAlarmRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeviceAlarmRecord record, @Param("example") DeviceAlarmRecordExample example);

    int updateByExample(@Param("record") DeviceAlarmRecord record, @Param("example") DeviceAlarmRecordExample example);

    int updateByPrimaryKeySelective(DeviceAlarmRecord record);

    int updateByPrimaryKey(DeviceAlarmRecord record);
}