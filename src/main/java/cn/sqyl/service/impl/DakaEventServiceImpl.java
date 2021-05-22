package cn.sqyl.service.impl;

import cn.sqyl.dao.dakaeventMapper;
import cn.sqyl.dataobject.classevent;
import cn.sqyl.dataobject.dakaevent;
import cn.sqyl.dataobject.dayevent;
import cn.sqyl.response.Result;
import cn.sqyl.service.DakaEventService;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DakaEventModel;
import cn.sqyl.service.model.DayEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DakaEventServiceImpl implements DakaEventService {

    @Autowired
    private dakaeventMapper dakaeventMapper;

    @Override
    public DakaEventModel getDakaEventById(DakaEventModel dakaEventModel) {
        dakaevent dakaevent = dakaeventMapper.selectByPrimaryKey(dakaEventModel.get_id());
        if(dakaevent == null) {
            return null;
        }
        dakaEventModel.set_id(dakaevent.getId());
        dakaEventModel.setType(dakaevent.getType());
        dakaEventModel.setName(dakaevent.getName());
        dakaEventModel.setLast_days(dakaevent.getLastDays());
        dakaEventModel.setDaka_days(dakaevent.getDakaDays());

        return dakaEventModel;
    }

    @Override
    public Result getDakaEventByUserId(DakaEventModel dakaEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<dakaevent> dakaevents = dakaeventMapper.selectByUserId(dakaEventModel.getBelong_userID());
        if(dakaevents.size() == 0) {
            result.setMsg("未查询到打卡项");
        }
        List<DakaEventModel> dakaEventModels = new ArrayList<>();
        for(dakaevent dakaevent : dakaevents) {
            DakaEventModel dakaEventModel1 = new DakaEventModel();

            dakaEventModel1.set_id(dakaevent.getId());
            dakaEventModel1.setName(dakaevent.getName());
            dakaEventModel1.setType(dakaevent.getType());
            dakaEventModel1.setBelong_userID(dakaevent.getBelongUserid());
            dakaEventModel1.setDaka_days(dakaevent.getDakaDays());
            dakaEventModel1.setLast_days(dakaevent.getLastDays());

            dakaEventModels.add(dakaEventModel1);
            result.setMsg("查询到打卡项");
            result.setSuccess(true);
            result.setDetail(dakaEventModels);
        }
        return result;
    }

    @Override
    public Result insertDakaEvent(DakaEventModel dakaEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            dakaevent dakaevent = new dakaevent();
            dakaevent.setName(dakaEventModel.getName());
            dakaevent.setType(dakaEventModel.getType());
            dakaevent.setBelongUserid(dakaEventModel.getBelong_userID());
            dakaevent.setDakaDays(dakaEventModel.getDaka_days());
            dakaevent.setLastDays(dakaEventModel.getLast_days());
            dakaeventMapper.insertSelective(dakaevent);
            result.setMsg("添加成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateDakaEventById(DakaEventModel dakaEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            dakaevent dakaevent = new dakaevent();
            dakaevent.setId(dakaEventModel.get_id());
            dakaevent.setName(dakaEventModel.getName());
            dakaevent.setType(dakaEventModel.getType());
            dakaevent.setBelongUserid(dakaEventModel.getBelong_userID());
            dakaevent.setDakaDays(dakaEventModel.getDaka_days());
            dakaevent.setLastDays(dakaEventModel.getLast_days());

            dakaeventMapper.updateByPrimaryKeySelective(dakaevent);
            result.setMsg("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteDakaEventById(DakaEventModel dakaEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if(dakaeventMapper.selectByPrimaryKey(dakaEventModel.get_id()) == null) {
                result.setMsg("未找到打卡项");
            } else {
                dakaeventMapper.deleteByPrimaryKey(dakaEventModel.get_id());
                result.setMsg("删除成功");
                result.setSuccess(true);}
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
