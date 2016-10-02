/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author coarpder
 */
public class CarInputCommands {
    public static ArrayList<String> inputCommands(ArrayList<String> parkingCommands){
        ParkingOperations operations=new ParkingOperations();
        ArrayList<Car> carsParkingInfo=new ArrayList<Car>();
        ArrayList<String> output=new ArrayList<>();
        ArrayList<String> freeSlot=new ArrayList<>();
        
        int i=1,slot=0;
        String line2,line3,line4,line7,line9,line10,line11,line12,line13;
        line2="create_parking_lot";
        line3="park";
        line4="leave";
        line7="status";
        line9="Sorry, parking lot is full";
        line10="slot_numbers_for_cars_with_colour";
        line11="slot_number_for_registration_number";
        line12="registration_numbers_for_cars_with_colour";
        line13="registration_number_for_car_with_slot_number";
        
        
        for(String parking: parkingCommands){
            String[] commands=parking.split(" ");
            if(line2.equals(commands[0])){
                    String parkingLot=operations.parkingLotCreation(commands[1]);
                    slot+=Integer.parseInt(commands[1]);
                    output.add(parkingLot);
                }
                else if(line3.equals(commands[0])){
                    if((i-freeSlot.size())>slot){
                        output.add(line9);
                    }
                    else{
                        if(freeSlot.size()==0){
                            Car carInfo= new Car(commands[1], commands[2], i);
                            carsParkingInfo.add(carInfo);
                            String allocateSlot=operations.allocateSlotNumber(i);
                            output.add(allocateSlot);
                            i++;
                        }
                        else{
                            for(String slotNo : freeSlot){
                                Car carInfo= new Car(commands[1], commands[2], Integer.parseInt(slotNo));
                                carsParkingInfo.add(carInfo);
                                String allocateSlot=operations.allocateSlotNumber(Integer.parseInt(slotNo));
                                output.add(allocateSlot);
                                freeSlot.remove(freeSlot.indexOf(slotNo));
                                break;
                            }
                        } 
                    }
                }
                else if(line4.equals(commands[0])){
                    String leaveSlot=operations.leaveSlot(commands[1],carsParkingInfo);
                    output.add(leaveSlot);
                    for(Car info: carsParkingInfo){
                        if(info.getSlotNumber()==Integer.parseInt(commands[1])){
                            carsParkingInfo.remove(carsParkingInfo.indexOf(info));
                            freeSlot.add(commands[1]);
                            break;
                        }
                    } 
                }
                else if(line7.equals(commands[0])){
                    String parkingStatus=operations.status(carsParkingInfo);
                    output.add(parkingStatus);
                }
                else if(line10.equals(commands[0])){
                    String slotNumbersForCars=operations.slotNumbersForCarWithColor(commands[1], carsParkingInfo);
                    output.add(slotNumbersForCars);
                }
                else if(line11.equals(commands[0])){
                    String slotNumber=operations.slotNumberForRegistrationNo(commands[1], carsParkingInfo);
                    output.add(slotNumber);
                }
                else if(line12.equals(commands[0])){
                    String carswithSameColor=operations.registrationNumberForCarsWithSameColor(commands[1],carsParkingInfo);
                    output.add(carswithSameColor);
                }
                else if(line13.equals(commands[0])){
                    String registrationNoForCar=operations.registrationNumberForCarWithSlotNumber(Integer.parseInt(commands[1]), carsParkingInfo);
                    output.add(registrationNoForCar);
                }
        }
        return output;
    }
}
