package com.company;

public class RentalRecords {

    private String recordId;//propertyId_ + customerId_ + rentDate (8 digit format: ddmmyyyy)
    private DateTime rentDate;
    private DateTime estimatedReturnDate;
    private DateTime actualReturnDate = new DateTime(0, 0, 0); //a property yet to be rented and then returned is set to 0,0,0
    private double rentalFee;
    private double lateFee;

    //constructor called when the first rental record is inserted
    RentalRecords(String propertyId, String customerId, DateTime rentDate, int numOfRentDay) {
        this.recordId = "" + propertyId + "_" + customerId + "_" + rentDate.getEightDigitDate();
        this.rentDate = rentDate;
        this.estimatedReturnDate = new DateTime(rentDate, numOfRentDay);
    }


    //when property returned
    public boolean returnProperty(DateTime actualReturnDate, double dailyRate) {

        this.actualReturnDate = actualReturnDate;

        if (DateTime.diffDays(actualReturnDate, rentDate) < 0) {
            System.err.print("Property cannot be returned prior to the rental date.");
            return false;
        }

        if (DateTime.diffDays(estimatedReturnDate, actualReturnDate) <= 0) {
            //the following is just to understand what the program is interpreting. Could be removed if you want less verbose.
            if (DateTime.diffDays(estimatedReturnDate, actualReturnDate) < 0) {
                System.err.print("Actual return seems to be earlier than the promised return day.");
            } else if (DateTime.diffDays(estimatedReturnDate, actualReturnDate) == 0) {
                System.err.print("Actual return seems to be on the estimated day! Perfect.");
            }


            int noOfDaysRented;
            noOfDaysRented = DateTime.diffDays(actualReturnDate, rentDate);
            calculateRentalFee(noOfDaysRented, dailyRate);
            //lateFee is zero in this case.
            this.lateFee = 0;
            return true;
        }

        if (DateTime.diffDays(estimatedReturnDate, actualReturnDate) > 0) {
            //actual return was later than expected.
            int noOfDaysRented;
            noOfDaysRented = DateTime.diffDays(actualReturnDate, rentDate);
            calculateRentalFee(noOfDaysRented, dailyRate);
            //late fee has to be calculated.
            int noOfLateDays;
            noOfLateDays = DateTime.diffDays(estimatedReturnDate, actualReturnDate);
            calculateLateFee(noOfLateDays, dailyRate);
            return true;
        }

        return false;
    }


    //Override the public String toString() method to return a string containing the details of a rental record in the following format.
    //recordId:rentDate:estimatedReturnDate:actualReturnDate:rentalFee:lateFee
    public String toString() {
        String returnString = "";
        DateTime noneDate = new DateTime(0, 0, 0);

        returnString += recordId + ":" + rentDate.getFormattedDate() + ":" + estimatedReturnDate.getFormattedDate() + ":";

        int diff = DateTime.diffDays(noneDate, actualReturnDate);
        if (diff == 0) {
            returnString += "none:none:none";
            return returnString;
        } else {
            returnString += "" + actualReturnDate.getFormattedDate() + ":" + rentalFee + ":" + lateFee;
            return returnString;
        }
    }


    //getDetails() method. This method should build a string and return that string.
    // The returned string should be formatted in a human readable form
    public String getDetails() {
        String returnString;
        DateTime noneDate = new DateTime(0, 0, 0);

        int diff = DateTime.diffDays(noneDate, actualReturnDate);

        if (diff == 0) {
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() + "\n";
            return returnString;

        } else {
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() + "\n" + "Actual Return Date : " + actualReturnDate.getFormattedDate() + "\n" + "Rental fee : " + this.rentalFee + "\n" + "Late Fee : " + this.lateFee + "\n\n";
            return returnString;
        }
    }


    //calculate rental fee
    public void calculateRentalFee(int noOfDaysRented, double dailyRate) {
        //rentalFee calculated for the actual number of days stayed.
        this.rentalFee = dailyRate * noOfDaysRented;

    }

    //calculate late fee
    public void calculateLateFee(int noOfLateDays, double dailyRate) {
        if (recordId.charAt(0) == 'a' || recordId.charAt(0) == 'A') {
            //record ID would start with A for Apartment.
            lateFee = noOfLateDays * (dailyRate * 1.15);
        }

        if (recordId.charAt(0) == 'p' || recordId.charAt(0) == 'P') {
            //record ID would start with P for Premium suite.
            lateFee = noOfLateDays * dailyRate;
        }

    }
}
