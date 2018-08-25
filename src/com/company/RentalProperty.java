package com.company;

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
    private RentalRecords[] recentRecords = new RentalRecords[10];

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

    public String getPropertyDetails() {
        String returnString = "\n---------\nProperty ID:" + getPropertyId() + "\n" + "Street number: " + getStreetNumber() + "\n" + "Street name: " + getStreetName() + "\n" + "Suburb Name: " + getSuburbName() + "\n" + "Property status: " + getPropertyStatus() +"\n";
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

    public double getDailyRate(){
        return dailyRate;
    }


    //setters
    public void setPropertyStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
    public void setDailyRate(double dailyRate) {this.dailyRate = dailyRate;};


    public boolean isAvailable() {
        if (propertyStatus.toLowerCase().equals("available"))
            return true;

        return false;
    }


    //ABSTRACT METHODS THAT THE SUBCLASSES NEED TO IMPLEMENT NEED TO GO DOWN HERE. LOOK BELOW.
    //The following methods can be called on any object of type Apartment or Premium Suite and each of the object have their own way of implementing it hence, adding them as abstract.
    public abstract boolean checkRentingconditions(DateTime rentDate, int numOfRentDays);





    public boolean rent(String customerId, DateTime rentDate, int numOfRentDays) {
        //first lets check if the property is Available or not.
        if (!checkRentingconditions(rentDate, numOfRentDays)) {
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
        else if(noOfRentalRecords>1 && noOfRentalRecords<=10){
            System.arraycopy(recentRecords,0,recentRecords,1, noOfRentalRecords);
            recentRecords[0] = new RentalRecords(getPropertyId(),customerId,rentDate,numOfRentDays);
            System.err.print("Rental record generated.");
            this.setPropertyStatus("Rented");
            if(noOfRentalRecords==10){
                noOfRentalRecords = 0;

            }
            else{
                noOfRentalRecords++;
            }

            return true;
        }
        return false;
    }



    public void returnProperty(DateTime actualReturnDate){
      boolean returnValue =  recentRecords[0].returnProperty(actualReturnDate, getDailyRate());
      if(returnValue){
          this.setPropertyStatus("available");
      }
      else if(!returnValue){
          System.err.print("Property could not be returned.");
      }
    }

}