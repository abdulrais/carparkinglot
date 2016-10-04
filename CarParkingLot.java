/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author coarpder
 */
public class CarParkingLot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        // Using File
        Scanner input=new Scanner(System.in);

        System.out.println("Please Enter Input File Path:");
        String inputFile=input.nextLine();

        System.out.println("\nPlease Enter Output File Path:");
        String outputFile=input.nextLine();
        
        ArrayList<String> parkingCommands=CarFileReader.readFile(inputFile);
        ArrayList<String> finalOutput=CarInputCommands.inputCommands(parkingCommands);
        
        CarFileWriter.writeFile(outputFile, finalOutput);  
        
        // Using User interactive commands
        System.out.println("Please Enter Commands For Parking Lot: \n");
        int slot=0;
        String commands=input.nextLine();
        
        String[] inputCommand=commands.split(" ");
        String line2="create_parking_lot";
        if(line2.equals(inputCommand[0])){
            slot+=Integer.parseInt(inputCommand[1]);
        }
        
        while(commands!=null && !commands.equals("")){
            
            String output=CarInputCommands.inputCommands(commands, slot);
            System.out.println(output);
            System.out.print("\n");
            
            commands=input.nextLine();
        }
    }
}