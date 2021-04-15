package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.TextField;

public class equBalancerController {

    @FXML Button back_button;
    @FXML private TextField inEquTextField;
    @FXML private TextField outEquTextField;
    @FXML private Button balance_button;
    
    
    public void clickOnButton(){
        //create matrix
        Matrix matrix = new Matrix(inEquTextField.getText());
        //verify matrix 
        if(!matrix.canBeSolved()){
            outEquTextField.setText("This equation cannot be solved. Please verify and try again.");
        }
        else{
            outEquTextField.setText(matrix.solveMatrix());
        }
    }

    public void handleExit (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));
            Stage stage = (Stage) back_button.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        }catch (IOException io){
            io.printStackTrace();
        }
    }

}
