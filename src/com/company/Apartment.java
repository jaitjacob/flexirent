package com.company;
import java.util.Date;

public class Apartment extends RentalProperty {


    Apartment(String propertyId,String streetNumber, String streetName, String suburbName, int noOfBedrooms){
        super(propertyId, streetNumber, streetName, suburbName);
        this.propertyType = "Apartment";
        this.noOfBedrooms = noOfBedrooms;

        //assigning daily rate based on the number of Bedrooms
            if (noOfBedrooms == 3) {
                setDailyRate(319);
            } else if (noOfBedrooms == 2) {
                setDailyRate(210);
            } else if (noOfBedrooms == 1) {
                setDailyRate(143);
            }
        }


    public boolean checkRentingconditions(DateTime rentDate, int numOfRentDays){
        if(this.getPropertyStatus().toLowerCase().equals("rented")){
            return false;
        }
        else if(this.getPropertyStatus().toLowerCase().equals("available")){
            //if it is available then check if it booked in such a way that Each Apartment can be rented for:
            //a minimum of 2 days if the rental day is between Sunday and Thursday inclusively
            //or a minimum of 3 days if the rental day is Friday or Saturday
            //and a maximum of 28 days
            Date day = new Date(rentDate.getTime());
            String dayOfWeek = (day.toString().split(" ")[0]);

            if(dayOfWeek.toLowerCase().equals("sunday")||
                    dayOfWeek.toLowerCase().equals("monday")||
                    dayOfWeek.toLowerCase().equals("tuesday")||
                    dayOfWeek.toLowerCase().equals("wednesday")||
                    dayOfWeek.toLowerCase().equals("thursday")){
                if(numOfRentDays>2){
                    return true;
                }
                else if(numOfRentDays<2){
                    return false;
                }
                else if(dayOfWeek.toLowerCase().equals("saturday")
                        ||dayOfWeek.toLowerCase().equals("friday")){
                    if(numOfRentDays>3){
                        return true;
                    }
                    else if(numOfRentDays<3){
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

}
