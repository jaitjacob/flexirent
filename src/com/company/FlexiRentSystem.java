package com.company;
import java.util.Calendar;
import java.util.Scanner;

public class FlexiRentSystem {
    static int numberOfProperty = 0;
    FlexiRentSystem property[] = new FlexiRentSystem[50];


    void start(){
        int userInput;
        Scanner inp = new Scanner(System.in);
        do{
            System.out.println("\n***Welcome to FlexiRent ***\n1.Add Property\n2.Rent Property\n3.Return Property\n4.Property Maintenance\n5.Complete Maintenance\n6.Display all properties\n7.Exit\nSelect one option: ");
            userInput = inp.nextInt();
            switch (userInput){
                case 1: addPropertyoption();

                    break;
                case 4:
                    userInput = 7;
                    System.out.println("Thank you for using FlexiRent! See you soon.");
                    break;
            }
        }
        while(userInput!=7);
    }

    void addPropertyoption(){
        String apartmentType;
        Scanner inp = new Scanner(System.in);
        System.out.println("What type of property do you wish to add? [Type 'A' for Apartment and 'P' for Premium Suite]:");
        apartmentType = inp.next();
        if(apartmentType.equals("A")|| apartmentType.equals("a")){
            property[numberOfProperty] = new Apartment()



            return;
        }
        else if(apartmentType.equals("P") || apartmentType.equals("p")){

            System.out.println("suite detected");

            return;
        }
        else {
            System.out.println("Please enter a valid property type.");
            return;
        }
    }


}
