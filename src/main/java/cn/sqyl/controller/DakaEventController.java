package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.DakaEventService;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DakaEventModel;
import cn.sqyl.service.model.DayEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dakaevent")
public class DakaEventController {
    @Autowired
    private DakaEventService dakaEventService;

    @RequestMapping("/getDakaEventById")
    public Result getDakaEventModelById(@RequestBody DakaEventModel dakaEventModel) {
        dakaEventModel = dakaEventService.getDakaEventById(dakaEventModel);
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        if(dakaEventModel == null) {
            result.setMsg("用户不存在！");
            result.setDetail(null);
        } else {
            result.setSuccess(true);
            result.setMsg("查询到用户");
            result.setDetail(dakaEventModel);
        }
        //返回结果
        return result;
    }

    @PostMapping(value = "/getDakaEventByUserId")
    public Result getClassEventByUserId(@RequestBody DakaEventModel dakaEventModel) {

        return dakaEventService.getDakaEventByUserId(dakaEventModel);
    }

    @PostMapping(value = "/insertDakaEvent")
    public Result insertDakaEvent(@RequestBody DakaEventModel dakaEventModel) {
        return dakaEventService.insertDakaEvent(dakaEventModel);
    }

    @PostMapping(value = "/updateDakaEvent")
    public Result updateDayEvent(@RequestBody DakaEventModel dakaEventModel) {
        return dakaEventService.updateDakaEventById(dakaEventModel);
    }

    @PostMapping(value = "/deleteDakaEvent")
    public Result deleteDayEvent(@RequestBody DakaEventModel dakaEventModel) {
        return dakaEventService.deleteDakaEventById(dakaEventModel);
    }
}
