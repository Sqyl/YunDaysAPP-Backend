package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.FriendModel;

public interface FriendService {

    Result getFriendsByUserId(FriendModel friendModel);

    Result insertFriend(FriendModel friendModel);
}
