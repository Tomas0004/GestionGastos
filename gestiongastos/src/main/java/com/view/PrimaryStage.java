package com.view;

import java.io.IOException;

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
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        primaryStage.setTitle("Gestion de gastos");
        System.out.println(Font.getFamilies());
        primaryStage.setScene(new Scene(root, Constants.WIDTH, Constants.HEIGHT));
        primaryStage.show();
    }

    public static void startUI(){
        launch();
    }

    public void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
    }

}
