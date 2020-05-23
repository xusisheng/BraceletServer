package com.aw.braceletserver.mapper;

import com.aw.braceletserver.model.TxUser;
import com.aw.braceletserver.model.TxUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TxUserMapper {
    long countByExample(TxUserExample example);

    int deleteByExample(TxUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TxUser record);

    int insertSelective(TxUser record);

    List<TxUser> selectByExample(TxUserExample example);

    TxUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TxUser record, @Param("example") TxUserExample example);

    int updateByExample(@Param("record") TxUser record, @Param("example") TxUserExample example);

    int updateByPrimaryKeySelective(TxUser record);

    int updateByPrimaryKey(TxUser record);

    TxUser selectLogin(Map<String, Object> map);

    Integer selectMaxId();

    List<Map<String, Object>> selectAllDeviceData();
}