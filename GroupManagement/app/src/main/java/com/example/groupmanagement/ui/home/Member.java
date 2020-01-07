package com.example.groupmanagement.ui.home;

public class Member {
    int id;
    String avatar;
    String Name;
    int Speed;
    String chat;
    float VDo;
    float KDp;

    public Member(int id, String avatar, String name, int speed, String chat, float VDo, float KDp) {
        this.id = id;
        this.avatar = avatar;
        Name = name;
        Speed = speed;
        this.chat = chat;
        this.VDo = VDo;
        this.KDp = KDp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public float getVDo() {
        return VDo;
    }

    public void setVDo(float VDo) {
        this.VDo = VDo;
    }

    public float getKDp() {
        return KDp;
    }

    public void setKDp(float KDp) {
        this.KDp = KDp;
    }
}
