package com.example.groupmanagement.listener;


import com.example.groupmanagement.model.Account;
import com.example.groupmanagement.model.Room;

import java.util.ArrayList;

public interface LoginListener {
    void getDataSuccess(Account account, ArrayList<Room>rooms);
    void getMessageError(Exception e);
}