package com.company;

import java.util.Scanner;

public class FlexiRentSystem {

    static int countOfProperties;
    RentalProperty[] allProperties = new RentalProperty[50];

    void startFlexiRentSystem() {
        int userOption;
        Scanner userInput = new Scanner(System.in);
        String menu = "**** FLEXIRENT SYSTEM MENU ****\n" +
                "\n1.Add Property\n" +
                "2.Rent Property\n" +
                "3.Return Property\n" +
                "4.Property Maintenance\n" +
                "5.Complete Maintenance\n" +
                "6.Display All Properties\n" +
                "7.Exit Program\n" +
                "Enter you choice: ";

        do {

            System.out.println(menu);
            userOption = userInput.nextInt();
            userInput.nextLine();
            switch (userOption) {
                 case 1://add property
                    System.out.println("Enter type of property: ");
                    String propertyType;
                    propertyType = userInput.nextLine();
                    if(propertyType.toLowerCase().equals("apartment")){
                        String streetNumber,streetName,suburbName,propertyId;
                        int noOfBedrooms;
                        System.out.println("Enter street number: ");
                        streetNumber = userInput.nextLine();
                        System.out.println("Enter street name: ");
                        streetName = userInput.nextLine();
                        System.out.println("Enter suburb name: ");
                        suburbName = userInput.nextLine();
                        System.out.println("Enter number of Bedrooms: "); noOfBedrooms = userInput.nextInt();
                        propertyId = propertyIdGenerator(propertyType);

                        if(!checkIfPropertyAlreadyExists(streetNumber,streetName,suburbName)){
                            allProperties[countOfProperties++] = new Apartment(propertyId,streetNumber,streetName,suburbName,noOfBedrooms);
                        }
                        else{
                            System.err.println("Similar property already in system. Cannot add. Sorry");
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

                //rent property
                 case 2:
                     System.out.println("Enter property ID: ");
                     String propertyId = userInput.nextLine();
                     if(!ifpropertyIdExist(propertyId)){
                         System.err.println("\nProperty ID does not seem to exist on the system.");
                         break;
                     }

                     for(int i=0;i<countOfProperties;i++){
                         if(allProperties[i].getPropertyId().equals(propertyId)){
                             if(!allProperties[i].isAvailable()){
                                 //this means the property is not available - either rented or under maintenance.
                                 System.err.println("Property not available for renting. Sorry.");
                                 break;
                             }
                             else {
                                 System.out.println("Enter customer ID: ");
                                 String customerId = userInput.nextLine();

                                 System.out.println("Rent date (DD/MM/YYYY): ");
                                 String rentDate = userInput.nextLine();
                                 DateTime rentDay = passtheDatefromString(rentDate);

                                 System.out.println("How many days?: ");
                                 int noOfDays = userInput.nextInt();

                                 allProperties[i].rent(customerId,rentDay,noOfDays);

                             }
                         }
                     }

                    break;


                 case 3:
                    break;



                 case 4:
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
