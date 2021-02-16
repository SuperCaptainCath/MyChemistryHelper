/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeprojecttestlimitingreagent;

import java.util.ArrayList;

/**
 *
 * @author Catherine
 */
public class Moles {
    int limitingReagentIndex;
    public Moles(){        
    }
    public void run(Molecule[] reactantMolecules, Molecule[] resultMolecules) {  
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
    }
    public void setlimitingReagentIndex(int limitingReagentIndex){
        this.limitingReagentIndex = limitingReagentIndex;
    }
    public int getLimitingReagentIndex(){
        return limitingReagentIndex;
    }
}
