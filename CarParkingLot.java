/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author coarpder
 */
public class CarParkingLot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String inputFile="/Users/coarpder/Desktop/input1.txt";
        String outputFile="/Users/coarpder/Desktop/output.txt";
        
        ArrayList<String> parkingCommands=CarFileReader.readFile(inputFile);
        ArrayList<String> finalOutput=CarInputCommands.inputCommands(parkingCommands);
        
        CarFileWriter.writeFile(outputFile, finalOutput);
    }
}