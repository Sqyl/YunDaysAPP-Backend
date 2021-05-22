package cn.sqyl.service.model;

/**
 * Designed by Sqyl NZ171王畅
 * extends:
 *    protected String name;
 *    protected int belong_UserID;
 *     and their get/set.
 */
public class DayEventModel extends EventModel{
    //日期
    private String date;
    //具体时间
    private String time;

    public DayEventModel() {}

    public String getDate() { return date; }
    public String getTime() { return time; }

    public void setTime(String time) {
        this.time = time;
    }
    public void setDate(String date) { this.date = date; }
}
