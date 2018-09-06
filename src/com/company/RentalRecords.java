package com.company;

public class RentalRecords {

    private String recordId;//propertyId_ + customerId_ + rentDate (8 digit format: ddmmyyyy)
    private DateTime rentDate;
    private DateTime estimatedReturnDate;
    private DateTime actualReturnDate = null; //a property yet to be rented and then returned is set to 0,0,0
    private double rentalFee;
    private double lateFee;

    //constructor called when the first rental record is inserted
    RentalRecords(String propertyId, String customerId, DateTime rentDate, int numOfRentDay) {
        this.recordId = "" + propertyId + "_" + customerId + "_" + rentDate.getEightDigitDate();
        this.rentDate = rentDate;
        this.estimatedReturnDate = new DateTime(rentDate, numOfRentDay);
    }



    //getters
    public DateTime getRentDate(){
        return rentDate;
    }

    public DateTime getEstimatedReturnDate(){
        return estimatedReturnDate;
    }

    public String getRecordId(){
        return recordId;
    }


    //setters
    public void setRentalFee(double rentalFee){
        this.rentalFee = rentalFee;
    }

    public void setLateFee(double lateFee){
        this.lateFee = lateFee;
    }

    public void setActualReturnDate(DateTime actualReturnDate){
        this.actualReturnDate = actualReturnDate;
    }




    //Override the public String toString() method to return a string containing the details of a rental record in the following format.
    //recordId:rentDate:estimatedReturnDate:actualReturnDate:rentalFee:lateFee
    public String toString() {
        String returnString = "";
        DateTime noneDate = new DateTime(0, 0, 0);

        returnString += recordId + ":" + rentDate.getFormattedDate() + ":" + estimatedReturnDate.getFormattedDate() + ":";

        int diff = DateTime.diffDays(noneDate, actualReturnDate);
        if (actualReturnDate==null) {
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

        if (actualReturnDate==null) {
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() + "\n";



            return returnString;

        } else {
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() + "\n" + "Actual Return Date : " + actualReturnDate.getFormattedDate() + "\n" + "Rental fee : " + this.rentalFee + "\n" + "Late Fee : " + this.lateFee + "\n\n";
            return returnString;
        }
    }



}
