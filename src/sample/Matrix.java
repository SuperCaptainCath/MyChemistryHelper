/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.util.ArrayList;

/**
 *
 * @author Ioana Maria Jivan
 */
public class Matrix {
    private Fractions[][] matrixArray;
    private String[] equationTerms;
    private int productBegins = 2;
    private boolean canBeSolved = true;
    
    public Matrix(String input){
        try{
            this.buildMatrix(input);
        }catch(Exception ex){
            this.canBeSolved = false;
        }
    }
    
    public void buildMatrix(String equ){
        String trimmedEquation = equ.replaceAll(" ", "");
        
        String[] firstArray = trimmedEquation.split("=");
        
        
        String[] reagentsArray1 = firstArray[0].replaceAll("\\+", "   ").split("   ");
        
        String[] productsArray1 = firstArray[1].replaceAll("\\+", "   ").split("   ");
        
        
        String[] termsArray = new String[reagentsArray1.length + productsArray1.length];
        
        
        /*modification from Matlab*/
        for (int i = 0; i < reagentsArray1.length; i++){
            termsArray[i] = reagentsArray1[i];
            this.productBegins = i + 1; 
        }
        
            
        for (int i = 0; i < productsArray1.length; i++){
            termsArray[this.productBegins + i] = productsArray1[i];
        }
        
        
        
        this.equationTerms = new String[termsArray.length];
        
        
        for (int i = 0; i < termsArray.length; i++){
            this.equationTerms[i] = termsArray[i];
        }
        
        
        
        //MAKE READABLE
        String[] readableArray = this.makeReadable(termsArray);
        
        
        //create an array of elements - seperate at digits
        String tempElement = "";
        ArrayList<String> elementArray = new ArrayList<>();
        /*modification from Matlab*/
        
        for(int i = 0; i < readableArray.length; i++){
            for(int k = 0; k < readableArray[i].length(); k++){
                if(!Character.isDigit(readableArray[i].charAt(k))){
                    tempElement = tempElement + readableArray[i].charAt(k);
                }
                else{
                    if(tempElement.compareTo("") != 0){
                        if(this.findRowIndexOfElement(tempElement, elementArray) == -1){
                            elementArray.add(tempElement);
                        }
                        tempElement = "";
                    }
                }
            }
        }
        
        
        
        
        if(readableArray.length - elementArray.size() > 1){
            this.canBeSolved = false;
        }
        
        //create matrix array
        //initialize with zero
        String zero = "0/1";
        matrixArray = new Fractions[readableArray.length][readableArray.length];
        
        for(int i = 0; i < readableArray.length; i++){
            for(int k = 0; k < readableArray.length; k++){
                this.matrixArray[i][k] = new Fractions(zero);
            }
        }
        
        
        
        //begin counting
        String elementName = "";
        String digits = "";
        String tempArbitraryCopy = ""; /*modified from Matlab*/
        
        for(int i = 0; i < readableArray.length; i++){
            for(int k = 0; k < readableArray[i].length(); k++){
                if(k == 0){
                    tempArbitraryCopy = readableArray[i].charAt(k) + "";
                    elementName = readableArray[i].charAt(k) + "";
                }
                else{
                    if(!Character.isDigit(readableArray[i].charAt(k))){
                        if(!Character.isDigit(tempArbitraryCopy.charAt(tempArbitraryCopy.length() - 1))){
                            elementName = elementName + readableArray[i].charAt(k);
                            tempArbitraryCopy = tempArbitraryCopy + readableArray[i].charAt(k);
                            digits = "";
                        }
                        else{
                            int indexOfElement = this.findRowIndexOfElement(elementName, elementArray);
                            
                            elementName = readableArray[i].charAt(k) + "";
                            tempArbitraryCopy = tempArbitraryCopy + readableArray[i].charAt(k);
                            
                            String tempFractionS;
                            
                            if(i < this.productBegins){
                                tempFractionS = digits + "/1";
                            }
                            else{
                                tempFractionS = "-" + digits + "/1";
                            }
                            this.matrixArray[indexOfElement][i] = new Fractions(tempFractionS);
                            digits = "";
                        }
                    }
                    else{
                        digits = digits + readableArray[i].charAt(k);
                        tempArbitraryCopy = tempArbitraryCopy + readableArray[i].charAt(k);
                        
                        if(k == readableArray[i].length() - 1){
                            int indexOfElement = this.findRowIndexOfElement(elementName, elementArray);
                            elementName = "";
                            
                            String tempFractionS;
                            
                            if(i < this.productBegins){
                                tempFractionS = digits + "/1";
                            }
                            else{
                                tempFractionS = "-" + digits + "/1";
                            }
                            this.matrixArray[indexOfElement][i] = new Fractions(tempFractionS);
                            digits = "";
                        }
                    }
                }
            }
        }
        
        
        
    }
    
    public boolean canBeSolved(){
        return this.canBeSolved;
    }
    
    public int findRowIndexOfElement(String element, ArrayList<String> arrayOfElements){
        int index = -1;
        
        for(int i = 0; i < arrayOfElements.size(); i++){
            if(arrayOfElements.get(i).compareTo(element) == 0){
                index = i;
                break;
            }
        }
        
        return index;
    }
    
    public String[] makeReadable(String[] arrayOfString){
        String tempCharacters = "";
        String[] otherArrayOfString = new String[arrayOfString.length];
        
        for(int i = 0; i < arrayOfString.length; i++){
            for(int k = 0; k < arrayOfString[i].length(); k++){
                if (k == 0){
                    tempCharacters = arrayOfString[i].charAt(k) + "";
                }
                else{
                    if(k == arrayOfString[i].length() - 1){
                        if (Character.isUpperCase(arrayOfString[i].charAt(k)) && !Character.isDigit(tempCharacters.charAt(tempCharacters.length() - 1))){
                            tempCharacters = tempCharacters + "1";
                        }
                        tempCharacters = tempCharacters + arrayOfString[i].charAt(k);
                        if(!Character.isDigit(tempCharacters.charAt(tempCharacters.length() - 1))){
                            tempCharacters = tempCharacters + "1";
                        }
                    }
                    else{
                        if(Character.isLowerCase(arrayOfString[i].charAt(k))){
                            tempCharacters = tempCharacters + arrayOfString[i].charAt(k);
                        }
                        else if(Character.isDigit(arrayOfString[i].charAt(k))){
                            tempCharacters = tempCharacters + arrayOfString[i].charAt(k);
                        }
                        else if(arrayOfString[i].charAt(k) == '(' || arrayOfString[i].charAt(k) == ')'){
                            if(!Character.isDigit(tempCharacters.charAt(tempCharacters.length() - 1))){
                                tempCharacters = tempCharacters + "1" + arrayOfString[i].charAt(k);
                            }
                            else{
                                tempCharacters = tempCharacters + arrayOfString[i].charAt(k);
                            }
                        }
                        else if(Character.isUpperCase(arrayOfString[i].charAt(k))){
                            if(!Character.isDigit(tempCharacters.charAt(tempCharacters.length() - 1)) && tempCharacters.charAt(tempCharacters.length() - 1) != '('){
                                tempCharacters = tempCharacters + "1" + arrayOfString[i].charAt(k);
                            }
                            else{
                                tempCharacters = tempCharacters + arrayOfString[i].charAt(k);
                            }
                        }
                    }
                }
            }
            otherArrayOfString[i] = tempCharacters;
            tempCharacters = "";
        }
        
        String[] processedEq = this.containsParenthesis(otherArrayOfString);
        
        
        return processedEq;
    }
    
    public String[] containsParenthesis(String[] arrayOfString){
        
        
        String[] simplifiedArray = new String[arrayOfString.length];
        //initialize simplifiedArray
        for(int i = 0; i < simplifiedArray.length; i++){
            simplifiedArray[i] = "";
        }
        
        for(int i = 0; i < arrayOfString.length; i++){
            String[] tempArray = arrayOfString[i].split("\\(");
            
            for(int k = 0; k < tempArray.length; k++){
                
                
                if (tempArray[k].replaceAll("\\)", "   ").contains("   ") == false){
                    simplifiedArray[i] = simplifiedArray[i] + tempArray[k];
                }
                
                else{
                    String[] coefficientArray = tempArray[k].replaceAll("\\)", "   ").split("   ");
                    
                    
                    String tempCoefficient = "";
                    String remainder = "";
                    for(int j = 0; j < coefficientArray[1].length(); j++){
                        if(Character.isDigit(coefficientArray[1].charAt(j))){
                            tempCoefficient = tempCoefficient + coefficientArray[1].charAt(j);
                        }
                        else{
                            for(int l = j; l < coefficientArray[1].length(); l++){
                                remainder = remainder + coefficientArray[1].charAt(l);
                            }
                            break;
                        }
                    }
                    String tempDigits = "";
                    String tempTerm = "";
                    
                    for (int j = 0; j < coefficientArray[0].length(); j++){
                        if (j == 0){
                            tempTerm = coefficientArray[0].charAt(j) + "";
                        }
                        else{
                            if(!Character.isDigit(coefficientArray[0].charAt(j))){
                                if(!Character.isDigit(tempTerm.charAt(tempTerm.length() - 1))){
                                    tempTerm = tempTerm + (Integer.parseInt(tempCoefficient) * Integer.parseInt(tempDigits)) + coefficientArray[0].charAt(j);
                                    tempDigits = "";
                                }
                                else{
                                    tempTerm = tempTerm + coefficientArray[0].charAt(j);
                                }
                            }
                            else if(Character.isDigit(coefficientArray[0].charAt(j))){
                                tempDigits = tempDigits + coefficientArray[0].charAt(j);
                                if(j == coefficientArray[0].length() - 1){
                                    tempTerm = tempTerm + (Integer.parseInt(tempCoefficient) * Integer.parseInt(tempDigits));
                                }
                            }
                        }
                    }
                    simplifiedArray[i] = simplifiedArray[i] + tempTerm + remainder;
                }
            }
        }
        
        return simplifiedArray;
    }
    
    
    public String solveMatrix(){
        for(int i = 0; i < this.matrixArray.length - 1; i++){
            this.switchIfNecessary(i);
            
            
            
            this.multiplyAndAdd(i);
            
            
            
        }
        this.simplify();
        
        
        
        Fractions[] coefficientsFracArray = this.backsubstitute();
        
        
        int[] coeffArray = new int[coefficientsFracArray.length];
        for(int i = 0; i < coefficientsFracArray.length; i++){
            coeffArray[i] = coefficientsFracArray[i].getNumeratorInInt();
        }
        
        String balancedEq = "";
        
        for(int i = 0; i < coefficientsFracArray.length; i++){
            this.equationTerms[i] = coeffArray[i] + " " + this.equationTerms[i];
        }
        
        
        for(int i = 0; i < this.equationTerms.length; i++){
            if(i < this.productBegins - 1){
                balancedEq = balancedEq + this.equationTerms[i] + " + ";
            }
            else if(i == this.productBegins - 1){
                balancedEq = balancedEq + this.equationTerms[i] + " = ";
            }
            else if(i >= this.productBegins && i < this.equationTerms.length - 1){
                balancedEq = balancedEq + this.equationTerms[i] + " + ";
            }
            else if(i == this.equationTerms.length - 1){
                balancedEq = balancedEq + this.equationTerms[i];
            }
        }
        
        
        return balancedEq;
    }
    
    public int getNextNonZeroRow(int rowIndex){
        
        int index = rowIndex;
        
        if(this.matrixArray[rowIndex][rowIndex].toString().compareTo("0/1") == 0){
            for(int i = rowIndex + 1; i < this.matrixArray.length; i++){
                if(this.matrixArray[i][rowIndex].toString().compareTo("0/1") != 0){
                    index = i;
                }
            }
        }
        
        return index;
    }
    
    public void multiplyAndAdd(int row){
        
        Fractions x = new Fractions(this.matrixArray[row][row].toString());
        
        ArrayList<Fractions> nullValueStore = new ArrayList<>();
        ArrayList<Fractions> mOverX = new ArrayList<>();
        
        for(int i = row + 1; i < this.matrixArray.length; i++){
            mOverX.add(new Fractions(this.matrixArray[i][row].toString()).divide(x));
            if(mOverX.get(mOverX.size() - 1).toDouble() < 0){
                String[] splitString = (mOverX.get(mOverX.size() - 1).toString()).split("/");
                int num = Integer.parseInt(splitString[0]);
                int denom = Integer.parseInt(splitString[1]);
                
                num = -num;
                
                nullValueStore.add(new Fractions(num + "/" + denom));
            }
            else{
                nullValueStore.add(new Fractions("-" + (mOverX.get(mOverX.size() - 1)).toString()));
            }
            
            for(int j = 0; j < this.matrixArray[i].length; j++){
                this.matrixArray[i][j].addV(this.matrixArray[row][j].multiply(nullValueStore.get(nullValueStore.size() - 1)));
            }
        }
    }
    
    public void simplify(){
        /*modified from matlab*/
        ArrayList<Fractions> leadingNumberStore = new ArrayList<>();
        ArrayList<Fractions> currentNumberStore = new ArrayList<>();
        
        for(int i = 0; i < this.matrixArray.length - 1; i++){
            leadingNumberStore.add(new Fractions(this.matrixArray[i][i].toString()));
            for(int j = 0; j < this.matrixArray[i].length; j++){
                currentNumberStore.add(new Fractions(this.matrixArray[i][j].toString()));
                String result = (currentNumberStore.get(currentNumberStore.size() - 1).divide(leadingNumberStore.get(leadingNumberStore.size() - 1))).toString();
                this.matrixArray[i][j] = new Fractions(result);
            }
        }
        
        for(int i = 0; i < this.matrixArray.length - 1; i++){
            for(int j = 0; j < this.matrixArray[i].length; j++){
                this.matrixArray[i][j] = new Fractions(Fractions.simplify(this.matrixArray[i][j]));
            }
        }
    }
    
    public void switchIfNecessary(int row){
         int nextIndex = this.getNextNonZeroRow(row);
         Fractions[] tempArray = new Fractions[this.matrixArray[row].length];
         
         if(nextIndex != row){
            for(int i = 0; i < this.matrixArray[row].length; i++){
                tempArray[i] = new Fractions(this.matrixArray[row][i].toString());
            }
            for(int i = 0; i < this.matrixArray[row].length; i++){
                this.matrixArray[row][i] = new Fractions(this.matrixArray[nextIndex][i].toString());
            }
            for(int i = 0; i < this.matrixArray[row].length; i++){
                this.matrixArray[nextIndex][i] = new Fractions(tempArray[i].toString());
            }
        }
    }
    
    public Fractions[] backsubstitute(){
        Fractions[] fractionsArray = new Fractions[this.matrixArray.length];
        for(int i = 0; i < this.matrixArray.length; i++){
            fractionsArray[i] = new Fractions("0/1");
        }
        
        fractionsArray[this.matrixArray.length - 1] = new Fractions("1/1");
        ArrayList<Fractions> negVersStore = new ArrayList<>();
        ArrayList<Fractions> resultStore = new ArrayList<>();
        
        for(int i = fractionsArray.length - 2; i >= 0; i--){
            for(int j = this.matrixArray.length - 1; j >= i + 1; j--){
                String[] splitString = this.matrixArray[i][j].toString().split("/");
                
                int num = Integer.parseInt(splitString[0]);
                int denom = Integer.parseInt(splitString[1]);
                
                num = -num;
                
                negVersStore.add(new Fractions(num + "/" + denom));
                
                resultStore.add(fractionsArray[i].add(negVersStore.get(negVersStore.size() - 1).multiply(fractionsArray[j])));
                
                fractionsArray[i] = new Fractions(resultStore.get(resultStore.size() - 1).toString());
            }
        }
        
        int[] arrayOfDenoms = new int[fractionsArray.length];
        
        for(int i = 0; i < fractionsArray.length; i++){
            arrayOfDenoms[i] = fractionsArray[i].getDenominatorInInt();
        }
        
        int lcm = Fractions.lcm(arrayOfDenoms);
        
        for(int i = 0; i < fractionsArray.length; i++){
            fractionsArray[i] = fractionsArray[i].multiply(new Fractions(lcm + "/1"));
        }
        
        return fractionsArray;
    }
    
}
