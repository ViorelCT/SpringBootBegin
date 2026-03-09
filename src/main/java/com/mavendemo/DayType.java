package com.mavendemo;

public class DayType {

    // Metoda care returnează numele zilei și tipul (weekday/weekend)
    public String getDayInfo(int day) {
        String dayName = switch (day) {
            case 1 -> "Luni";
            case 2 -> "Marti";
            case 3 -> "Miercuri";
            case 4 -> "Joi";
            case 5 -> "Vineri";
            case 6 -> "Sambata";
            case 7 -> "Duminica";
            default -> "Invalid";
        };

        if (dayName.equals("Invalid")) {
            return "Numar invalid!";
        } else {
            String type = (day == 6 || day == 7) ? "weekend" : "weekday";
            return "Ziua este " + dayName + "\ntip: " + type;
        }
    }
}
