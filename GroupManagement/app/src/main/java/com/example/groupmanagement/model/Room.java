package com.example.groupmanagement.model;

public class Room {
    String name;
    String idroom;

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, String idroom) {
        this.name = name;
        this.idroom = idroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdroom() {
        return idroom;
    }

    public void setIdroom(String idroom) {
        this.idroom = idroom;
    }
}
