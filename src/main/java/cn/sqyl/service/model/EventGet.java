package cn.sqyl.service.model;

public interface EventGet {
    void setName(String name);

    void setBelong_userID(int belong_userID);
    void set_id(int _id);

    String getName();

    int getBelong_userID();
    int get_id();
}
