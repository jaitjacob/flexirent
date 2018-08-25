package com.company;

import java.util.Date;
import java.util.Scanner;

public class FlexiRentSystem {

    static int countOfProperties;
    RentalProperty[] allProperties = new RentalProperty[50];

    void startFlexiRentSystem() {
        int userOption;
        Scanner userInput = new Scanner(System.in);
        String menu = "\n**** FLEXIRENT SYSTEM MENU ****\n" +
                "\n1.Add Property\n" +
                "2.Rent Property\n" +
                "3.Return Property\n" +
                "4.Property Maintenance\n" +
                "5.Complete Maintenance\n" +
                "6.Display All Properties\n" +
                "7.Exit Program\n" +
                "Enter you choice: ";

        do {

            System.out.print(menu);
            userOption = userInput.nextInt();
            userInput.nextLine();
            switch (userOption) {
                 case 1://add property
                    System.out.print("Enter type of property: ");
                    String propertyType;
                    propertyType = userInput.nextLine();
                    if(propertyType.toLowerCase().equals("apartment")){
                        String streetNumber,streetName,suburbName,propertyId;
                        int noOfBedrooms;
                        System.out.print("Enter street number: ");
                        streetNumber = userInput.nextLine();
                        System.out.print("Enter street name: ");
                        streetName = userInput.nextLine();
                        System.out.print("Enter suburb name: ");
                        suburbName = userInput.nextLine();
                        System.out.print("Enter number of Bedrooms: "); noOfBedrooms = userInput.nextInt();
                        propertyId = propertyIdGenerator(propertyType);

                        if(!checkIfPropertyAlreadyExists(streetNumber,streetName,suburbName)){
                            allProperties[countOfProperties++] = new Apartment(propertyId,streetNumber,streetName,suburbName,noOfBedrooms);
                        }
                        else{
                            System.err.print("Similar property already in system. Cannot add. Sorry");
                            break;
                        }
                    }

                    if(propertyType.toLowerCase().equals("premium suite")){
                        String streetNumber,streetName,suburbName,propertyId;
                        System.out.println("Enter street number: "); streetNumber = userInput.nextLine();
                        System.out.println("Enter street name: "); streetName = userInput.nextLine();
                        System.out.println("Enter suburb name: "); suburbName = userInput.nextLine();
                        propertyId = propertyIdGenerator(propertyType);
                        if(!checkIfPropertyAlreadyExists(streetNumber,streetName,suburbName)) {
                            allProperties[countOfProperties++] = new PremiumSuite(propertyId, streetNumber, streetName, suburbName);
                        }
                        else{
                            System.err.println("Similar property already in system. Cannot add. Sorry");
                        }
                    }


                    break;
                //end of Case 1

                //rent property
                 case 2:
                     System.out.print("Enter property ID: ");
                     String propertyId = userInput.nextLine();
                     if(!ifpropertyIdExist(propertyId)){
                         System.err.print("\nProperty ID does not seem to exist on the system.");
                         break;
                     }

                     for(int i=0;i<countOfProperties;i++){
                         if(allProperties[i].getPropertyId().equals(propertyId)){
                             if(!allProperties[i].isAvailable()){
                                 //this means the property is not available - either rented or under maintenance.
                                 System.err.print("Property not available for renting. Sorry.");
                                 break;
                             }
                             else {
                                 System.out.print("Enter customer ID: ");
                                 String customerId = userInput.nextLine();

                                 System.out.print("Rent date (DD/MM/YYYY): ");
                                 String rentDate = userInput.nextLine();
                                 DateTime rentDay = passtheDatefromString(rentDate);

                                 System.out.print("How many days?: ");
                                 int noOfDays = userInput.nextInt();

                                 allProperties[i].rent(customerId,rentDay,noOfDays);
                             }
                         }
                     }

                    break;

                //Return property functionality
                 case 3:
                     System.out.print("Enter the property ID of the property that has to be returned: ");
                     //this property ID variable is being reused from case 2.
                     propertyId = userInput.nextLine();

                     if(!ifpropertyIdExist(propertyId)){
                         System.err.print("The property ID does not seem to exist on the system.");
                     }

                     for(int i=0;i<countOfProperties;i++){
                         if(allProperties[i].getPropertyId().equals(propertyId)){
                             System.out.println("\nEnter the return date: ");
                             String returnDate = userInput.nextLine();
                             DateTime actualReturnDate = passtheDatefromString(returnDate);
                             allProperties[i].returnProperty(actualReturnDate);

                         }
                     }


                    break;

                 //property maintenance
                 case 4:
                     System.out.print("Please enter the property ID: ");
                     propertyId = userInput.nextLine();

                     if(!ifpropertyIdExist(propertyId)){
                         System.err.print("Property ID does not seem to exist on the system.");
                         break;
                     }

                     for(int i=0;i<countOfProperties;i++){
                         if(allProperties[i].getPropertyId().equalsIgnoreCase(propertyId)){
                             if(allProperties[i].getPropertyStatus().equalsIgnoreCase("available")){
                                 allProperties[i].setPropertyStatus("Under Maintenance");
                             }

                             if(allProperties[i].getPropertyStatus().equalsIgnoreCase("rented")){
                                 System.err.print("Can NOT perform maintenance when property being currently rented.");
                             }

                             if(allProperties[i].getPropertyStatus().equalsIgnoreCase("under maintenance")){
                                 System.err.print("Already under maintenance. Calm down.");
                             }
                         }
                     }
                    break;


                 case 5:
                    break;

                 case 6:
                     for(int i=0; i<countOfProperties;i++){
                         System.out.println(allProperties[i].getPropertyDetails());
                     }

                    break;
                 case 7:
                    break;

            }
        }
        while (userOption != 7);
        System.out.println("Thank you for using FlexiRent. Goodbye.");
    }


    //this is used in add property option to check if the property already exists.
    public boolean checkIfPropertyAlreadyExists(String streetNumber,String streetName,String suburbName){
        for(int i=0;i<countOfProperties;i++){
           if(allProperties[i].getStreetNumber().toLowerCase().equals(streetNumber) && allProperties[i].getStreetName().toLowerCase().equals(streetName) && allProperties[i].getSuburbName().toLowerCase().equals(suburbName))
               return true;
        }
        return false;
    }

    //this is used in rent property to check if the property ID exists.
    public boolean ifpropertyIdExist(String propertyId){
        for(int i=0;i<countOfProperties;i++){
            if(allProperties[i].getPropertyId().equals(propertyId)){
                return true;
            }
            return false;
        }
    return false;
    }


    public String propertyIdGenerator(String propertyType){
        if(propertyType.toLowerCase().equals("apartment")){
            return "A"+countOfProperties+"";
        }
        else{
            return "S"+countOfProperties+"";
        }

    }

    //this method gives date in DateTime
    public DateTime passtheDatefromString(String date){
        int day,month,year;
        day = Integer.parseInt(date.substring(0,2));
        month = Integer.parseInt(date.substring(3,5));
        year = Integer.parseInt(date.substring(6));

        DateTime returnDate = new DateTime(day,month,year);
        return returnDate;
    }





}
