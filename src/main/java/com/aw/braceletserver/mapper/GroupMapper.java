package com.aw.braceletserver.mapper;

import com.aw.braceletserver.entity.Group;
import com.aw.braceletserver.entity.GroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int countByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int deleteByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int deleteByPrimaryKey(Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int insertSelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    List<Group> selectByExample(GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    Group selectByPrimaryKey(Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int updateByPrimaryKeySelective(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated Sun May 19 22:07:46 CST 2019
     */
    int updateByPrimaryKey(Group record);

    int selectMaxGroupId();
}