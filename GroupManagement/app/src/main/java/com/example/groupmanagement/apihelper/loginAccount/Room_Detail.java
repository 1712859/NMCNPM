package com.example.groupmanagement.apihelper.loginAccount;

public class Room_Detail {
    String name;
    String id;
    member members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public member getMembers() {
        return members;
    }

    public void setMembers(member members) {
        this.members = members;
    }
}
