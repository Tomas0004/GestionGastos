package com.model;

import java.util.ArrayList;

public class Versions {
    private static ArrayList<ArrayList<User>> versionsUsers = new ArrayList<>();

    public Versions(){}

    public static ArrayList<ArrayList<User>> getVersions(){
        return versionsUsers;
    }

    public static void addVersionsToUser(ArrayList<User> versions){
        versionsUsers.add(versions);
    }
}
