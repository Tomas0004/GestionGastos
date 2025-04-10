package com.view;

import java.time.LocalDateTime;

import com.model.Action;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class MenuActionController {
    @FXML
    private Label result;
    @FXML
    private TextField addAction;

    public void addAction(){
        ComboBox<String> comboBox = (ComboBox<String>)borderPane.getCenter().lookup("#combobox");
        int action = 0;
        try {
            action = Integer.parseInt(addAction.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        User user = new User();
        try {
            user.addAction(new Action(LocalDateTime.now(), action));
            result.textFillProperty().setValue(Color.BLUE);
            result.setText("Accion añadida exitosamente");
            comboBox.getItems().add(String.valueOf(currentUser.getLast().getActions().getLast().getAmountMoved()));
            ((Label)borderPane.getCenter().lookup("#amountLeft")).setText(String.valueOf(user.getAmountLeft()));
        } catch (Exception e) {
            result.textFillProperty().setValue(Color.RED);
            result.setText(e.getMessage());
        }
    }
}
