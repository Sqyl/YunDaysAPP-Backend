package cn.sqyl.controller;

import cn.sqyl.response.Result;
import cn.sqyl.service.FriendService;
import cn.sqyl.service.model.FriendModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendService friendService;

    @PostMapping("/getFriendsByUserId")
    public Result getFriendsByUserId(@RequestBody FriendModel friendModel) {
        System.out.println(friendModel.getBelong_UserId());
        return friendService.getFriendsByUserId(friendModel);

    }

    @PostMapping("/insertFriend")
    public Result insertFriend(@RequestBody FriendModel friendModel) {
        return friendService.insertFriend(friendModel);
    }

}
