package com.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Runner extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de gastos");
        primaryStage.show();
        //Scene scene = new Scene(new MainView(), 800, 600);
        
    }
}
