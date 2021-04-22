/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DecimalFormat;
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
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Elliot
 */
public class converterController implements Initializable {

    @FXML
    private Button switchButton;
    @FXML
    private Button convertButton;
    @FXML
    private TextField elementField;
    @FXML
    private TextField AnswerField;
    @FXML
    private TextField variableField;
    @FXML
    private Text titleText;
    @FXML
    private Text variableText;
    
    @ FXML Button back_button;
    
    boolean isMassToMole = true;
    @FXML
    private Text AnswerText;

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
    private void switchMode(ActionEvent event) throws IOException {
        
        
        if(isMassToMole){
            variableField.setPromptText("Insert Number of Moles Here");
            AnswerField.setPromptText("Mass Displays Here");
            variableText.setText("• Moles •");
            AnswerText.setText("• Mass •");
            //switchButton.setText("Switch to mass-to-mole");
            isMassToMole = false;
            
        } 
        else if(!isMassToMole){
            variableField.setPromptText("Insert Mass here");
            AnswerField.setPromptText("Moles Displays Here");
            variableText.setText("• Mass •");
            AnswerText.setText("• Moles •");
            //switchButton.setText("Switch to mole-to-mass");
            isMassToMole = true;
        }
        
        
    }

    @FXML
    private void convert(ActionEvent event) {
        try{
        if(isMassToMole){
        double totalMolarMass = 0;
        
        String elementString = elementField.getText();
        String[] separatedElements;
        int numOfElements = 0;
        String[] separatedSubscripts;
        
        //This separates the letters from the number, replacing the numbers with commas or the letters with commas
        String onlyElements = elementString.replaceAll("[^A-Za-z]", ",");
        
        String onlyElementCapitals = onlyElements.replaceAll("[^A-Z]", ",");
        char[] numOfElementsFinder = onlyElementCapitals.toCharArray();
        for(int i = 0; i < numOfElementsFinder.length; i++){
            if(numOfElementsFinder[i] == ','){
                
            } else {
                numOfElements++;
            }
        }
        
        separatedElements = new String[numOfElements];
        char[] elementsChar = onlyElements.toCharArray();
        int adjuster = 0;
        for(int i = 0; i < elementsChar.length ; i++){
            switch (elementsChar[i]) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    separatedElements[i-adjuster] = Character.toString(elementsChar[i]);
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    separatedElements[i-1-adjuster] = separatedElements[i-1-adjuster] + Character.toString(elementsChar[i]);
                    adjuster++;
                    break;
                default:
                    adjuster++;
                    break;
            }
        }
        
        
        
       
        
        String onlySubscripts = elementString.replaceAll("[^0-9a-z]", ",");
        onlySubscripts = onlySubscripts.replaceAll("[^1-9,]", "0");
        
        ArrayList<String> TrueElements = new ArrayList<String>();
        ArrayList<String> TrueSubscripts = new ArrayList<String>();        
        
        //Here, the strings are split up into a string array at every comma, so the array has empty cells that we do not want       
        separatedSubscripts = onlySubscripts.split(",");
        
        if(separatedSubscripts.length==0){
            separatedSubscripts = new String[separatedElements.length];
            for(int i = 0; i < separatedSubscripts.length; i++){
                separatedSubscripts[i] = "1";               
            }
        }
        
        for(int i = 0; i < separatedElements.length; i++){
            if(!separatedElements[i].equals("")){
                TrueElements.add(separatedElements[i]);                
            }
        }
        
        for(int i = 0; i < separatedSubscripts.length; i++){
            if(separatedSubscripts[i].equals("")){
                TrueSubscripts.add("1");                
            } else if(!separatedSubscripts[i].equals("")){
                TrueSubscripts.add(separatedSubscripts[i]);                
            }
        }
        TrueSubscripts.remove(0);
        
        if(TrueSubscripts.size() < separatedElements.length){
            TrueSubscripts.add("1");
        }
        
       

        //We compare the input element symbol to the ones in the reference text file, when they are the same we get the molar mass of the element and add it to the molar mass total
        
        for(int i = 0; i < TrueElements.size(); i++){
            int j = 0;
            while(!TrueElements.get(i).equals(elementBrowser.getSymbol(j))){                               
                j++;
            }
            totalMolarMass += (elementBrowser.getMolarMass(j) * Integer.parseInt(TrueSubscripts.get(i)));            
        }
        
        double answer = Integer.parseInt(variableField.getText()) / totalMolarMass;
        DecimalFormat numberFormat = new DecimalFormat("#.####");
        AnswerField.setText(numberFormat.format(answer) + " moles");
        
        }
        
       
        
        
        
        
        
        
        else if(!isMassToMole){
            double totalMolarMass = 0;
        String elementString = elementField.getText();
        String[] separatedElements;
        int numOfElements = 0;
        String[] separatedSubscripts;
        
        //This separates the letters from the number, replacing the numbers with commas or the letters with commas
        String onlyElements = elementString.replaceAll("[^A-Za-z]", ",");
        
        String onlyElementCapitals = onlyElements.replaceAll("[^A-Z]", ",");
        char[] numOfElementsFinder = onlyElementCapitals.toCharArray();
        for(int i = 0; i < numOfElementsFinder.length; i++){
            if(numOfElementsFinder[i] == ','){
                
            } else {
                numOfElements++;
            }
        }
        
        separatedElements = new String[numOfElements];
        char[] elementsChar = onlyElements.toCharArray();
        int adjuster = 0;
        for(int i = 0; i < elementsChar.length ; i++){
            switch (elementsChar[i]) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    separatedElements[i-adjuster] = Character.toString(elementsChar[i]);
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    separatedElements[i-1-adjuster] = separatedElements[i-1-adjuster] + Character.toString(elementsChar[i]);
                    adjuster++;
                    break;
                default:
                    adjuster++;
                    break;
            }
        }
        
        
        
       
        
        String onlySubscripts = elementString.replaceAll("[^0-9a-z]", ",");
        onlySubscripts = onlySubscripts.replaceAll("[^1-9,]", "0");
        
        ArrayList<String> TrueElements = new ArrayList<String>();
        ArrayList<String> TrueSubscripts = new ArrayList<String>();        
        
        //Here, the strings are split up into a string array at every comma, so the array has empty cells that we do not want       
        separatedSubscripts = onlySubscripts.split(",");
        
        if(separatedSubscripts.length==0){
            separatedSubscripts = new String[separatedElements.length];
            for(int i = 0; i < separatedSubscripts.length; i++){
                separatedSubscripts[i] = "1";               
            }
        }
        
        for(int i = 0; i < separatedElements.length; i++){
            if(!separatedElements[i].equals("")){
                TrueElements.add(separatedElements[i]);                
            }
        }
        
        for(int i = 0; i < separatedSubscripts.length; i++){
            if(separatedSubscripts[i].equals("")){
                TrueSubscripts.add("1");                
            } else if(!separatedSubscripts[i].equals("")){
                TrueSubscripts.add(separatedSubscripts[i]);                
            }
        }
        TrueSubscripts.remove(0);
        
        if(TrueSubscripts.size() < separatedElements.length){
            TrueSubscripts.add("1");
        }
        
        //We compare the input element symbol to the ones in the reference text file, when they are the same we get the molar mass of the element and add it to the molar mass total
        for(int i = 0; i < TrueElements.size(); i++){
            int j = 0;
            while(!TrueElements.get(i).equals(elementBrowser.getSymbol(j))){                               
                j++;
            }
            totalMolarMass += (elementBrowser.getMolarMass(j) * Integer.parseInt(TrueSubscripts.get(i)));            
        }
        
        double answer = Integer.parseInt(variableField.getText()) * totalMolarMass;
        DecimalFormat numberFormat = new DecimalFormat("#.####");
        AnswerField.setText(numberFormat.format(answer) + " grams");
        }
        
        } catch(Exception e){
            AnswerField.setText("One of the values you entered is invalid!");
        }
    }
        
    }

    

