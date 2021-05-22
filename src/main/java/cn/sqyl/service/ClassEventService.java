package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DayEventModel;

public interface ClassEventService {

    ClassEventModel getClassEventById(ClassEventModel classEventModel);
    Result getClassEventByUserId(ClassEventModel classEventModel);
    Result insertClassEvent(ClassEventModel classEventModel);
    Result updateClassEventById(ClassEventModel classEventModel);
    Result deleteClassEventById(ClassEventModel classEventModel);
}
