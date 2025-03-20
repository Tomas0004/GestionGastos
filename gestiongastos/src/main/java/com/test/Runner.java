package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Runtime.Version;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import com.model.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Runner extends Application {
    Button buttonOne = new Button();

    public static void main(String[] args) {
        ArrayList<Versions> usersVersions = new ArrayList<>();
        usersVersions.add(new Versions());
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1234", "Tomas1234", "Tomas", 100000));
        users.getLast().addAction(new Action(LocalDate.now(), LocalTime.now(), 33333));
        users.add(new User("0000", "Peres", "Pepito", 3333333));
        users.getLast().addAction(new Action(LocalDate.now(), LocalTime.now(), 333333));

        usersVersions.getLast().setVersions(users);
        System.out.println(usersVersions);

        try {
            String temp = Encryption.encript(JSONHandler.ArrayListVersionsToStringJSON(usersVersions));

            System.out.println(temp.length());
            IOHandler.createFile(Constants.PATH_DEST_CREATE, temp);
            System.out.println(Encryption.decrypt(IOHandler.readerFile(Constants.PATH_DEST_CREATE)));
            System.out.println(JSONHandler.StringJSONToArrayListVersions(Encryption.decrypt(IOHandler.readerFile(Constants.PATH_DEST_CREATE))));
        } catch (Exception e){
            e.printStackTrace();
        }

        //launch(args);
        /*try {
            IOHandler.createFile("gestiongastos/src/main/resources/output.txt", "Hello World\nComo estan?");
            System.out.println(IOHandler.readerFile("gestiongastos/src/main/resources/output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return ;
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        buttonOne.textProperty().set("Click");
        buttonOne.setPrefWidth(100);
        buttonOne.setPrefHeight(100);

        primaryStage.setTitle("Gestión de gastos");
        primaryStage.setWidth(Constants.WIDTH);
        primaryStage.setHeight(Constants.HEIGHT);
        
        root.getChildren().add(buttonOne);
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setScene(scene);
        buttonOne.setOnAction(e -> {
            root.getChildren().remove(buttonOne);
        });

        primaryStage.show();
    }

}
