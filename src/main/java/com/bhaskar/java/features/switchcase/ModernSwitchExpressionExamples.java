package com.bhaskar.java.features.switchcase;

import com.bhaskar.java.features.switchcase.enums.WeatherEnum;
import com.bhaskar.java.features.switchcase.model.BeanPackage;
import com.bhaskar.java.features.switchcase.model.CupPackage;
import com.bhaskar.java.features.switchcase.model.Delivery;
import com.bhaskar.java.features.switchcase.model.WeatherRecord;

public class ModernSwitchExpressionExamples {

    /**
     * Demonstrates the use of switch expressions with integers.
     *
     * @param dayNumber an {@code int} value ranging from 1 to 7, representing a day of the week.
     * @return a {@code String} indicating the corresponding day of the week,
     * or "Invalid day" if the input is out of range.
     */
    public static String printDay(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
    }

    /**
     * Demonstrates a switch-case operation on a weather condition string.
     *
     * @param weather the current weather condition as a {@code String} (e.g., "Sunny", "Rainy", "Cloudy").
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdvice(String weather) {
        return switch (weather) {
            case "Sunny" -> "Wear Sunglasses and stay hydrated";
            case "Rainy" -> "Take an umbrella and wear waterproof shoes";
            case "Cloudy" -> "Carry a light jacket";
            default -> "Invalid weather condition";
        };
    }

    /**
     * Demonstrates the use of switch expressions with an enum.
     *
     * @param weather the current weather condition as a {@code WeatherEnum} value.
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdviceForEnum(WeatherEnum weather) {
        return switch (weather) {
            case SUNNY -> "Wear Sunglasses and stay hydrated";
            case RAINY -> "Take an umbrella and wear waterproof shoes";
            case CLOUDY -> "Carry a light jacket";
            default -> "Invalid weather condition";
        };
    }

    /**
     * Demonstrates the use of switch expressions with an enum and additional logic.
     *
     * @param weather the current weather condition as a {@code WeatherEnum} value.
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdviceWithLogicInsideEachCase(WeatherEnum weather) {
        return switch (weather) {
            case SUNNY -> {
                String advice = "Wear Sunglasses and stay hydrated";
                yield advice + ". Enjoy the sunny day!";
            }
            case RAINY -> {
                String advice = "Take an umbrella and wear waterproof shoes";
                yield advice + ". Stay dry!";
            }
            case CLOUDY -> {
                String advice = "Carry a light jacket";
                yield advice + ". Stay warm!";
            }
            default -> "Invalid weather condition";
        };
    }

    /**
     * Demostrates the use of switch expressions with records.
     *
     * @param weather the current weather condition as a {@code WeatherRecord} value.
     * @return a {@code String} containing advice based on the specified weather condition.
     */
    public static String getWeatherAdviceForRecord(WeatherRecord weather) {
        return switch (weather) {
            case WeatherRecord(String weatherStr, int temp) when temp > 30 && weatherStr.equalsIgnoreCase("sunny") ->
                    "Wear Sunglasses and stay hydrated";
            case WeatherRecord(String weatherStr, int temp) when temp < 27 && weatherStr.equalsIgnoreCase("rainy") ->
                    "Take an umbrella and wear waterproof shoes";
            case WeatherRecord(String weatherStr, int temp) -> //default case
                    "Carry a light jacket";
        };
    }

    public static String analyzeDelivery(Delivery d) {
        return switch (d) {
            case BeanPackage(String o, int w) when w > 500 -> "Large beans from " + o;
            case BeanPackage(String o, int ignored) -> "Some beans from " + o;
            case CupPackage(int q) when q > 0  -> "Cups: " + q;
            case null -> "No delivery";
            default -> "Unknown delivery";
        };
    }

}
