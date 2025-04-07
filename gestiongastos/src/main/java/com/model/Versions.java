package com.model;

import java.util.ArrayList;

public class Versions {
    private static ArrayList<ArrayList<User>> versionsUsers = new ArrayList<>();

    public Versions(){}

    public static ArrayList<ArrayList<User>> getVersions(){
        return versionsUsers;
    }

    public static void setVersions(ArrayList<ArrayList<User>> versions){
        versionsUsers = versions;
    }

    public static boolean addVersionsUser(ArrayList<User> versions){
        if(findVersionsUser(versions.get(0).getUsername()) == null){
            versionsUsers.add(versions);
            return true;
        }else{
            return false;
        }
    }

    public static ArrayList<User> findVersionsUser(String username){
        for(ArrayList<User> user : versionsUsers){
            try {
                if(user.get(0).getUsername().equals(username)){
                    return user;
                }
            } catch (IndexOutOfBoundsException e) {}
        }

        return null;
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
