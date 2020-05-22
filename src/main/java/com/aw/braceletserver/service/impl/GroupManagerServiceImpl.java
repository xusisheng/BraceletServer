package com.aw.braceletserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.aw.braceletserver.mapper.GroupMapper;
import com.aw.braceletserver.entity.Group;
import com.aw.braceletserver.entity.GroupExample;
import com.aw.braceletserver.service.GroupManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupManagerServiceImpl implements GroupManagerService {

    private Logger logger = LoggerFactory.getLogger(GroupManagerServiceImpl.class);

    @Resource
    GroupMapper groupMapper;

    @Override
    public List<Group> selectUserGroupListByUserId(int userId) {
        logger.info("userId = {}", userId);
        GroupExample example = new GroupExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return groupMapper.selectByExample(example);
    }

    @Override
    public Group insertGroup(Group group) {
        logger.info("group = {}", JSON.toJSONString(group));
        Integer maxId = groupMapper.selectMaxGroupId();
        int groupId = (maxId == null)? 1: maxId + 1;
        group.setGroupId(groupId);
        int count = groupMapper.insertSelective(group);
        if(count > 0){
            return groupMapper.selectByPrimaryKey(groupId);
        }
        return null;
    }

    @Override
    public Group selectGroupByGroupId(int groupId) {
        logger.info("groupId = {}", groupId);
        return groupMapper.selectByPrimaryKey(groupId);
    }
}
