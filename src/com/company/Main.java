package com.company;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {




        DateTime rentDay = new DateTime(1,2,2019);
        DateTime returnDay = new DateTime(25,1,2019);
        System.out.println(DateTime.diffDays(returnDay,rentDay));

    }
}
