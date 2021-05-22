package cn.sqyl.service.impl;

import cn.sqyl.dao.daka_msgMapper;
import cn.sqyl.dataobject.daka_msg;
import cn.sqyl.dataobject.daka_msgKey;
import cn.sqyl.dataobject.dakaevent;
import cn.sqyl.response.Result;
import cn.sqyl.service.DakaMsgService;
import cn.sqyl.service.model.DakaMsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DakaMsgServiceImpl implements DakaMsgService {

    @Autowired
    private daka_msgMapper dakaMsgMapper;
    @Override
    public Result getDakaMsgByDakaId(DakaMsgModel dakaMsgModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        List<daka_msg> dakaMsg = dakaMsgMapper.selectByDakaId(dakaMsgModel.getBelong_dakaID());
        if(dakaMsg.size() == 0) {
            result.setMsg("未查询到信息");
        } else {
            List<DakaMsgModel> dakaMsgModels = new ArrayList<>();
            for(daka_msg daka_msg: dakaMsg) {
                DakaMsgModel dakaMsgModel1 = new DakaMsgModel();
                dakaMsgModel1.setDate(daka_msg.getDate());
                dakaMsgModel1.setBelong_dakaID(daka_msg.getBelongDakaid());
                dakaMsgModel1.setTime(daka_msg.getTime());
                dakaMsgModel1.setComment(daka_msg.getComment());
                dakaMsgModels.add(dakaMsgModel1);
                result.setMsg("查询到打卡记录");
                result.setSuccess(true);
                result.setDetail(dakaMsgModels);
            }
        }
        return result;
    }

    @Override
    public Result insertDakaMsg(DakaMsgModel dakaMsgModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            daka_msg dakaMsg = new daka_msg();
            dakaMsg.setDate(dakaMsgModel.getDate());
            dakaMsg.setTime(dakaMsgModel.getTime());
            dakaMsg.setBelongDakaid(dakaMsgModel.getBelong_dakaID());
            dakaMsg.setComment(dakaMsgModel.getComment());
            dakaMsgMapper.insertSelective(dakaMsg);
            result.setMsg("添加成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
