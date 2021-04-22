/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Catherine
 */
public class LReagentFXMLController implements Initializable {

    @FXML
    private Button back_button;
    @FXML
    private TextField equation_TextField;
    @FXML
    private ToggleButton mass_button;
    @FXML
    private TextField enter_textfield;
    @FXML
    private TextField result_textfield;
    @FXML
    private Text titleText;
    @FXML
    private ToggleButton moles_button;
    @FXML
    private ToggleGroup computeGroup;
    @FXML
    private Button calculate_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
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

    @FXML
    private void handleCalculateButton(ActionEvent event) {
        PeriodicTable periodicTable = new PeriodicTable();
        
        String inputMolecules = equation_TextField.getText() ;                                           //String Input / Split
        String[] equalSplitMol = inputMolecules.split("\\ = ", 20); 
        String[] reactants;
        String[] results;
        if(equalSplitMol[0].contains("+")){
            reactants = equalSplitMol[0].replaceAll("\\+", "").split("  "); 
        }else{
            reactants = new String[1];
            reactants[0] = equalSplitMol[0];
        }
        if(equalSplitMol[1].contains("+")){
            results = equalSplitMol[1].replaceAll("\\+", "").split("  "); 
        }else{
            results = new String[1];
            results[0] = equalSplitMol[1];
        }
    }

    @FXML
    private void handleMoles(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actual number of moles as a list (comma seperated with no spaces) for both reactants and results.");        
    }

    @FXML
    private void handleMass(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actual number of masses as a list (comma seperated with no spaces) for both reactants and results.");    
    }
    
}
