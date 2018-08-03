package com.company;

public class RentalRecord {

    DateTime rentDate,estimateReturnDate,actualReturnDate;
    int rentalFee;
    int lateFee;

    public String recordId;
    RentalRecord(String propertyId, String custId, int rentDay, int rentMonth, int rentYear, int forNumberOfDays){
        //takes parameters from above sets the day property was rented
        this.rentDate = new DateTime(rentDay,rentMonth,rentYear);

        //estimated return date
        this.estimateReturnDate = new DateTime(rentDate, forNumberOfDays);

        //actual return date
        DateTime actualReturnDate = new DateTime(0,0,0);

        this.recordId = propertyId+"_"+custId+"_"+rentDate.getEightDigitDate();
    }


    public String toString(){
        String returnString = this.recordId+":"+this.rentDate.getFormattedDate()+":"+this.estimateReturnDate.getFormattedDate()+":"+this.actualReturnDate+":"+this.rentalFee+":"+this.lateFee;
        return returnString;
    }


}
