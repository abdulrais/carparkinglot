/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkinglot;

/**
 *
 * @author coarpder
 */
public class Car {
    
    private String registrationNo;
    private String color;
    private int slotNumber;

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Car(String registrationNo, String color, int slotNumber) {
        this.registrationNo = registrationNo;
        this.color = color;
        this.slotNumber = slotNumber;
    }
    
}
