package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.DakaMsgService;
import cn.sqyl.service.model.DakaMsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dakamsg")
public class DakaMsgController {
    @Autowired
    private DakaMsgService dakaMsgService;

    @PostMapping("/getDakaMsgByDakaId")
    public Result getDakaMsgByDakaId(@RequestBody DakaMsgModel dakaMsgModel) {
        return dakaMsgService.getDakaMsgByDakaId(dakaMsgModel);
    }

    @PostMapping("/insertDakaMsg")
    public Result insertDakaMsg(@RequestBody DakaMsgModel dakaMsgModel) {
        return dakaMsgService.insertDakaMsg(dakaMsgModel);
    }

}
