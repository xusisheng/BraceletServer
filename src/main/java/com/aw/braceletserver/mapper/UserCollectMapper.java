package com.aw.braceletserver.mapper;

import com.aw.braceletserver.entity.UserCollect;

import java.util.List;
import java.util.Map;

public interface UserCollectMapper {
    /**查询用户收藏*/
    List<UserCollect> selectCollect(Map<String, Object> map);
    
    /**根据收藏记录数*/
    int selectCollectNum(Map<String, Object> map);
    
    int deleteByPrimaryKey(String pkid);

    int insert(UserCollect record);

    int insertSelective(UserCollect record);

    UserCollect selectByPrimaryKey(String pkid);

    int updateByPrimaryKeySelective(UserCollect record);

    int updateByPrimaryKey(UserCollect record);
}