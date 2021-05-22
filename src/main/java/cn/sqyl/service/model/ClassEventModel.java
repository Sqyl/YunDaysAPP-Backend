package cn.sqyl.service.model;

public class ClassEventModel extends EventModel{
    //课程在每周的周几
    private int class_date;
    //授课老师
    private String class_teacher;
    //教室
    private String classRoom;
    //从第几节课开始
    private int begin_class;
    //到第几节课结束
    private int end_class;

    public ClassEventModel() {}

    public int getClass_date() {
        return class_date;
    }

    public void setClass_date(int class_date) {
        this.class_date = class_date;
    }

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getBegin_class() {
        return begin_class;
    }

    public void setBegin_class(int begin_class) {
        this.begin_class = begin_class;
    }

    public int getEnd_class() {
        return end_class;
    }

    public void setEnd_class(int end_class) {
        this.end_class = end_class;
    }
}
