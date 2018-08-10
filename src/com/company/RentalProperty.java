package com.company;

public abstract class RentalProperty {

    private String propertyId;
    private String streetNumber;
    private String streetName;
    private String suburbName;
    int noOfBedrooms;
    String propertyType;
    private String propertyStatus;
    double dailyRate;
    private RentalRecords[] recentRecords = new RentalRecords[10];

    //constructor of this class to add property
    RentalProperty(String propertyId, String streetNumber, String streetName, String suburbName, String propertyStatus){
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburbName = suburbName;
        this.propertyStatus = propertyStatus;
    }



    //getters
    public String getPropertyStatus() {
        return propertyStatus;
    }


    //The following methods can be called on any object of type Apartment or Premium Suite and each of the object have their own way of implementing it hence, adding them as abstract.
    public abstract boolean rent(String customerId, DateTime rentDate, int numOfRentDay);

    //The following method is called when a property is being returned.
    public boolean returnProperty(DateTime returnDate){
        
        return true;

    }





}
