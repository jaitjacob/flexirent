package com.company;

public class PremiumSuite extends RentalProperty{

    private DateTime lastMaintenanceDate,nextMaintenanceDate;


    public DateTime getLastMaintenanceDate(){
        return lastMaintenanceDate;
    }

    PremiumSuite(String propertyId,String streetNumber, String streetName, String suburbName, DateTime lastMaintenanceDate){
        super(propertyId, streetNumber, streetName, suburbName);
        this.propertyType = "Premium";
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.nextMaintenanceDate = new DateTime(lastMaintenanceDate,10);
        this.noOfBedrooms = 3;
        setDailyRate(554);

    }

    @Override
    public boolean rentingconditions(DateTime rentDate, int numOfRentDays) {
        //Each Premium Suite can be rented for a minimum of 1 day
        DateTime estimatedReturnDate = new DateTime(rentDate, numOfRentDays);
        if(numOfRentDays<1){
            System.err.print("Each Premium Suite can be rented for a minimum of 1 day not less.");
            return false;
        }

        //All Premium Suites must have a maintenance interval of 10 days.
        //Customers will not be allowed to rent a suite for a time period which exceeds the date on which maintenance operation must be done.
        if(DateTime.diffDays(estimatedReturnDate,nextMaintenanceDate)>0){
            System.err.print("The estimated return exceed the date on which maintenance operation must be done.");
            return false;
        }


        return true;
    }

    @Override
    public String getPropertyDetails() {
        String returnString = "\n---------\nProperty ID:" + getPropertyId() + "\n" + "Street number: " + getStreetNumber() + "\n" + "Street name: " + getStreetName() + "\n" + "Suburb Name: " + getSuburbName() + "\n" + "Property status: " + getPropertyStatus() +"\n" + "Last Maintained On: " + getLastMaintenanceDate().getFormattedDate();
        returnString+="\nRental Records\n";
        if(noOfRentalRecords==0){
            returnString+="**NO RENTAL RECORD YET**";
        }else if(noOfRentalRecords>0){
            for(int i=0;i<noOfRentalRecords;i++){
                returnString+=recentRecords[i].getDetails();
            }
        }
        return returnString;
    }


}
