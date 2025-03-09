package com.model;

import java.util.ArrayList;

public class User{
    private String password;
    private String username;
    public String name;
    public int amountLeft;
    private ArrayList<Action> actions;

    public User(String password, String username, String name, int amountLeft) {
        this.password = password;
        this.username = username;
        this.name = name;
        actions = new ArrayList<>();
        this.amountLeft = amountLeft;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String name() {
        return name;
    }
}
