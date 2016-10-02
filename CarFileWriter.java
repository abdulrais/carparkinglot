/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author coarpder
 */
public class CarFileWriter {
    public static void writeFile(String fileName, ArrayList<String> output){
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(fileName);
            for(String info : output){
                fileWriter.append(info);
                fileWriter.append("\n");
            }
            System.out.println("Ouput file was created successfully...");
        } catch (Exception e) {
            System.out.println("Error in OuputFileWriter...");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileWriter...");
                e.printStackTrace();
            }
        }
    }
}
