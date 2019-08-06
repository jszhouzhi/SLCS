package com.slzr.operation.dao;

import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.GuestMessageReplayDo;

public interface GuestMessageReplayDao {

    //  获取
    GuestMessageReplayDo getByID(int id);

    // 保存
    int save(GuestMessageReplayDo guestMessageReplayDo);

    // 更新
    int update(GuestMessageReplayDo guestMessageReplayDo);

}
