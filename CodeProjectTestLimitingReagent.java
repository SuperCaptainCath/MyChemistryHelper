/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeprojecttestlimitingreagent;
import java.util.*;
/**
 *
 * @author Catherine
 */
public class CodeProjectTestLimitingReagent {
//2Fe2O3+3CO=2Fe+3CO2
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);        
        PeriodicTable periodicTable = new PeriodicTable();
//        String test = "109,Meitnerium,Mt,268,159,109,109,7,9,artificial,yes,,yes,,,Transactinide,,,,3.50E+01,,,,\"GSI, Darmstadt, West Germany\",1982,,7,";
//        String [] testSplit = test.split(",");     
//        for (int i = 0; i<testSplit.length; i++){
//            System.out.println(i + " "+ testSplit[i]);
//        }
//        String str = "2Fe2O3 + 3CO + 4C = 2Fe + 3CO2 + 4C"; 
//        String str = "CaCO3 = CaO + CO2";
        String str = "2K + Br2 = KBr";
        String[] equalSplit = str.split("\\ = ", 20); 
        String[] reactants;
        String[] results;
        if(equalSplit[0].contains("+")){
            reactants = equalSplit[0].replaceAll("\\+", "").split("  "); 
        }else{
            reactants = new String[1];
            reactants[0] = equalSplit[0];
        }
        if(equalSplit[1].contains("+")){
            results = equalSplit[1].replaceAll("\\+", "").split("  "); 
        }else{
            results = new String[1];
            results[0] = equalSplit[1];
        }
        
        for (String a : equalSplit) 
            System.out.println(a); 
        System.out.println("reactants"); 
        for (String a : reactants) 
            System.out.println(a); 
        System.out.println("results");         
        for (String a : results) 
            System.out.println(a); 
        
        Molecule[] reactantMolecules = new Molecule[reactants.length];
        for (int i=0; i<reactantMolecules.length; i++) {
            reactantMolecules[i]=new Molecule(reactants[i]);
            reactantMolecules[i].setAtoms(periodicTable);
        }
        
        Molecule[] resultMolecules = new Molecule[results.length];
        for (int i=0; i<resultMolecules.length; i++) {
            resultMolecules[i]=new Molecule(results[i]);
            resultMolecules[i].setAtoms(periodicTable);
        }
        
        System.out.println("reactantMolecules"); 
        for (int i=0; i<reactantMolecules.length; i++) {
            System.out.println("mole count    " + reactantMolecules[i].getMoleCount());            
            System.out.println("actual mole count    " + reactantMolecules[i].getActualMoleCount());
            for(int j=0; j<reactantMolecules[i].getAtoms().length; j++) {
                System.out.print(reactantMolecules[i].getAtoms()[j].getSymbol()+ "  "); 
                System.out.print(reactantMolecules[i].getAtoms()[j].getAtomicMass()+ "  "); 
                System.out.println(reactantMolecules[i].getAtoms()[j].getAtomCount()); 
            }
        }
        
        System.out.println("resultMolecules"); 
        for (int i=0; i<resultMolecules.length; i++) {
            System.out.println("mole count    " + resultMolecules[i].getMoleCount());
            System.out.println("actual mole count    " + resultMolecules[i].getActualMoleCount());
            for(int j=0; j<resultMolecules[i].getAtoms().length; j++) {
                System.out.print(resultMolecules[i].getAtoms()[j].getSymbol()+ "  "); 
                System.out.print(resultMolecules[i].getAtoms()[j].getAtomicMass()+ "  "); 
                System.out.println(resultMolecules[i].getAtoms()[j].getAtomCount()); 
            }
        }
        System.out.println("Input run option. \n   1: with moles\n   2: with mass");
        int option = input.nextInt();
        
        switch(option){
            case 1:
                Moles equationMoles = new Moles();
                equationMoles.run(reactantMolecules, resultMolecules);
                System.out.println("The limiting reagent is : " + reactantMolecules[equationMoles.getLimitingReagentIndex()].getRawMolecule() + ".");
                break;
            case 2:
                Mass equationMass = new Mass();
                equationMass.run(reactantMolecules, resultMolecules);
                break;
        }
    } 
    
}
