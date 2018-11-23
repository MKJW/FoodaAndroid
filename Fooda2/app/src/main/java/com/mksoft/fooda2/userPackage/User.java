package com.mksoft.fooda2.userPackage;

public class User {
    String Id;
    String name;
    String stateMsg;
    //사진
    //..

    public User(String id, String name, String stateMsg) {
        this.Id = id;
        this.name = name;
        this.stateMsg = stateMsg;
    }



    @Override
    public String toString() {
        return "User{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                ", stateMsg='" + stateMsg + '\'' +
                '}';
    }
}
