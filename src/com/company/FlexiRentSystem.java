package com.company;
import java.util.Calendar;
import java.util.Scanner;

public class FlexiRentSystem {

    void start(){
        int userInput;
        Scanner inp = new Scanner(System.in);
        do{
            System.out.println("\n1.Add Property\n2.Rent Property\n3.Return Property\n4.Property Maintenance\n5.Complete Maintenance\n6.Display all properties\n7.Exit");
            userInput = inp.nextInt();
            switch (userInput){
                case 1:

                    break;
            }
        }
        while(userInput!=7);
    }
    


}
