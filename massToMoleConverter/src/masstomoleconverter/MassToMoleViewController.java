/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masstomoleconverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class MassToMoleViewController implements Initializable {

    @FXML
    private Button switchButton;
    @FXML
    private Button convertButton;
    @FXML
    private TextField elementField;
    @FXML
    private TextField gramsField;
    @FXML
    private TextField AnswerField;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchMode(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MoleToMassView.fxml"));     
        Scene scene = new Scene(root);  
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Mole-to-Mass Converter");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void convert(ActionEvent event) {
        double totalMolarMass = 0;
        
        String elementString = elementField.getText();
        String[] separatedElements;
        String[] separatedSubscripts;
        
        //This separates the letters from the number, replacing the numbers with commas or the letters with commas
        String onlyElements = elementString.replaceAll("[^A-Za-z]", ",");
        String onlySubscripts = elementString.replaceAll("[^0-9]", ",");
        
        
        ArrayList<String> TrueElements = new ArrayList<String>();
        ArrayList<String> TrueSubscripts = new ArrayList<String>();        
        
        //Here, the strings are split up into a string array at every comma, so the array has empty cells that we do not want
        separatedElements = onlyElements.split(",");
        separatedSubscripts = onlySubscripts.split(",");
        
        //With the next two for loops, we make sure that only the populated cells are used so we put them into an arrayList
        for(int i = 0; i < separatedElements.length; i++){
            if(!separatedElements[i].equals("")){
                TrueElements.add(separatedElements[i]);                
            }
        }
        
        for(int i = 0; i < separatedSubscripts.length; i++){
            if(!separatedSubscripts[i].equals("")){
                TrueSubscripts.add(separatedSubscripts[i]);                
            }
        }

        //We compare the input element symbol to the ones in the reference text file, when they are the same we get the molar mass of the element and add it to the molar mass total
        for(int i = 0; i < TrueElements.size(); i++){
            int j = 0;
            while(!TrueElements.get(i).equals(elementBrowser.getSymbol(j))){                               
                j++;
            }
            totalMolarMass += (elementBrowser.getMolarMass(j) * Integer.parseInt(TrueSubscripts.get(i)));            
        }
        
        double answer = Integer.parseInt(gramsField.getText())/totalMolarMass;
        
        AnswerField.setText(Double.toString(answer));
        
    }

    
}
