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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
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
    private Button verify_button;
    @FXML
    private TextArea warning_box;
    
    DropShadow shadow = new DropShadow();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        moles_button.setEffect(shadow);
        moles_button.setSelected(true);        
    }    
//2 Na2S2O3 + I2 = Na2S4O6 + 2 NaI
//2 Fe + 3 Cl2 = 2 FeCl3
//2 KMnO4 + 16 HCl = 2 KCl + 2 MnCl2 + 8 H2O + 5 Cl2 
//2K + Br2 = 2KBr
//

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
        warning_box.setVisible(false);
        PeriodicTable periodicTable = new PeriodicTable();
        
        String inputMolecules = equation_TextField.getText() ;              //String equation Input
        inputMolecules = inputMolecules.replaceAll("\\ ", "");
        if(inputMolecules.contains("==")){
            warning_box.setVisible(true);
            warning_box.setText("Input Error.\nDouble = found.\nTry Again.");
            return;
        }
        if(inputMolecules.contains("++")){
            warning_box.setVisible(true);
            warning_box.setText("Input Error.\nDouble + found.\nTry Again.");
            return;
        }             
       
        String rawMassMoles = enter_textfield.getText();
        rawMassMoles = rawMassMoles.replaceAll("\\ ", "");
        if(rawMassMoles.contains(",,")){
            warning_box.setVisible(true);
            warning_box.setText("Input Error in\n Mass/Moles List.\nDouble comma found.\nTry Again.");
            return;
        }  
        String[] massMolesListString = rawMassMoles.split(","); 
        double[]massMolesList = new double[massMolesListString.length];
        for (int i=0; i<massMolesListString.length; i++) {
            try{
                massMolesList[i]= Double.parseDouble(massMolesListString[i]);
            }catch(Exception e){
                warning_box.setVisible(true);
                warning_box.setText("Input Error in\n Mass/Moles List.\nNon-number found.\nTry Again.");
                return;
            }
        }
        String[] equalSplitMol = inputMolecules.split("\\=", 20); 
        String[] results;
        String[] reactants;
        if(equalSplitMol[0].contains("+")){
            reactants = equalSplitMol[0].split("\\+"); 
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
            results = equalSplitMol[1].split("\\+"); 
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
        
        if(massMolesList.length != reactants.length){
            warning_box.setVisible(true);
            warning_box.setText("Invalid Number\nof moles or masses.\nEnter the same\namount as reactants.");
            return;
        }
        Molecule[] reactantMolecules = new Molecule[reactants.length];           //reactantMolecules created, triggers actual mole call
        for (int i=0; i<reactantMolecules.length; i++) {
            reactantMolecules[i]=new Molecule(reactants[i]);
            reactantMolecules[i].setAtoms(periodicTable);
        }
        for(int i=0; i<reactantMolecules.length; i++) {
            for(int j=0; j<reactantMolecules[i].atomsArray.length; j++){
                System.out.println(reactantMolecules[i].atomsArray[j].symbol);
//                if(!reactantMolecules[i].atomsArray[j].warning){
//                    warning_box.setVisible(true);
//                    warning_box.setText("Non-existant\natom found.\nTry again.");
//                    return;
//                }
            }
        }

        Molecule[] resultMolecules = new Molecule[results.length];               //resultMolecules created
        for (int i=0; i<resultMolecules.length; i++) {
            resultMolecules[i]=new Molecule(results[i]);
            resultMolecules[i].setAtoms(periodicTable);
        }
        for(int i=0; i<resultMolecules.length; i++) {
            for(int j=0; j<resultMolecules[i].atomsArray.length; j++){
                System.out.println(resultMolecules[i].atomsArray[j].symbol);
//                if(!resultMolecules[i].atomsArray[j].warning){
//                    warning_box.setVisible(true);
//                    warning_box.setText("Non-existant\natom found.\nTry again.");
//                    return;
//                }
            }
        }

        if(mass_button.isSelected()){
            for (int i=0; i<reactantMolecules.length; i++) {
                reactantMolecules[i].setActualMass(massMolesList[i]);                    
            }
            result_textfield.setText("The limiting reagent is : " + reactantMolecules[Molecule.runMoles(reactantMolecules,resultMolecules)].getRawMolecule() + ".");
        } else
        if(moles_button.isSelected()){
            for (int i=0; i<reactantMolecules.length; i++) {
                reactantMolecules[i].setActualMoleCount(massMolesList[i]);
            }
            result_textfield.setText("The limiting reagent is : " + reactantMolecules[Molecule.runMoles(reactantMolecules,resultMolecules)].getRawMolecule() + ".");
        } else{
            warning_box.setText("Please select\nMole or Mass.");
            warning_box.setVisible(true);     
            return;
        }
    }

    @FXML
    private void handleMoles(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actual number of moles as a list (comma seperated with no spaces) for both reactants and results.");        
        moles_button.setEffect(shadow);
        mass_button.setEffect(null);
        moles_button.setSelected(true);
    }

    @FXML
    private void handleMass(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actual number of masses as a list (comma seperated with no spaces) for both reactants and results.");    
        moles_button.setEffect(null);
        mass_button.setEffect(shadow);
    }
    
}
