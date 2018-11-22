package com.datiao.crack.youyou.model;

/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 11:54
 * description:
 */
public class User {
    private String userAccount;
    private String userAccountPwd;

    public User() {
    }

    public User(String userAccount, String userAccountPwd) {
        this.userAccount = userAccount;
        this.userAccountPwd = userAccountPwd;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserAccountPwd() {
        return userAccountPwd;
    }

    public void setUserAccountPwd(String userAccountPwd) {
        this.userAccountPwd = userAccountPwd;
    }
}
