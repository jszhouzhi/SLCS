package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.GuestMessageReplayDao;
import com.slzr.operation.domain.GuestMessageReplayDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GuestMessageReplayServiceImpl implements com.slzr.operation.service.GuestMessageReplayService {

    @Autowired
    GuestMessageReplayDao guestMessageReplayDao;

    //  获取
    public GuestMessageReplayDo getByID(int id) {
       return guestMessageReplayDao.getByID(id);
    }

    // 保存
    public int save(GuestMessageReplayDo guestMessageReplayDo){
        return guestMessageReplayDao.save(guestMessageReplayDo);
    }

    // 更新
    public int update(GuestMessageReplayDo guestMessageReplayDo){
        return guestMessageReplayDao.update(guestMessageReplayDo);
    }

}
