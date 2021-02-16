/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeprojecttestlimitingreagent;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Catherine
 */
public class Atom extends Molecule{
    String symbol;
    int atomCount;
    String content;
    int atomicNumber;
    double atomicMass;
//    String[][] periodicTable;           
    
    public Atom(){        
    }
    public Atom(String content, PeriodicTable periodicTable){
        this.content = content;    
        setAtom(periodicTable);
    }
    //Header line
//        //AtomicNumber,Element,Symbol,AtomicMass,NumberofNeutrons,NumberofProtons,NumberofElectrons,Period,Group,Phase,Radioactive,Natural,Metal,Nonmetal,Metalloid,Type,AtomicRadius,Electronegativity,FirstIonization,Density,MeltingPoint,BoilingPoint,NumberOfIsotopes,Discoverer,Year,SpecificHeat,NumberofShells,NumberofValence
//        //header length 28
////            0 AtomicNumber            14 Metalloid
////            1 Element                 15 Type
////            2 Symbol                  16 AtomicRadius
////            3 AtomicMass              17 Electronegativity
////            4 NumberofNeutrons        18 FirstIonization
////            5 NumberofProtons         19 Density
////            6 NumberofElectrons       20 MeltingPoint
////            7 Period                  21 BoilingPoint
////            8 Group                   22 NumberOfIsotopes
////            9 Phase                   23 Discoverer
////            10 Radioactive            24 Year
////            11 Natural                25 SpecificHeat
////            12 Metal                  26 NumberofShells
////            13 Nonmetal               27 NumberofValence
    public void setAtomCount(){        
        if(Character.isDigit(content.charAt(content.length()-1))){
            atomCount = Integer.parseInt(content.substring(content.length()-1)); 
            symbol = content.substring(0,content.length()-1);
        }else{
            atomCount = 1;
            symbol = content;
        }
    }
    public void setAtom(PeriodicTable periodicTable){
        setAtomCount();
        for (int i = 0; i<periodicTable.getPeriodicTable().length; i++){
            if(symbol.equals(periodicTable.getPeriodicTable()[i][2])){ 
                atomicNumber = Integer.parseInt(periodicTable.getPeriodicTable()[i][0]);
                atomicMass = Double.parseDouble(periodicTable.getPeriodicTable()[i][3]);
            }
        }
    }    
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }
    public void setAtomCount(int atomCount){
        this.atomCount = atomCount;
    }
    public int getAtomCount(){
        return atomCount;
    }
    public void setAtomicMass(double atomicMass){
        this.atomicMass = atomicMass;
    }
    public double getAtomicMass(){
        return atomicMass;
    }
}
