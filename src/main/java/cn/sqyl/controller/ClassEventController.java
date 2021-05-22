package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.ClassEventService;
import cn.sqyl.service.model.ClassEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classevent")
public class ClassEventController {

    @Autowired
    private ClassEventService classEventService;

    @PostMapping("/getClassEventById")
    public Result getClassEventById(@RequestBody ClassEventModel classEventModel) {
        classEventModel = classEventService.getClassEventById(classEventModel);
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        if(classEventModel == null) {
            result.setMsg("课程不存在！");
            result.setDetail(null);
        } else {
            result.setSuccess(true);
            result.setMsg("查询到课程");
            result.setDetail(classEventModel);
        }
        //返回结果
        return result;
    }

    @PostMapping(value = "/getClassEventByUserId")
    public Result getClassEventByUserId(@RequestBody ClassEventModel classEventModel) {

        return classEventService.getClassEventByUserId(classEventModel);
    }
    @PostMapping(value = "/insertClassEvent")
    public Result insertClassEvent(@RequestBody ClassEventModel classEventModel) {
        return classEventService.insertClassEvent(classEventModel);
    }

    @PostMapping(value = "/updateClassEvent")
    public Result updateClassEvent(@RequestBody ClassEventModel classEventModel) {
        return classEventService.updateClassEventById(classEventModel);
    }

    @PostMapping(value = "/deleteClassEvent")
    public Result deleteClassyEvent(@RequestBody ClassEventModel classEventModel) {
        return classEventService.deleteClassEventById(classEventModel);
    }
}
