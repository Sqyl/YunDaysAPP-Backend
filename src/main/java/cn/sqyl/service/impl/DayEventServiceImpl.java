package cn.sqyl.service.impl;

import cn.sqyl.dao.dayeventMapper;
import cn.sqyl.dataobject.dayevent;
import cn.sqyl.dataobject.user_password;
import cn.sqyl.dataobject.userclass;
import cn.sqyl.response.Result;
import cn.sqyl.service.DayEventService;
import cn.sqyl.service.model.DayEventModel;
import cn.sqyl.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayEventServiceImpl implements DayEventService {

    @Autowired
    private dayeventMapper dayeventMapper;

    @Override
    public DayEventModel getDayEventById(DayEventModel dayEventModel) {
        dayevent dayevent = dayeventMapper.selectByPrimaryKey(dayEventModel.get_id());
        if(dayevent == null) {
            return null;
        }
        dayEventModel.set_id(dayevent.getId());
        dayEventModel.setBelong_userID(dayevent.getBelongUserid());
        dayEventModel.setName(dayevent.getName());
        dayEventModel.setDate(dayevent.getDate());
        dayEventModel.setTime(dayevent.getTime());
        return dayEventModel;
    }

    @Override
    public Result getDayEventByUserId(DayEventModel dayEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<dayevent> dayevents = dayeventMapper.selectByUserId(dayEventModel.getBelong_userID());
        if(dayevents.size() == 0) {
            result.setMsg("未查询到日程");
        }
        List<DayEventModel> dayEventModels = new ArrayList<>();
        for(dayevent dayevent : dayevents) {
            DayEventModel dayEventModel1 = new DayEventModel();
            dayEventModel1.set_id(dayevent.getId());
            dayEventModel1.setName(dayevent.getName());
            dayEventModel1.setBelong_userID(dayevent.getBelongUserid());
            dayEventModel1.setDate(dayevent.getDate());
            dayEventModel1.setTime(dayevent.getTime());
            dayEventModels.add(dayEventModel1);
            result.setMsg("查询到日程");
            result.setSuccess(true);
            result.setDetail(dayEventModels);
        }
        return result;
    }

    @Override
    public Result insertDayEvent(DayEventModel dayEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            dayevent dayevent = new dayevent();
            dayevent.setBelongUserid(dayEventModel.getBelong_userID());
            dayevent.setName(dayEventModel.getName());
            dayevent.setDate(dayEventModel.getDate());
            dayevent.setTime(dayEventModel.getTime());
            dayeventMapper.insertSelective(dayevent);
            result.setMsg("添加成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateDayEventById(DayEventModel dayEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            dayevent dayevent = new dayevent();
            dayevent.setId(dayEventModel.get_id());
            dayevent.setBelongUserid(dayEventModel.getBelong_userID());
            dayevent.setName(dayEventModel.getName());
            dayevent.setDate(dayEventModel.getDate());
            dayevent.setTime(dayEventModel.getTime());
            dayeventMapper.updateByPrimaryKeySelective(dayevent);
            result.setMsg("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteDayEventById(DayEventModel dayEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if(dayeventMapper.selectByPrimaryKey(dayEventModel.get_id()) == null) {
                result.setMsg("未找到日程");
            } else {
                dayeventMapper.deleteByPrimaryKey(dayEventModel.get_id());
                result.setMsg("删除成功");
                result.setSuccess(true);}
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
