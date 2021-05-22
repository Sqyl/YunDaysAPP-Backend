package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.DayEventModel;

import java.util.List;

public interface DayEventService {

    DayEventModel getDayEventById(DayEventModel dayEventModel);
    Result getDayEventByUserId(DayEventModel dayEventModel);
    Result insertDayEvent(DayEventModel dayEventModel);
    Result updateDayEventById(DayEventModel dayEventModel);
    Result deleteDayEventById(DayEventModel dayEventModel);
}
