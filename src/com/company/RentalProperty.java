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
    RentalProperty(String propertyId, String streetNumber, String streetName, String suburbName){
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburbName = suburbName;
        this.propertyStatus = "Available";
    }


    //getters
    public String getPropertyStatus() {
        return propertyStatus;
    }
    public String getPropertyId() {return propertyId;}
    public String getStreetNumber() {return streetNumber;}
    public String getStreetName() {return  streetName;}
    public String getSuburbName() {return suburbName;}

    public String getPropertyDetails(){
        return "Property ID:"+getPropertyId() +"\n"+ "Street number: "+getStreetNumber() +"\n"+ "Street name: "+getStreetName()+ "\n" +"Suburb Name: "+getSuburbName()+"\n"+"Property status: "+getPropertyStatus()+"\n-------------";
    }


    //setters
    public String setPropertyStatus(String propertyStatus){
        this.propertyStatus = propertyStatus;

        return  "";
    }


    public boolean isAvailable(){
        if(propertyStatus.toLowerCase().equals("available"))
            return true;

        return false;
    }

    public abstract boolean checkRentingconditions(DateTime rentDate, int numOfRentDays);
    //The following methods can be called on any object of type Apartment or Premium Suite and each of the object have their own way of implementing it hence, adding them as abstract.

    public boolean rent(String customerId, DateTime rentDate, int numOfRentDays){
        //first lets check if the property is Available or not.
        if(!checkRentingconditions(rentDate,numOfRentDays)){
            System.err.println("Renting condition not satisfied. try again.");
            return false;
        }




        //shift number of records available to one loaction ahead. (only until 9)


        //now after shifting location [0] is free so put in the current rental record into it.


        //call rental record constructor and add new record.


    return false;
    }

    //The following method is called when a property is being returned.
    public boolean returnProperty(DateTime returnDate){
        return true;
    }




}
