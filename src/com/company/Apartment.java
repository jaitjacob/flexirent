package com.company;
import java.util.Date;

public class Apartment extends RentalProperty {


    Apartment(String propertyId,String streetNumber, String streetName, String suburbName, String propertyStatus, int noOfBedrooms){
        super(propertyId, streetNumber, streetName, suburbName, propertyStatus);
        this.propertyType = "Apartment";
        this.noOfBedrooms = noOfBedrooms;

        //assigning daily rate based on the number of Bedrooms
            if (noOfBedrooms == 3) {
                this.dailyRate = 319;
            } else if (noOfBedrooms == 2) {
                this.dailyRate = 210;
            } else if (noOfBedrooms == 1) {
                this.dailyRate = 143;
            }
        }


    public boolean rent(String customerId, DateTime rentDate, int numOfRentDay){
        //first lets check if the property is Available or not.
        if(this.getPropertyStatus().toLowerCase().equals("rented")){
            return false;
        }
        else if(this.getPropertyStatus().toLowerCase().equals("available")){
            //if it is available then check if it booked in such a way that Each Apartment can be rented for:
            //a minimum of 2 days if the rental day is between Sunday and Thursday inclusively
            //or a minimum of 3 days if the rental day is Friday or Saturday
            //and a maximum of 28 days
            Date day = new Date(rentDate.getTime());
            String dayOfWeek = day.toString().split(" ")[0]);
            if(dayOfWeek.toLowerCase().equals("sunday")||
                    dayOfWeek.toLowerCase().equals("monday")||
                    dayOfWeek.toLowerCase().equals("tuesday")||
                    dayOfWeek.toLowerCase().equals("wednesday")||
                    dayOfWeek.toLowerCase().equals("thursday")){
                     if(numOfRentDay<2){
                     return false;
                    }
                else if(dayOfWeek.toLowerCase().equals("saturday")
                             ||dayOfWeek.toLowerCase().equals("friday")){
                    if(numOfRentDay<3){
                        return false;
                    }

                }
            }
            return true;
        }
        else {
            return false;
        }

    }


    public boolean returnProperty(DateTime actualReturnDate){
        
    }





}
