package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DakaMsgModel;

public interface DakaMsgService {
    Result getDakaMsgByDakaId(DakaMsgModel dakaMsgModel);
    Result insertDakaMsg(DakaMsgModel dakaMsgModel);
}
