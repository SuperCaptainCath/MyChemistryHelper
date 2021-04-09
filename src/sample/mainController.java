package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {

@FXML ToggleButton IPT_button;
@FXML ToggleButton LR_button;
@FXML ToggleButton CON_button;
@FXML ToggleButton EB_button;


public void handleIPT (ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("periodicTable.fxml"));
        Stage stage = (Stage) IPT_button.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setTitle("Quick Chemistry | Interactive Periodic Table");
        stage.setScene(scene);
    }catch (IOException io){
        io.printStackTrace();
    }
}

public void handleCON (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
            Stage stage = (Stage) CON_button.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setTitle("Quick Chemistry | Mass-to-Mole Converter");
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

public void handleEB (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("equationBalancer.fxml"));
            Stage stage = (Stage) EB_button.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setTitle("Quick Chemistry | Equation Balancer");
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

public void handleLR (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
            Stage stage = (Stage) LR_button.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setTitle("Quick Chemistry | Limiting Reagent Calculator");
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
