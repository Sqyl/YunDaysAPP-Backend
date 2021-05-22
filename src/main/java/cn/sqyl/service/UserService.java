package cn.sqyl.service;

import cn.sqyl.response.Result;
import cn.sqyl.service.model.UserModel;

public interface UserService {
    //通过用户ID获取用户对象
    Result getFriendById(UserModel userModel);
    UserModel getUserById(Integer id);
    UserModel getUserByAccount(String account);
    Result register(UserModel userModel);
    Result login(UserModel userModel);
}
