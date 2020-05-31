package com.aw.braceletserver.service;

import com.aw.braceletserver.model.UserDevice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDeviceService {
    /**
     * 插入用户设备关系
     *
     * @param entity
     * @return
     */
    int insert(UserDevice entity);

    /**
     * 依据用户和设备ID列表查询
     *
     * @param userId
     * @param ids
     * @return
     */
    List<UserDevice> selectByIdSet(Long userId, Long[] ids);
}
