package com.view;

import java.io.IOException;
import java.util.ArrayList;

import com.model.User;
import com.model.Versions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SignInController {
    @FXML
    TextField username, name, amountLeft;

    @FXML
    PasswordField pass;

    @FXML
    Label uMsg, pMsg, nMsg, aMsg;

    public void signIn() {
        uMsg.setText("");
        pMsg.setText("");
        nMsg.setText("");
        aMsg.setText("");

        String user = username.getText();
        String password = pass.getText();
        String nameUser = name.getText();
        String amountLeftUser = amountLeft.getText();

        if (user.isEmpty()) {
            uMsg.setText("Campo requerido");
            uMsg.textFillProperty().setValue(Color.RED);
        }else if(password.isEmpty()){
            pMsg.setText("Campo requerido");
            pMsg.textFillProperty().setValue(Color.RED);
        }else if(nameUser.isEmpty()){
            nMsg.setText("Campo requerido");
            nMsg.textFillProperty().setValue(Color.RED);
        }else if(amountLeftUser.isEmpty()){
            aMsg.setText("Campo requerido");
            aMsg.textFillProperty().setValue(Color.RED);
        }else{
            PrimaryStage primaryStage = new PrimaryStage();
            try {
                int amountLeft = Integer.parseInt(amountLeftUser);
                Versions.addVersionsUser(new ArrayList<>());
                Versions.getVersions().getLast().add(new User(password, user, nameUser, amountLeft));
                primaryStage.changeScene("Login.fxml");
            } catch (NumberFormatException e) {
                aMsg.setText("Entrada invalida");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void back(){
        PrimaryStage primaryStage = new PrimaryStage();
        try {
            primaryStage.changeScene("Login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
