package sample;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author Elliot
 */
public class elementBrowser {
    
    static String lineToSplit;
    static String[] splitLine;
        
    static double molarMass;
    static String symbol;
    static String name;
    static double atomicNumber;
    
    
    
    private elementBrowser(){
        throw new UnsupportedOperationException();
        
    }
    
    static public double getMolarMass(int index){
        try{
        File pTable = new File("table.txt");
        Scanner pTableReader = new Scanner(pTable);
        
        for(int i = 0; i < index-1; i++){
            pTableReader.nextLine();
        }
        lineToSplit = pTableReader.nextLine();
        
        splitLine = lineToSplit.split(",");                
        
    }
    catch(FileNotFoundException e){
    System.out.println("An error has occured");
    e.printStackTrace();
        
    }
        molarMass = Double.parseDouble(splitLine[3]);
        return molarMass;     
    }
    
    
    static public String getSymbol(int index){
        try{
        File pTable = new File("table.txt");
        Scanner pTableReader = new Scanner(pTable);
        
        for(int i = 0; i < index-1; i++){
            pTableReader.nextLine();
        }
        lineToSplit = pTableReader.nextLine();
        
        splitLine = lineToSplit.split(",");                
        
    }
    catch(FileNotFoundException e){
    System.out.println("An error has occured");
    e.printStackTrace();
        
    }
        symbol = splitLine[1];
        return symbol;     
    }
    
    static public String getName(int index){
        try{
        File pTable = new File("table.txt");
        Scanner pTableReader = new Scanner(pTable);
        
        for(int i = 0; i < index-1; i++){
            pTableReader.nextLine();
        }
        lineToSplit = pTableReader.nextLine();
        
        splitLine = lineToSplit.split(",");                
        
    }
    catch(FileNotFoundException e){
    System.out.println("An error has occured");
    e.printStackTrace();
        
    }
        name = splitLine[2];
        return name;     
    }
    
    static public int getAtomicNumber(int index){
        return index;
    }
    
    static public String[] displayTable(int index){
        try{
        File pTable = new File("table.txt");
        Scanner pTableReader = new Scanner(pTable);
        
        for(int i = 0; i < index-1; i++){
            pTableReader.nextLine();
        }
        lineToSplit = pTableReader.nextLine();
        
        splitLine = lineToSplit.split(",");                
        
    }
    catch(FileNotFoundException e){
    System.out.println("An error has occured");
    e.printStackTrace();
        
    }       
        return splitLine;     
    }

}               

