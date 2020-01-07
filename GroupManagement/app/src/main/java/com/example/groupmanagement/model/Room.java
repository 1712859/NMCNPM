package com.example.groupmanagement.model;

public class Room {
    String name;
    int idroom;

    public Room(String s) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

    public Room(String name, int idroom) {
        this.name = name;
        this.idroom = idroom;
    }
}
