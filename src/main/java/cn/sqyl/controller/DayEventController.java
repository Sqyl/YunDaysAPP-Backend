package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.DayEventService;
import cn.sqyl.service.model.DayEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dayevent")
public class DayEventController{

    @Autowired
    private DayEventService dayEventService;

    @PostMapping("/getDayEventById")
    public Result getDayEventById(@RequestBody DayEventModel dayEventModel) {
        dayEventModel = dayEventService.getDayEventById(dayEventModel);
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        if(dayEventModel == null) {
            result.setMsg("日程不存在！");
            result.setDetail(null);
        } else {
            result.setSuccess(true);
            result.setMsg("查询到日程");
            result.setDetail(dayEventModel);
        }
        //返回结果
        return result;
    }

    @PostMapping(value = "/getDayEventByUserId")
    public Result getDayEventByUserId(@RequestBody DayEventModel dayEventModel) {

        return dayEventService.getDayEventByUserId(dayEventModel);
    }

    @PostMapping(value = "/insertDayEvent")
    public Result insertDayEvent(@RequestBody DayEventModel dayEventModel) {
        return dayEventService.insertDayEvent(dayEventModel);
    }

    @PostMapping(value = "/updateDayEvent")
    public Result updateDayEvent(@RequestBody DayEventModel dayEventModel) {
        return dayEventService.updateDayEventById(dayEventModel);
    }

    @PostMapping(value = "/deleteDayEvent")
    public Result deleteDayEvent(@RequestBody DayEventModel dayEventModel) {
        return dayEventService.deleteDayEventById(dayEventModel);
    }
}
