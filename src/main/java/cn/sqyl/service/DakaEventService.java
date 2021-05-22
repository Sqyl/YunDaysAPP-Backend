package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DakaEventModel;

public interface DakaEventService {

    DakaEventModel getDakaEventById(DakaEventModel dakaEventModel);
    Result getDakaEventByUserId(DakaEventModel dakaEventModel);
    Result insertDakaEvent(DakaEventModel dakaEventModel);
    Result updateDakaEventById(DakaEventModel dakaEventModel);
    Result deleteDakaEventById(DakaEventModel dakaEventModel);
}
