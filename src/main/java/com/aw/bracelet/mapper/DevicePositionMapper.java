package com.aw.bracelet.mapper;

import com.aw.bracelet.model.DevicePosition;
import com.aw.bracelet.model.DevicePositionExample;

import java.util.HashMap;
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

    List<HashMap<String, Object>> selectSosByUserIdTime(@Param("userId") Long userId, @Param("startTime") String startTime, @Param("endTime") String endTime);
}