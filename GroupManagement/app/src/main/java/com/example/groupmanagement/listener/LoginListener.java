package com.example.groupmanagement.listener;


import com.example.groupmanagement.model.Account;

public interface LoginListener {
    void getDataSuccess(Account account);
    void getMessageError(Exception e);
}