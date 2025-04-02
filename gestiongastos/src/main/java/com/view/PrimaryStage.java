package com.view;

import com.model.Constants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PrimaryStage extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        stg.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        stg.setTitle("Gestion de gastos");
        System.out.println(Font.getFamilies());
        stg.setScene(new Scene(root, Constants.WIDTH, Constants.HEIGHT));
        stg.show();
    }

    public static void startUI(){
        launch();
    }

}
