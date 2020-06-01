package com.aw.bracelet.service;

import com.aw.bracelet.model.UserDevice;

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
//    List<UserDevice> selectBySnSet(Long userId, String[] ids);
}
