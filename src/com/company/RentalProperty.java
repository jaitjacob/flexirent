package com.company;

public class RentalProperty {

    public String propertyId;
    public String streetNumber;
    public String streetName;
    public String suburbName;
    public int noOfBedrooms;
    public String propertyType;
    public String propertyStatus;
    // also need to add 10 most recent rental records below - 10 object array
    RentalRecord[] ten_recent_rental_records = new RentalRecord[10];
    //-----------------------------------------------



    RentalProperty(String propertyId, String streetNumber, String streetName, String suburbName, int noOfBedrooms, String propertyType, String propertyStatus) {
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburbName = suburbName;
        this.noOfBedrooms = noOfBedrooms;
        this.propertyType = propertyType;
        this.propertyStatus = propertyStatus;
        System.out.println("Property : " + propertyId + " added successfully");
    }



    public String isAvailable(){
        if(this.propertyStatus.equals("A")){
            return("Property available for renting.");
        }
        else if(this.propertyStatus.equals('R')){
            return("Property currently occupied. Sorry");
        }
        else if(this.propertyStatus.equals('M')){
            return("Property under maintenance, cannot be booked. Sorry");
    }
    return null;
}


}