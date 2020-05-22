package com.aw.braceletserver.service;

import com.aw.braceletserver.entity.Group;

import java.util.List;

public interface GroupManagerService {

    List<Group> selectUserGroupListByUserId(int userId);

    Group insertGroup(Group group);

    Group selectGroupByGroupId(int groupId);
}
