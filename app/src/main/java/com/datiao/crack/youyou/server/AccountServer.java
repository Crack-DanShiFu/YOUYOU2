package com.datiao.crack.youyou.server;

import com.datiao.crack.youyou.model.User;

/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 14:16
 * description:
 */
public class AccountServer {
    public Boolean loginvalidation(User user){
        if(user.getUserAccount().equals("1124241615")&&user.getUserAccountPwd().equals("123456")){
            return true;
        }
        return false;

    }
}
