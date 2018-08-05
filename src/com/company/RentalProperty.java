package com.company;

public abstract class RentalProperty extends  FlexiRentSystem {

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

    RentalProperty(String propertyId, String streetNumber, String streetName, String propertyStatus){
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.propertyStatus = propertyStatus;

    }

}