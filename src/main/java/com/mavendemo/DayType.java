package com.mavendemo;

public class DayType {

    public String getDayInfo(int day) {
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid";
        };

        if (dayName.equals("Invalid")) {
            return "Invalid number!";
        } else {
            String type = (day == 6 || day == 7) ? "weekend" : "weekday";
            return "The day is " + dayName + "\ntype: " + type;
        }
    }
}
