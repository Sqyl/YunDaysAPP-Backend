package cn.sqyl.service.model;

public class FriendModel {

    private Integer id;
    private Integer belong_UserId;
    private Integer friendId;

    public FriendModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBelong_UserId() {
        return belong_UserId;
    }

    public void setBelong_UserId(Integer belong_UserId) {
        this.belong_UserId = belong_UserId;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
}
