package cn.sqyl.service.model;

public class DakaMsgModel {
    private String date;
    private String time;
    private Integer belong_dakaID;
    private String comment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBelong_dakaID() {
        return belong_dakaID;
    }

    public void setBelong_dakaID(Integer belong_dakaID) {
        this.belong_dakaID = belong_dakaID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
