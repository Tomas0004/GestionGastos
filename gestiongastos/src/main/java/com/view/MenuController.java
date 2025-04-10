package com.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.model.Action;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class MenuController implements Initializable {
    private static ArrayList<User> currentUser;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button action;
    @FXML
    private Button accountVersions;
    @FXML
    private Button graphic;
    @FXML
    private Button logOut;
    
    

    // @SuppressWarnings("unchecked")
    public void action() {
        clear(action);
        action.setStyle("-fx-background-color: #45c745");
        try {
            borderPane.setCenter(FXMLLoader.load(getClass().getResource("MenuAction.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((Label)borderPane.getCenter().lookup("#username")).setStyle("-fx-font-style:italic; -fx-underline: true;");
        ((Label)borderPane.getCenter().lookup("#username")).setText(currentUser.getLast().getUsername());

        ((Label)borderPane.getCenter().lookup("#password")).setStyle("-fx-font-style:italic; -fx-underline: true;");
        ((Label)borderPane.getCenter().lookup("#password")).setText(currentUser.getLast().getPassword());
        
        ((Label)borderPane.getCenter().lookup("#name")).setStyle("-fx-font-style:italic; -fx-underline: true;");
        ((Label)borderPane.getCenter().lookup("#name")).setText(currentUser.getLast().getName());

        ((Label)borderPane.getCenter().lookup("#amountLeft")).setStyle("-fx-font-style:italic; -fx-underline: true;");
        ((Label)borderPane.getCenter().lookup("#amountLeft")).setText(String.valueOf(currentUser.getLast().getAmountLeft()));
        
        ((Label)borderPane.getCenter().lookup("#actions")).setStyle("-fx-font-style:italic; -fx-underline: true;");

        ComboBox<String> comboBox = (ComboBox<String>)borderPane.getCenter().lookup("#combobox"); //Este nodo devuelto por lookp siempre va a ser de tipo ComboBox (siempre y cuando asi este en el fxml), por eso el supresion de warning
        for(int i = 0; i < currentUser.getLast().getActions().size(); i++){
            comboBox.getItems().add(String.valueOf(currentUser.getLast().getActions().get(i).getAmountMoved()));
        }

        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedItem = comboBox.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    int index = comboBox.getSelectionModel().getSelectedIndex();
                    Action action = currentUser.getLast().getActions().get(index);
                    ((Label)borderPane.getCenter().lookup("#action")).setText(action.toString());
                }
            }
        });
        
    }

    

    public void accountVersions() {
        clear(accountVersions);
        accountVersions.setStyle("-fx-background-color: #45c745");
    }

    public void graphic() {
        clear(graphic);
        graphic.setStyle("-fx-background-color: #45c745");
    }

    public void logOut() {
        PrimaryStage primaryStage = new PrimaryStage();
        try {
            primaryStage.changeScene("LogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }

    public void clear(Button currentButton) {
        Arrays.asList(action, accountVersions, graphic, logOut).forEach(new Consumer<Button>() {
            @Override
            public void accept(Button button) {
                button.setStyle("-fx-background-color: #229222");
                button.setOnMouseEntered(null);
                button.setOnMouseExited(null);
            }
        });
        Arrays.asList(action, accountVersions, graphic, logOut).forEach(new Consumer<Button>() {
            @Override
            public void accept(Button button) {
                if (button != currentButton) {
                    button.setOnMouseEntered(_ -> {
                        button.setStyle("-fx-background-color: #25a825");
                    });

                    button.setOnMouseExited(_ -> {
                        button.setStyle("-fx-background-color: #229222");
                    });
                }
            }
        });

    }

    public static void setCurrentUser(ArrayList<User> currentUser_) {
        currentUser = currentUser_;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        action();
    }
}
