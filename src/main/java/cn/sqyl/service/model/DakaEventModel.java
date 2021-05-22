package cn.sqyl.service.model;

import java.util.ArrayList;
import java.util.List;

public class DakaEventModel extends EventModel{
    //持续时间
    private int last_days;
    private String type;
    private String daka_days;

    public DakaEventModel() {}

    public int getLast_days() {
        return last_days;
    }

    public void setLast_days(int last_days) {
        this.last_days = last_days;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDaka_days() {
        return daka_days;
    }

    public void setDaka_days(String daka_days) {
        this.daka_days = daka_days;
    }
}
