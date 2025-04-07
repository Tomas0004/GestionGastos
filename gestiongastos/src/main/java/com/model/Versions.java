package com.model;

import java.util.ArrayList;

public class Versions {
    private static ArrayList<ArrayList<User>> versionsUsers = new ArrayList<>();

    public Versions(){}

    public static ArrayList<ArrayList<User>> getVersions(){
        return versionsUsers;
    }

    public static void addVersionsUser(ArrayList<User> versions){
        versionsUsers.add(versions);
    }

    public static ArrayList<User> findVersionsUser(String username){
        try {
            return versionsUsers.stream().filter(versions -> versions.getFirst().getUsername().equals(username)).findFirst().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean addVersionToUser(User version, String username){
        if(findVersionsUser(username) == null){
            return false;
        }else{
            versionsUsers.get(versionsUsers.indexOf(findVersionsUser(username))).add(version);
            return true;
        }

    }
}
