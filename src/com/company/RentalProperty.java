package com.company;

public abstract class RentalProperty {

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





}