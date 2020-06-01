package com.aw.braceletserver.mapper;

import com.aw.braceletserver.model.DevicePosition;
import com.aw.braceletserver.model.DevicePositionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DevicePositionMapper {
    long countByExample(DevicePositionExample example);

    int deleteByExample(DevicePositionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DevicePosition record);

    int insertSelective(DevicePosition record);

    List<DevicePosition> selectByExample(DevicePositionExample example);

    DevicePosition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DevicePosition record, @Param("example") DevicePositionExample example);

    int updateByExample(@Param("record") DevicePosition record, @Param("example") DevicePositionExample example);

    int updateByPrimaryKeySelective(DevicePosition record);

    int updateByPrimaryKey(DevicePosition record);

    List<DevicePosition> getLastestNByDeviceId(@Param("deviceId") Long deviceId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("limit") Integer limit);

    List<DevicePosition> selectLastestBySnSet(@Param("userId") Long userId, @Param("sns") String[] sns);

    List<DevicePosition> selectLastestByUserId(@Param("userId") Long userId);
}