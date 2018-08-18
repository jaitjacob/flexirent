package com.company;

public class RentalRecords {

    private String recordId;//propertyId_ + customerId_ + rentDate (8 digit format: ddmmyyyy)
    private DateTime rentDate;
    private DateTime estimatedReturnDate;
    private DateTime actualReturnDate = new DateTime(0,0,0); //a property yet to be rented and then returned is set to 0,0,0
    double rentalFee;
    double lateFee;

    //constructor called when the first rental record is inserted
    RentalRecords(String propertyId, String customerId, DateTime rentDate, int numOfRentDay){
        this.recordId = ""+propertyId +"_"+customerId+"_"+rentDate.getEightDigitDate();
        this.rentDate = rentDate;
        this.estimatedReturnDate = new DateTime(rentDate,numOfRentDay);
    }


    //when property returned
    public boolean returnProperty(DateTime actualReturnDate){
        this.actualReturnDate = actualReturnDate;

        return true;

    }



    //Override the public String toString() method to return a string containing the details of a rental record in the following format.
    //recordId:rentDate:estimatedReturnDate:actualReturnDate:rentalFee:lateFee
    public String toString(){
        String returnString="";
        DateTime noneDate = new DateTime(0,0,0);

        returnString += recordId+":"+rentDate.getFormattedDate()+":"+estimatedReturnDate.getFormattedDate()+":";

        int diff = DateTime.diffDays(noneDate,actualReturnDate);
        if(diff==0){
            returnString+="none:none:none";
            return returnString;
        }
        else{
            returnString+=""+actualReturnDate.getFormattedDate()+":"+rentalFee+":"+lateFee;
            return returnString;
        }
    }



    //getDetails() method. This method should build a string and return that string.
    // The returned string should be formatted in a human readable form
    public String getDetails(){
        String returnString;
        DateTime noneDate = new DateTime(0,0,0);

        int diff = DateTime.diffDays(noneDate,actualReturnDate);

        if(diff == 0){
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() +"\n";
            return returnString;

        }else if(diff>0) {
            returnString = "\nRecord Id : " + recordId + "\n" + "Rent Date : " + rentDate.getFormattedDate() + "\n" + "Estimated Return Date : " + estimatedReturnDate.getFormattedDate() +"\n" + "Actual Return Date : " + actualReturnDate.getFormattedDate() + "\n" + "Rental fee : " + this.rentalFee + "\n" + "Late Fee : " + this.lateFee;
            return returnString;
        }

        else{
            return "Unfortunately, the details could not be printed for this property";
        }
    }




    //insert a rental record
    public boolean insertANewRecord(){

        return true;


    }

    //calculate rental fee
    //calculate late fee


}
