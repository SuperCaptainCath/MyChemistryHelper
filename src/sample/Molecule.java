
package sample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Catherine
 */
public class Molecule {
    int moleCount;
    double mass;
    double actualMoleCount;
    String molecule;
    String rawMolecule;
    Atom[] atomsArray;
    Scanner input = new Scanner(System.in);
    
    public Molecule(String molecule){                           //constructor
        this.molecule = molecule;      
        setMoleCount();
    }
    public Molecule(){ 
    }    
    public void setRawMolecule(String rawMolecule){
        this.rawMolecule = rawMolecule;
    }
    public String getRawMolecule(){
        return rawMolecule;
    }
    public void setMolecule(String molecule){
        this.molecule = molecule;     
        setMoleCount();
    }
    public String getMolecule(){
        return molecule;
    }
    public int getMoleCount(){
        return moleCount;
    }   
    public void setMoleCount(){                                         //set molar ratio
        int digitCheckIndex=0;
        if(!Character.isDigit(molecule.charAt(0))){
            moleCount = 1;
            rawMolecule = molecule;
        }else{
            for (int i = 0; i<molecule.length(); i++){
                if(!Character.isDigit(molecule.charAt(i))){
                    moleCount = Integer.parseInt(molecule.substring(0,i));  
                    rawMolecule = molecule.substring(i);
                    break;
                }
            }
        }
    }
    public void setMoleCount(int moleCount){      
         this.moleCount = moleCount;
    }
    public void setActualMoleCount(double actualMoleCount){
        this.actualMoleCount = actualMoleCount;
    }
    public double getActualMoleCount(){
        return actualMoleCount;
    }
    public void setActualMass(double mass){
        this.mass = mass;
    }
    public double getMass(){
        return mass;
    }
    public void setAtoms(PeriodicTable periodicTable){                              //sets atom objects
        ArrayList<Atom> atomArrayList = new ArrayList<Atom>();
        ArrayList<Integer> atomIndex = new ArrayList<Integer>();
        for(int i = 0; i<rawMolecule.length(); i++){
            char chTemp=rawMolecule.charAt(i);
            if(Character.isUpperCase(chTemp)){
                atomIndex.add(i);
            }
        }        
        if(atomIndex.size()>1){
            for(int i = 0; i<=atomIndex.size()-1; i++){            
                if (i<atomIndex.size()-1){
                    atomArrayList.add(new Atom(rawMolecule.substring(atomIndex.get(i),atomIndex.get(i+1)),periodicTable));
                }else{
                    atomArrayList.add(new Atom(rawMolecule.substring(atomIndex.get(i)),periodicTable));
                }                
            }
        }else{
            atomArrayList.add(new Atom(rawMolecule,periodicTable));
        }
        atomsArray = new Atom[atomArrayList.size()];
        for(int i = 0; i<atomArrayList.size(); i++){
            atomsArray[i] = atomArrayList.get(i);
        }
    }
    public Atom[] getAtoms(){
        return atomsArray;
    }
    public static int runMoles(Molecule[] reactantMolecules, Molecule[] resultMolecules) {  //This finds the limiting reagent!
        int limitingReagentIndex;
        double[] moleRatio = new double[reactantMolecules.length];
        for (int i = 0; i<reactantMolecules.length ; i++){
            moleRatio[i] = reactantMolecules[i].getActualMoleCount()/reactantMolecules[i].getMoleCount(); //ratio of what we have vs what we use
        }
        double temp = moleRatio[0];
        limitingReagentIndex = 0;
        for(int i = 1; i< moleRatio.length; i++){   //Finds which molecule is the most used up, aka what runs out first, aka limiting reagent!  
            if(temp > moleRatio[i]){
                temp = moleRatio[i];
                limitingReagentIndex = i;
            }                      
        }
        return limitingReagentIndex;
    }
    public static void runMass(Molecule[] reactantMolecules, double[] massMolesList) {  //finds the actual mole count based on mass
        double molarMass = 0;
        
        for(int i=0; i<reactantMolecules.length; i++) {
            reactantMolecules[i].setActualMass(massMolesList[i]);
            molarMass=0;
            for(int j=0; j<reactantMolecules[i].atomsArray.length; j++){ //cross product (but code)
                molarMass += reactantMolecules[i].atomsArray[j].atomicMass *reactantMolecules[i].atomsArray[j].atomCount;
            }
            reactantMolecules[i].setActualMoleCount(massMolesList[i]/molarMass);
        }    
    }
}
