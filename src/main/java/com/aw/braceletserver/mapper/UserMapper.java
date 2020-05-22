package com.aw.braceletserver.mapper;

import com.aw.braceletserver.entity.User;
import com.aw.braceletserver.entity.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
	/**
	 * mysql分页查询
	 * */
    List<User> selectByPage(Map<String, Object> map);
    /**根据条件查询记录条数*/
    int selectCountBy(Map<String, Object> map);
    
    /**查询最大序号*/
    Integer selectMaxNo();
    
    User selectByPrimaryKey(String code);
    
    long countByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}