/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Molecule(String molecule){ 
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
    public void setMoleCount(){        
        if(Character.isDigit(molecule.charAt(0))){
            moleCount = Integer.parseInt(molecule.substring(0,1));  
            rawMolecule = molecule.substring(1);
        }else{
            moleCount = 1;
            rawMolecule = molecule;
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
    public void setAtoms(PeriodicTable periodicTable){
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
//        System.out.println("Enter Actual Mole Count:");
//        actualMoleCount = input.nextDouble();
    }
    public Atom[] getAtoms(){
        return atomsArray;
    }
    public static int runMoles(Molecule[] reactantMolecules, Molecule[] resultMolecules) {  
        int limitingReagentIndex;
        double[] moleRatio = new double[reactantMolecules.length];
        for (int i = 0; i<reactantMolecules.length ; i++){
            moleRatio[i] = reactantMolecules[i].getActualMoleCount()/reactantMolecules[i].getMoleCount();
        }
        double temp = moleRatio[0];
        int tempIndex = 0;
        for(int i = 1; i< moleRatio.length; i++){
            if(i==0){
                temp = moleRatio[i];
                tempIndex = i;
            }else{
                if(temp < moleRatio[i]){
                    temp = moleRatio[i];
                    tempIndex = i;
                }
            }            
        }
        limitingReagentIndex = tempIndex;
        return limitingReagentIndex;
    }
}
