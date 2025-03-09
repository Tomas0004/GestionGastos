package com.test;

import com.model.Constants;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Runner extends Application {
    Button buttonOne = new Button();

    public static void main(String[] args) {
        launch(args);
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
