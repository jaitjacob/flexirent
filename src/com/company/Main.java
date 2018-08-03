package com.company;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        //each customer is simply represented by a unique string of customer id of my choice. Since, there is no need to implement a class to store customer information.
        //enter these in run time
        String cust1 = "CUS0011";
        String cust2 = "CUS0022";
        String cust3 = "CUS0033";
        String cust4 = "CUS0044";










        /*Following code is for testing purposes. Put whatever rubbish you want below. */

        //Few properties already listed
        RentalProperty property1 = new RentalProperty("A_34NicholsonSt", "2","nicholsonST", "Fitzroy", 2, "Apartment", "A");
        RentalProperty property2 = new RentalProperty("S_14LygonSt", "75","pinguST", "Collingwood", 3, "Apartment", "A");
        RentalProperty property3 = new RentalProperty("A_01LonsdaleSt", "32","sussuST", "Tatti", 1, "Apartment", "A");

        //Few properties rented
        RentalRecord record1 = new RentalRecord("A_34nicholson",cust1,1,8,2018,2);
        System.out.println(record1.toString());




    }
}
