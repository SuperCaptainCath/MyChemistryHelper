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
    @FXML
    private Button check_button;

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
            for(int i = 0; i < reactants.length;i++){
                System.out.println(reactants[i]);
            }
        }else{
            reactants = new String[1];
            reactants[0] = equalSplitMol[0];
            for(int i = 0; i < reactants.length;i++){
                System.out.println(reactants[i]);
            }
        }
        if(equalSplitMol[1].contains("+")){
            results = equalSplitMol[1].replaceAll("\\+", "").split("  "); 
            for(int i = 0; i < results.length;i++){
                System.out.println(results[i]);
            }
        }else{
            results = new String[1];
            results[0] = equalSplitMol[1];
            for(int i = 0; i < results.length;i++){
                System.out.println(results[i]);
            }
        }
        boolean massMolesInputCheck = false;
        boolean massMoleCheck;
        
        while(!massMolesInputCheck){
            String rawMoles = enter_textfield.getText();
            String[] molesList = rawMoles.replaceAll("\\ ", "").split(","); 
            if(molesList.length !=reactants.length){
                
            }
        }
        
        Molecule[] reactantMolecules = new Molecule[reactants.length];           //reactantMolecules created, triggers actual mole call
        for (int i=0; i<reactantMolecules.length; i++) {
            reactantMolecules[i]=new Molecule(reactants[i]);
            reactantMolecules[i].setAtoms(periodicTable);
        }
        
        Molecule[] resultMolecules = new Molecule[results.length];               //resultMolecules created
        for (int i=0; i<resultMolecules.length; i++) {
            resultMolecules[i]=new Molecule(results[i]);
            resultMolecules[i].setAtoms(periodicTable);
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

    @FXML
    private void handleCheckButton(ActionEvent event) {
    }
    
}
