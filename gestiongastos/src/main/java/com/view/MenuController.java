package com.view;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuController{
    @FXML
    private Button action;
    @FXML
    private Button accountVersions;
    @FXML
    private Button graphic;
    @FXML
    private Button logOut;

    public void action(){
        clear(action);
        action.setStyle("-fx-background-color: #45c745");
        
    }
    public void accountVersions(){
        clear(accountVersions);
        accountVersions.setStyle("-fx-background-color: #45c745");
    }
    public void graphic(){
        clear(graphic);
        graphic.setStyle("-fx-background-color: #45c745");
    }
    public void logOut(){

    }

    public void clear(Button currentButton){
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
                if(button != currentButton){
                    button.setOnMouseEntered(event -> {
                        button.setStyle("-fx-background-color: #25a825");
                    });

                    button.setOnMouseExited(event -> {
                        button.setStyle("-fx-background-color: #229222");
                    });
                }
            }
        });
    }
}
