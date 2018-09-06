package com.company;
import java.util.Date;

public abstract class RentalProperty {

    private String propertyId;
    private String streetNumber;
    private String streetName;
    private String suburbName;
    int noOfBedrooms;
    String propertyType;
    private String propertyStatus;
    private double dailyRate;


    public static int noOfRentalRecords = 0;
    public RentalRecords[] recentRecords = new RentalRecords[10];

    //constructor of this class to add property
    RentalProperty(String propertyId, String streetNumber, String streetName, String suburbName) {
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

    public String getPropertyId() {
        return propertyId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburbName() {
        return suburbName;
    }

//    public String getPropertyDetails() {
//        String returnString = "\n---------\nProperty ID:" + getPropertyId() + "\n" + "Street number: " + getStreetNumber() + "\n" + "Street name: " + getStreetName() + "\n" + "Suburb Name: " + getSuburbName() + "\n" + "Property status: " + getPropertyStatus() +"\n";
//        returnString+="\nRental Records\n";
//        if(noOfRentalRecords==0){
//            returnString+="**NO RENTAL RECORD YET**";
//        }else if(noOfRentalRecords>0){
//            for(int i=0;i<noOfRentalRecords;i++){
//            returnString+=recentRecords[i].getDetails();
//            }
//        }
//        return returnString;
//    }

    public double getDailyRate(){
        return dailyRate;
    }


    //setters
    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
    public void setDailyRate(double dailyRate) {this.dailyRate = dailyRate;};


    public boolean isAvailable() {
        if (propertyStatus.equalsIgnoreCase("available"))
            return true;

        return false;
    }


    //ABSTRACT METHODS THAT THE SUBCLASSES NEED TO IMPLEMENT NEED TO GO DOWN HERE. LOOK BELOW.
    //The following methods can be called on any object of type Apartment or Premium Suite and each of the object have their own way of implementing it hence, adding them as abstract.
    public abstract boolean rentingconditions(DateTime rentDate, int numOfRentDays);
    public abstract String getPropertyDetails();




    public boolean rent(String customerId, DateTime rentDate, int numOfRentDays) {
        //first lets check if the property is Available or not.
        if (!rentingconditions(rentDate, numOfRentDays)) {
            System.err.print("Renting condition not satisfied. try again.");
            return false;
        }

        if(noOfRentalRecords == 0){
            recentRecords[0] = new RentalRecords(getPropertyId(),customerId,rentDate,numOfRentDays);
            noOfRentalRecords++;
            System.err.print("Rental record generated.");
            this.setPropertyStatus("Rented");
            return true;
        }
        else {
            System.arraycopy(recentRecords,0,recentRecords,1, noOfRentalRecords);
            recentRecords[0] = new RentalRecords(getPropertyId(),customerId,rentDate,numOfRentDays);
            System.err.print("Rental record generated.");
            this.setPropertyStatus("Rented");

            if (noOfRentalRecords != 10) noOfRentalRecords++;

            return true;
        }

    }



    public boolean returnProperty(DateTime actualReturnDate){

        if(DateTime.diffDays(actualReturnDate,recentRecords[0].getRentDate())<0){
            System.err.print("Property cannot be returned prior to the rental date.");
            return false;
        }


        if (DateTime.diffDays(recentRecords[0].getEstimatedReturnDate(), actualReturnDate) <= 0) {
            //the following is just to understand what the program is interpreting. Could be removed if you want less verbose.
            if (DateTime.diffDays(recentRecords[0].getEstimatedReturnDate(), actualReturnDate) < 0) {
                recentRecords[0].setActualReturnDate(actualReturnDate);
                System.err.print("Property returned!!");
                double calculatedRent = calculateRentalFee(DateTime.diffDays(actualReturnDate,recentRecords[0].getRentDate()),this.dailyRate);
                recentRecords[0].setRentalFee(calculatedRent);
                recentRecords[0].setLateFee(0);
                this.setPropertyStatus("available");
            }
            else if (DateTime.diffDays(recentRecords[0].getEstimatedReturnDate(), actualReturnDate) == 0) {
                recentRecords[0].setActualReturnDate(actualReturnDate);
                System.err.print("Property returned!");
                double calculatedRent = calculateRentalFee(DateTime.diffDays(actualReturnDate,recentRecords[0].getRentDate()),this.dailyRate);
                recentRecords[0].setRentalFee(calculatedRent);
                recentRecords[0].setLateFee(0);
                this.setPropertyStatus("available");
            }
        }

        if (DateTime.diffDays(actualReturnDate,recentRecords[0].getEstimatedReturnDate()) > 0) {
            recentRecords[0].setActualReturnDate(actualReturnDate);
            //actual return was later than expected.
            int noOfDaysRented;
            noOfDaysRented = DateTime.diffDays(actualReturnDate, recentRecords[0].getRentDate());
            calculateRentalFee(noOfDaysRented, dailyRate);
            //late fee has to be calculated.
            int noOfLateDays;
            noOfLateDays = DateTime.diffDays(recentRecords[0].getEstimatedReturnDate(), actualReturnDate);
            calculateLateFee(noOfLateDays, dailyRate);
            System.err.print("Late, but property returned!");
            return true;
        }

    return false;
    }


    //calculate rental fee
    public double calculateRentalFee(int noOfDaysRented, double dailyRate) {
        //rentalFee calculated for the actual number of days stayed.
        double calculatedRent = dailyRate * noOfDaysRented;
        return calculatedRent;
    }

    //calculate late fee
    public void calculateLateFee(int noOfLateDays, double dailyRate) {

        if (recentRecords[0].getRecordId().charAt(0)=='a' || recentRecords[0].getRecordId().charAt(0)=='A') {
            //record ID would start with A for Apartment.
            double lateFee = noOfLateDays * (dailyRate * 1.15);
            recentRecords[0].setLateFee(lateFee);
        }

        if (recentRecords[0].getRecordId().charAt(0)=='p' || recentRecords[0].getRecordId().charAt(0)=='P') {
            //record ID would start with P for Premium suite.
            //lateFee = noOfLateDays * dailyRate;
            double lateFee = noOfLateDays * (dailyRate * 1.15);
            recentRecords[0].setLateFee(lateFee);
        }

    }



}