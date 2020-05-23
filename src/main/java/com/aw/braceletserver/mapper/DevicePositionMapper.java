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

    int deleteByPrimaryKey(Integer id);

    int insert(DevicePosition record);

    int insertSelective(DevicePosition record);

    List<DevicePosition> selectByExample(DevicePositionExample example);

    DevicePosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DevicePosition record, @Param("example") DevicePositionExample example);

    int updateByExample(@Param("record") DevicePosition record, @Param("example") DevicePositionExample example);

    int updateByPrimaryKeySelective(DevicePosition record);

    int updateByPrimaryKey(DevicePosition record);

    Integer selectMaxDevicePositionId();
}