package com.company;
public class Main {

    public static void main(String[] args) {

        DateTime noneDate = new DateTime(0,0,0) ;
        DateTime actualReturnDate = new DateTime(0,0,0) ;


        if(noneDate
        == null)
            System.out.println("it is null");
        else
            System.out.println("not null");


            System.out.println(actualReturnDate.diffDays(noneDate,actualReturnDate));




    }
}
