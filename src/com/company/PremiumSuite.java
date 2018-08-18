package com.company;

public class PremiumSuite extends RentalProperty{


    PremiumSuite(String propertyId,String streetNumber, String streetName, String suburbName, String propertyStatus){
        super(("S_"+propertyId), streetNumber, streetName, suburbName, propertyStatus);
        this.propertyType = "Premium";
        this.noOfBedrooms = 3;
        this.dailyRate = 554;
        this.setPropertyStatus("Available")

    }



    public boolean checkRentingConditions(DateTime rentDate, int numOfRentDays){
        if(!this.getPropertyStatus().toLowerCase().equals("available")){
            return false;
        }
        else{
            return true;
        }
    }
}
