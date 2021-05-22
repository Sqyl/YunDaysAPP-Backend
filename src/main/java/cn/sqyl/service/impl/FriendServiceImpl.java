package cn.sqyl.service.impl;

import cn.sqyl.dao.friendsMapper;
import cn.sqyl.dataobject.dayevent;
import cn.sqyl.dataobject.friends;
import cn.sqyl.response.Result;
import cn.sqyl.service.FriendService;
import cn.sqyl.service.model.FriendModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private friendsMapper friendsMapper;

    @Override
    public Result getFriendsByUserId(FriendModel friendModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(null);
        List<friends> friends = friendsMapper.selectByUserId(friendModel.getBelong_UserId());
        if(friends.size() == 0) {
            result.setMsg("未查询到好友");
            result.setDetail(null);
        } else {
            List<FriendModel> friendModels = new ArrayList<>();
            for(friends friend: friends) {
                FriendModel friendModel1 = new FriendModel();
                friendModel1.setId(friend.getId());
                friendModel1.setBelong_UserId(friend.getBelongUserid());
                friendModel1.setFriendId(friend.getFriendid());
                friendModels.add(friendModel1);
                result.setSuccess(true);
                result.setMsg("查询到好友");
                result.setDetail(friendModels);
            }
        }
        return result;
    }

    @Override
    public Result insertFriend(FriendModel friendModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            friends friend = new friends();
            friend.setBelongUserid(friendModel.getBelong_UserId());
            friend.setFriendid(friendModel.getFriendId());
            friendsMapper.insertSelective(friend);
            result.setMsg("添加成功");
            result.setSuccess(true);

        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
