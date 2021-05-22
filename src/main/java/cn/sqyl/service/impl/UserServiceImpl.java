package cn.sqyl.service.impl;

import cn.sqyl.dao.user_passwordMapper;
import cn.sqyl.dao.userclassMapper;
import cn.sqyl.response.Result;
import cn.sqyl.dataobject.user_password;
import cn.sqyl.dataobject.userclass;
import cn.sqyl.service.UserService;
import cn.sqyl.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private userclassMapper mUserClassMapper;
    @Autowired
    private user_passwordMapper userPasswordMapper;

    @Override
    public Result getFriendById(UserModel userModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        userclass user = mUserClassMapper.selectByPrimaryKey(userModel.getUserID());
        if(user == null) {
            result.setMsg("未查询到用户");
        } else {
            UserModel userModel1 = new UserModel();
            userModel1.setUserID(user.getUserid());
            userModel1.setUserName(user.getUsername());
            result.setMsg("查询到用户");
            result.setSuccess(true);
            result.setDetail(userModel1);
        }
        return result;
    }

    @Override
    public UserModel getUserById(Integer id) {
        //调用userclassMapper获取到对应用户dataobject
        userclass user = mUserClassMapper.selectByPrimaryKey(id);
        if(user == null) {
            return null;
        }
        //通过用户ID获取对应的用户密码信息
        user_password userPassword = userPasswordMapper.selectByUserId(user.getUserid());
        if(userPassword == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setUserID(user.getUserid());
        userModel.setUserAccount(user.getUseraccount());
        userModel.setUserName(user.getUsername());
        userModel.setUserPassword(userPassword.getUserPassword());
        return userModel;
    }


    @Override
    public UserModel getUserByAccount(String account) {
        userclass user = mUserClassMapper.selectByUserAccount(account);
        if(user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setUserID(user.getUserid());
        userModel.setUserAccount(user.getUseraccount());
        userModel.setUserName(user.getUsername());
        return userModel;
    }

    @Override
    public Result register(UserModel userModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            UserModel userByAccount = getUserByAccount(userModel.getUserAccount());
            if(userByAccount != null) {
                result.setMsg("用户名已存在");
            } else {
                userclass user = new userclass();
                user.setUseraccount(userModel.getUserAccount());
                user.setUsername(userModel.getUserName());
                mUserClassMapper.insertSelective(user);

                user = mUserClassMapper.selectByUserAccount(user.getUseraccount());

                user_password userPassword = new user_password();
                userPassword.setUserId(user.getUserid());
                userPassword.setUserPassword(userModel.getUserPassword());
                userPasswordMapper.insertSelective(userPassword);
                result.setMsg("注册成功");
                result.setSuccess(true);

                UserModel userModel_detail = getUserById(user.getUserid());
                result.setDetail(userModel_detail);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;


    }

    @Override
    public Result login(UserModel userModel) {
        Result result = new Result();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            userclass user = mUserClassMapper.selectByUserAccount(userModel.getUserAccount());
            user_password userPassword = userPasswordMapper.selectByUserId(user.getUserid());
            if(userModel.getUserPassword().equals(userPassword.getUserPassword())) {
                result.setSuccess(true);
                result.setMsg("登录成功");
                UserModel userModel_detail = getUserById(user.getUserid());
                result.setDetail(userModel_detail);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}
