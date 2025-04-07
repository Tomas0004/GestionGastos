package com.view;

import java.util.Arrays;

import com.model.Versions;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LogInController {
    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label msg;

    public void logIn() {
        clear();

        try {
            String user = username.getText();
            String pass = password.getText();
            if (Versions.findVersionsUser(user) == null) {
                msg.setText("Usuario y/o contraseña incorrectos");
                msg.setTextFill(Color.RED);
                username.requestFocus();
                return;
            }else{
                if (!Versions.findVersionsUser(user).getLast().getPassword().equals(pass)) {
                    msg.setText("Usuario y/o contraseña incorrectos");
                    msg.setTextFill(Color.RED);
                    username.requestFocus();
                    return;
                }
            }

            PrimaryStage primaryStage = new PrimaryStage();
            primaryStage.changeScene("Menu.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        msg.setText("");
    }

    public void advance() {
        TextField[] fieldMap = {
                username, password, null
        };

        for (Node node : fieldMap) {
            if (node instanceof TextField) {
                ((TextField) node).setOnKeyPressed(event -> {
                    if (event.getCode().toString().equals("ENTER")) {
                        Node nextNode = fieldMap[Arrays.asList(fieldMap).indexOf(node) + 1];
                        if (nextNode != null) {
                            nextNode.requestFocus();
                        } else {
                            logIn();
                        }
                    }
                });
            }
        }
    }

    public void signIn() {
        try {
            PrimaryStage primaryStage = new PrimaryStage();
            primaryStage.changeScene("SignIn.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
