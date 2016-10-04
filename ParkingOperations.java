/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author coarpder
 */
public class ParkingOperations {
    
    String parkingLotCreation(String slot){
        String parkingLot="Created a parking lot with "+slot+" slots";
        return parkingLot;
    }
    
    String allocateSlotNumber(int slotNum){
        String slotInfo="Allocated slot number: "+Integer.toString(slotNum);
        return slotInfo;
    }
    
    String leaveSlot(String slotNumber, ArrayList<Car> parkingInfo){
        for(Car info: parkingInfo){
            if(info.getSlotNumber()==Integer.parseInt(slotNumber)){
                String slotFree="Slot number "+slotNumber+" is free";
                return slotFree;
            }
        }
        return "Not Found";
    }
    
    String status(ArrayList<Car> parkingInfo){
        StringBuilder parkingStatus = new StringBuilder();
        parkingStatus.append("Slot No. Registration No. Colour"+ "\n");
        for(Car info: parkingInfo){
            parkingStatus.append(Integer.toString(info.getSlotNumber())+"        "+info.getRegistrationNo()+"       "+info.getColor()+"\n");
        }
        if(parkingStatus.toString()!=null && !parkingStatus.toString().equals(""))
            return parkingStatus.toString();
        
        return "Not Found";
    }
    
    String slotNumbersForCarWithColor(String color, ArrayList<Car> parkingInfo){
        StringBuilder carSlotNumbers = new StringBuilder();
        for(Car info: parkingInfo){
            if(info.getColor().equals(color)){
                carSlotNumbers.append(Integer.toString(info.getSlotNumber()));
                carSlotNumbers.append(",");
            }
        }
        carSlotNumbers.delete(carSlotNumbers.lastIndexOf(","), carSlotNumbers.length());
        if(carSlotNumbers.toString()!=null && !carSlotNumbers.toString().equals(""))
            return carSlotNumbers.toString();
        
        return "Not Found";
    }
    
    String slotNumberForRegistrationNo(String registrationNo, ArrayList<Car> parkingInfo){
        String slotNumber="";
        for(Car info: parkingInfo){
            if(info.getRegistrationNo().equals(registrationNo)){
                slotNumber=Integer.toString(info.getSlotNumber());
                return slotNumber;
            }
        }
        return "Not Found";
    }
    
    String registrationNumberForCarsWithSameColor(String color, ArrayList<Car> parkingInfo){
        StringBuilder carWithSameColor = new StringBuilder();
        for(Car info: parkingInfo){
            if(info.getColor().equals(color)){
                carWithSameColor.append(info.getRegistrationNo());
                carWithSameColor.append(",");
            }
        }
        carWithSameColor.delete(carWithSameColor.lastIndexOf(","), carWithSameColor.length());
        if(carWithSameColor.toString()!=null && !carWithSameColor.toString().equals(""))
            return carWithSameColor.toString();
        
        return "Not Found";  
    }
    
    String registrationNumberForCarWithSlotNumber(int slot, ArrayList<Car> parkingInfo){
        for(Car info: parkingInfo){
            if(info.getSlotNumber()==slot){
                return info.getRegistrationNo();
            }
        }
        return "Not Found";
    }
}