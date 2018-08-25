package com.company;
import java.util.Date;

public class Apartment extends RentalProperty {


    Apartment(String propertyId, String streetNumber, String streetName, String suburbName, int noOfBedrooms) {
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


    public boolean checkRentingconditions(DateTime rentDate, int numOfRentDays) {

        if (this.getPropertyStatus().toLowerCase().equals("rented")) {
            return false;
        }

        if (this.getPropertyStatus().toLowerCase().equals("available")) {
            //if it is available then check if it booked in such a way that Each Apartment can be rented for:
            //a minimum of 2 days if the rental day is between Sunday and Thursday inclusively
            //or a minimum of 3 days if the rental day is Friday or Saturday
            //and a maximum of 28 days
            Date day = new Date(rentDate.getTime());
            String dayOfWeek = (day.toString().split(" ")[0]).toLowerCase();

            if (dayOfWeek.toLowerCase().equals("sun") || dayOfWeek.toLowerCase().equals("mon") || dayOfWeek.toLowerCase().equals("tue") || dayOfWeek.toLowerCase().equals("wed") || dayOfWeek.toLowerCase().equals("thu")) {
                if (numOfRentDays > 2 && numOfRentDays <= 28) {
                    return true;
                } else if (numOfRentDays < 2) {
                    System.err.print("Can be rented only for minimum 2 days or greater.");
                    return false;
                }
            }

            if (dayOfWeek.toLowerCase().equals("sat") || dayOfWeek.toLowerCase().equals("fri")) {
                if (numOfRentDays > 3 && numOfRentDays <= 28) {
                    return true;
                } else if (numOfRentDays < 3) {
                    System.err.print("Can be rented only for minimum 3 days or greater.");
                    return false;
                }
            }//if saturday or friday close

        }
        //end of check renting condition
        return false;

    }
}