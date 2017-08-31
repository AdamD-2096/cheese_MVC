package org.launchcode.helpers;

import java.util.Date;

public class MDY extends Date{

    public static String getMMDDYY(){
        MDY date = new MDY();
        int year = date.getYear() - 100;
        int month = date.getMonth() + 1;
        int day = date.getDate();
        return (String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year));
    }
    public static long getLong(){
        MDY date = new MDY();
        long DT = date.getTime();
        return DT;
    }
}