package com.view;

import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import com.model.Constants;
import com.model.Encryption;
import com.model.IOHandler;
import com.model.JSONHandler;
import com.model.User;
import com.model.Versions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignInController implements Initializable{
    @FXML
    private TextField username, name, amountLeft;

    @FXML
    private PasswordField pass;

    @FXML
    Label uMsg, pMsg, nMsg, aMsg;

    public void signIn() {
        clearMessages();

        if (!validateFields()) {
            return;
        }

        try {
            int amountLeftValue = Integer.parseInt(amountLeft.getText());
            if (Versions.findVersionsUser(username.getText()) != null) {
                setErrorMessage(uMsg, "Seleccione otro nombre de usuario");
                username.requestFocus();
                return;
            }

            ArrayList<User> userList = new ArrayList<>();
            userList.add(new User(pass.getText(), username.getText(), name.getText(), amountLeftValue));
            Versions.addVersionsUser(userList);

            IOHandler.createFile(Constants.PATH_DEST_CREATE,
                    Encryption.encript(JSONHandler.ArrayListVersionsToStringJSON(Versions.getVersions())));

            new PrimaryStage().changeScene("LogIn.fxml");
        } catch (NumberFormatException e) {
            setErrorMessage(aMsg, "Entrada invalida");
        } catch (IOException e) {
            System.err.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

    private boolean validateFields() {
        boolean isValid = true;

        if (username.getText().isEmpty()) {
            setErrorMessage(uMsg, "Campo requerido");
            username.requestFocus();
            isValid = false;
        } else if (pass.getText().isEmpty()) {
            setErrorMessage(pMsg, "Campo requerido");
            pass.requestFocus();
            isValid = false;
        } else if (name.getText().isEmpty()) {
            setErrorMessage(nMsg, "Campo requerido");
            name.requestFocus();
            isValid = false;
        } else if (amountLeft.getText().isEmpty()) {
            setErrorMessage(aMsg, "Campo requerido");
            amountLeft.requestFocus();
            isValid = false;
        }

        return isValid;
    }

    private void setErrorMessage(Label label, String message) {
        label.setText(message);
        label.textFillProperty().setValue(Color.RED);
    }

    private void clearMessages() {
        uMsg.setText("");
        pMsg.setText("");
        nMsg.setText("");
        aMsg.setText("");
    }

    public void advance() {
        TextField[] fieldMap = {
            username, pass, name, amountLeft, null
        };

        for (Node node : fieldMap) {
            if (node instanceof TextField) {
                ((TextField) node).setOnKeyPressed(event -> {
                    if (event.getCode().toString().equals("ENTER")) {
                        Node nextNode = fieldMap[Arrays.asList(fieldMap).indexOf(node) + 1];
                        if (nextNode != null) {
                            nextNode.requestFocus();
                        } else {
                            signIn();
                        }
                    }
                });
            }
        }
    }

    public void back() {
        try {
            new PrimaryStage().changeScene("Login.fxml");
        } catch (IOException e) {
            System.err.println("Error al cambiar de escena: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(Toolkit.getDefaultToolkit().getScreenSize().getHeight() < Constants.HEIGHT){
            Stage.getWindows().getFirst().setHeight(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        }
    }
}
