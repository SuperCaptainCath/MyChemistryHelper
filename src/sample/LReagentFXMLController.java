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
    
    private DropShadow shadow = new DropShadow();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
//String str = "2Fe2O3 + 3CO + 4C = 2Fe + 3CO2 + 4C"; 
//        String str = "CaCO3 = CaO + CO2";
//String str = "2Fe2O3+3CO=2Fe+3CO2";
    //2K +Br2 = 2KBr
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
        
        String inputMolecules = equation_TextField.getText() ;                                           //String Input / Split        
        String[] equalSplitMol = inputMolecules.replace(" ","").split("\\=", 20);                       //input check needs to be added
        String[] results;
        String[] reactants;
        
        String rawMassMoles = enter_textfield.getText();                                 //input check needs to be added
        String[] massMolesListString = rawMassMoles.replaceAll("\\ ", "").split(","); 
        double[]massMolesList = new double[massMolesListString.length];
        for (int i=0; i<massMolesListString.length; i++) {
            massMolesList[i]= Double.parseDouble(massMolesListString[i]);
        }
        
        
        if(equalSplitMol[0].contains("+")){                                                             //Split reactants
            reactants = equalSplitMol[0].split("\\+");            
        }else{
            reactants = new String[1];
            reactants[0] = equalSplitMol[0];            
        }
        if(equalSplitMol[1].contains("+")){                                                            //split results
            results = equalSplitMol[1].split("\\+"); 
        }else{
            results = new String[1];
            results[0] = equalSplitMol[1];
        }
        
        if(massMolesList.length != reactants.length){                                                   //input length check Mass/moles
            warning_box.setVisible(true);
            warning_box.setText("Invalid Number\nof moles or masses.\nEnter the same\namount as reactants.");
        }       
        else{
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
            
            if(mass_button.isSelected()){                                                               //mass output
                for (int i=0; i<reactantMolecules.length; i++) {
                    reactantMolecules[i].setActualMass(massMolesList[i]);                    
                }
                System.out.println("mass button reacted");
                result_textfield.setText("The limiting reagent is : " + reactantMolecules[Molecule.runMoles(reactantMolecules,resultMolecules)].getRawMolecule() + ".");
            }
            else{//(moles_button.isSelected()){                                                          //moles output
                for (int i=0; i<reactantMolecules.length; i++) {
                    reactantMolecules[i].setActualMoleCount(massMolesList[i]);
                }
                System.out.println("moles button reacted");
                result_textfield.setText("The limiting reagent is : " + reactantMolecules[Molecule.runMoles(reactantMolecules,resultMolecules)].getRawMolecule() + ".");
            }
        }

    }

    @FXML
    private void handleMoles(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actual number of moles as a list \n(comma seperated with no spaces) for all and only reactants.");    
        //while(moles_button.isSelected()){
            moles_button.setEffect(shadow);
           
           //trigger me then close you
        //}
    }

    @FXML
    private void handleMass(ActionEvent event) {
        enter_textfield.setPromptText("Enter the actSual number of masses as a list \n(comma seperated with no spaces) for all and only reactants.");    
        //while(mass_button.isSelected()){
            mass_button.setEffect(shadow);
        //}
    }
    
}
