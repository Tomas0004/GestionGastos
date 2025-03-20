package com.model;

import java.util.ArrayList;

public class Versions {
    private ArrayList<User> versions = new ArrayList<>();

    public Versions(){}

    public ArrayList<User> getVersions(){
        return versions;
    }

    public void setVersions(ArrayList<User> versions){
        this.versions = versions;
    }

    @Override
    public String toString() {
        return "Versions [versions=" + versions + "]";
    }
}
