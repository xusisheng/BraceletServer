package com.aw.bracelet.mapper;

import com.aw.bracelet.model.UserDevice;
import com.aw.bracelet.model.UserDeviceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDeviceMapper {
    long countByExample(UserDeviceExample example);

    int deleteByExample(UserDeviceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDevice record);

    int insertSelective(UserDevice record);

    List<UserDevice> selectByExample(UserDeviceExample example);

    UserDevice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    int updateByExample(@Param("record") UserDevice record, @Param("example") UserDeviceExample example);

    int updateByPrimaryKeySelective(UserDevice record);

    int updateByPrimaryKey(UserDevice record);

//    List<UserDevice> selectBySnSet(@Param("userId") Long userId, @Param("ids") String[] ids);
}