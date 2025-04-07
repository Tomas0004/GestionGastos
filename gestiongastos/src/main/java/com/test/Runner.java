package com.test;

import com.view.PrimaryStage;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.model.Constants;
import com.model.IOHandler;
import com.model.JSONHandler;
import com.model.Versions;

public class Runner{
    public static void main(String[] args) {
        try {
            IOHandler.createFile(Constants.PATH_DEST_CREATE, JSONHandler.ArrayListVersionsToStringJSON(Versions.getVersions()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrimaryStage.startUI();
    }
}
