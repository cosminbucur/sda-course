package com.sda.testing.junit5;

import static com.sda.testing.junit5.Day.SATURDAY;
import static com.sda.testing.junit5.Day.SUNDAY;

public class MyCalendar {

    public static boolean isWeekend(Day day) {
        return day.equals(SATURDAY) || day.equals(SUNDAY);
    }

    public static String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 6:
                return "Jun";
            case 12:
                return "Dec";
            default:
                return "not a month";
        }
    }
}
