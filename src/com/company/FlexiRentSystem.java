package com.company;

import java.util.Scanner;

public class FlexiRentSystem {


    void startFlexiRentSystem() {


        RentalProperty[] allprop = new RentalProperty[50];
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
            switch (userOption) {
                 case 1://add property
                    System.out.println("Enter type of property: ");
                    String propertyType;
                    propertyType = userInput.next();

                    break;




                 case 2:
                    break;
                 case 3:
                    break;
                 case 4:
                    break;
                 case 5:
                    break;
                 case 6:
                    break;
                 case 7:
                    break;

            }
        }
        while (userOption != 7);
        System.out.println("Thank you for using FlexiRent. Goodbye.");
    }



}
