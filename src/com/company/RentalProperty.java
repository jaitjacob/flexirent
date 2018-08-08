package com.company;

public abstract class RentalProperty {

    String propertyId;
    String streetNumber;
    String streetName;
    String suburbName;
    int noOfBedrooms;
    String propertyType;
    String propertyStatus;
    RentalRecords[] recentRecords = new RentalRecords[10];

    //constructor of this class to add property
    RentalProperty(String propertyId, String streetNumber, String streetName, String suburbName, String propertyStatus){
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburbName = suburbName;
        this.propertyStatus = propertyStatus;

    }


    //rent method adds the rental record after confirming that the property can be rented or no

    //return property


    //perform maintenance

    //check renting conditions checks the day of the week and ensures whether the property can be rented or not





}
