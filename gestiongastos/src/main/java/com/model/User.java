package com.model;

import java.util.ArrayList;

public class User{
    private String password;
    private String username; //this field is permanent
    public String name;
    private int amountLeft;
    private ArrayList<Action> actions;

    public User(String password, String username, String name, int amountLeft) {
        this.password = password;
        this.username = username;
        this.name = name;
        actions = new ArrayList<>();
        this.amountLeft = amountLeft;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(int amountLeft) {
        this.amountLeft = amountLeft;
    }

    public void addAction(Action action) {
        try {
            if(action.getAmountMoved() > amountLeft){
                throw new Exception("AmountMoved is greater than amountLeft");
            }else{
                amountLeft -= action.getAmountMoved();
                actions.add(action);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "User [password=" + password + ", username=" + username + ", name=" + name + ", amountLeft=" + amountLeft
                + ", actions=" + actions + "]";
    }
}
