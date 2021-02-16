/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeprojecttestlimitingreagent;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Catherine
 */
public class PeriodicTable {
    String[][] ptableRef;
    
    public PeriodicTable(){  
          ptableRef = PeriodicTable.readFile();
    }
    public static String[][] readFile (){
        File sourceFile = new File (".\\ptable.txt");
        String[][] fileContent = new String[119][28];
        if(!sourceFile.exists()){
            System.out.println("Source file does not exist");
            System.exit(1);
        }
        try(
            Scanner fileScanner = new Scanner(sourceFile);
        ){  
            int i = 0;
            while(fileScanner.hasNext()){    
                String s1 = fileScanner.nextLine();                    
                String[] temp = s1.split(",");
                for(int j = 0; j<temp.length;j++){
                    fileContent[i][j]=temp[j];
                }
                i++;
            }
        }
        catch(Exception ex){
            System.out.println("File not found3");
            ex.printStackTrace();
        }   
        
        return fileContent;
    }
    public String[][] getPeriodicTable(){
        return ptableRef;
    }
}
