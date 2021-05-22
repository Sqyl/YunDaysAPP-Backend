package cn.sqyl.service.impl;

import cn.sqyl.dao.classeventMapper;
import cn.sqyl.dataobject.classevent;
import cn.sqyl.dataobject.dayevent;
import cn.sqyl.response.Result;
import cn.sqyl.service.ClassEventService;
import cn.sqyl.service.model.ClassEventModel;
import cn.sqyl.service.model.DayEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassEventServiceImpl implements ClassEventService {

    @Autowired
    private classeventMapper classeventMapper;


    @Override
    public ClassEventModel getClassEventById(ClassEventModel classEventModel) {
        classevent classevent = classeventMapper.selectByPrimaryKey(classEventModel.get_id());
        if(classevent == null) {
            return null;
        }
        classEventModel.set_id(classevent.getId());
        classEventModel.setBelong_userID(classevent.getBelongUserid());
        classEventModel.setName(classevent.getName());
        classEventModel.setClass_date(classevent.getClassDate());
        classEventModel.setClass_teacher(classevent.getTeacher());
        classEventModel.setClassRoom(classevent.getClassroom());
        classEventModel.setBegin_class(classevent.getBeginClass());
        classEventModel.setEnd_class(classevent.getEndClass());
        return classEventModel;
    }

    @Override
    public Result getClassEventByUserId(ClassEventModel classEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<classevent> classevents = classeventMapper.selectByUserId(classEventModel.getBelong_userID());
        if(classevents.size() == 0) {
            result.setMsg("未查询到日程");
        }
        List<ClassEventModel> classEventModels = new ArrayList<>();
        for(classevent classevent : classevents) {
            ClassEventModel classEventModel1 = new ClassEventModel();

            classEventModel1.set_id(classevent.getId());
            classEventModel1.setName(classevent.getName());
            classEventModel1.setBelong_userID(classevent.getBelongUserid());
            classEventModel1.setClass_teacher(classevent.getTeacher());
            classEventModel1.setClassRoom(classevent.getClassroom());
            classEventModel1.setClass_date(classevent.getClassDate());
            classEventModel1.setBegin_class(classevent.getBeginClass());
            classEventModel1.setEnd_class(classevent.getEndClass());

            classEventModels.add(classEventModel1);
            result.setMsg("查询到课程");
            result.setSuccess(true);
            result.setDetail(classEventModels);
        }
        return result;
    }

    @Override
    public Result insertClassEvent(ClassEventModel classEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            classevent classevent = new classevent();
            classevent.setBelongUserid(classEventModel.getBelong_userID());
            classevent.setName(classEventModel.getName());
            classevent.setTeacher(classEventModel.getClass_teacher());
            classevent.setClassroom(classEventModel.getClassRoom());
            classevent.setBeginClass(classEventModel.getBegin_class());
            classevent.setEndClass(classEventModel.getEnd_class());
            classevent.setClassDate(classEventModel.getClass_date());
            classeventMapper.insertSelective(classevent);
            result.setMsg("添加成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result updateClassEventById(ClassEventModel classEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            classevent classevent = new classevent();

            classevent.setId(classEventModel.get_id());
            classevent.setBelongUserid(classEventModel.getBelong_userID());
            classevent.setName(classEventModel.getName());
            classevent.setTeacher(classEventModel.getClass_teacher());
            classevent.setClassroom(classEventModel.getClassRoom());
            classevent.setBeginClass(classEventModel.getBegin_class());
            classevent.setEndClass(classEventModel.getEnd_class());
            classevent.setClassDate(classEventModel.getClass_date());

            classeventMapper.updateByPrimaryKeySelective(classevent);
            result.setMsg("修改成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Result deleteClassEventById(ClassEventModel classEventModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            if(classeventMapper.selectByPrimaryKey(classEventModel.get_id()) == null) {
                result.setMsg("未找到课程");
            } else {
                classeventMapper.deleteByPrimaryKey(classEventModel.get_id());
                result.setMsg("删除成功");
                result.setSuccess(true);}
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
