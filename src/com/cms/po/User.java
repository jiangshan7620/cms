package com.cms.po;

/**
 * @author: Mr.shan
 * @date: 2022/8/3 8:29
 * @bz:
 */

public class User {
    private int id;
    private int depID;
    private String userName;
    private String userPwd;
    private String userCode;
    private String userSex;
    private int userAge;
    private int userPower;

    public User() {
    }

    public User(int id, int depID, String userName, String userPwd, String userCode, String userSex, int userAge, int userPower) {
        this.id = id;
        this.depID = depID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userCode = userCode;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userPower = userPower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepID() {
        return depID;
    }

    public void setDepID(int depID) {
        this.depID = depID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserPower() {
        return userPower;
    }

    public void setUserPower(int userPower) {
        this.userPower = userPower;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", depID=" + depID +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userPower='" + userPower + '\'' +
                '}';
    }
}
