/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author coarpder
 */
public class CarFileReader {
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException, IOException{
        BufferedReader fileReader=null;
        ArrayList<String> commands=new ArrayList<>();
        
        try{
            String line="";
            fileReader= new BufferedReader(new FileReader(fileName));
            
            while((line=fileReader.readLine())!=null){
                commands.add(line);
            }
        }catch(Exception e){
            System.out.println("Error in InputFileReader \n");
            e.printStackTrace();
        }finally{
            try{
                fileReader.close();
            }catch(IOException e){
                System.out.println("Error while closing fileReader \n");
                e.printStackTrace();
            }
        }
        return commands;
    }
}