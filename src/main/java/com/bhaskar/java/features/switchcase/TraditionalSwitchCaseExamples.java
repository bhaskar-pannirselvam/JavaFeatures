package com.bhaskar.java.features.switchcase;

import com.bhaskar.java.features.switchcase.enums.WeatherEnum;

public class TraditionalSwitchCaseExamples {

    /**
     * Demonstrates the use of integers in switch cases.
     *
     * @param dayNumber an {@code int} value ranging from 1 to 7, representing a day of the week.
     * @return a {@code String} indicating the corresponding day of the week,
     * or "Invalid day" if the input is out of range.
     */
    public static String printDay(int dayNumber) {
        String day;
        switch (dayNumber) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "Invalid day";
        }
        return day;
    }

    /**
     * Demonstrates a switch-case operation on a weather condition string.
     *
     * @param weather the current weather condition as a {@code String} (e.g., "Sunny", "Rainy", "Cloudy").
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdvice(String weather) {
        String advice;
        switch (weather) {
            case "Sunny":
                advice = "Wear Sunglasses and stay hydrated";
                break;
            case "Rainy":
                advice = "Take an umbrella and wear waterproof shoes";
                break;
            case "Cloudy":
                advice = "Carry a light jacket";
                break;
            default:
                advice = "Check the weather forecast and plan accordingly";
        }
        return advice;
    }

    /**
     * Provides weather advice based on the given weather condition.
     *
     * @param weather the weather condition as a {@link WeatherEnum} value.
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdviceForEnumValue(WeatherEnum weather) {
        String advice;
        switch (weather) {
            case SNOW:
                advice = "Dress in layers. Wear a light jacket on top and a sweater or hoodie as a middle layer";
                break;
            case RAINY:
                advice = "Take an umbrella and wear waterproof shoes";
                break;
            case CLOUDY:
                advice = "Carry a light jacket";
                break;
            case SUNNY:
                advice = "Wear sunglasses and stay hydrated";
                break;
            case WINDY:
                advice = "Wear a windbreaker and secure loose items";
                break;
            case DRIZZLE:
                advice = "Carry an umbrella and wear a light waterproof jacket";
                break;
            default:
                advice = "Check the weather forecast and plan accordingly";
        }
        return advice;
    }

}


