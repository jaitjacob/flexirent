package com.company;

public class PremiumSuite extends RentalProperty{


    PremiumSuite(String propertyId,String streetNumber, String streetName, String suburbName){
        super(propertyId, streetNumber, streetName, suburbName);
        this.propertyType = "Premium";
        this.noOfBedrooms = 3;
        this.dailyRate = 554;

    }

    @Override
    public boolean checkRentingconditions(DateTime rentDate, int numOfRentDays) {
        return false;
    }


}
