package com.view;

public class LogInController {

    public void signIn(){
        try {
            PrimaryStage primaryStage = new PrimaryStage();
            primaryStage.changeScene("SignIn.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
