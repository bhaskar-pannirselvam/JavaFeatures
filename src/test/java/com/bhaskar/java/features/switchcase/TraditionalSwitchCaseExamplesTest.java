package com.bhaskar.java.features.switchcase;

import com.bhaskar.java.features.switchcase.enums.WeatherEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.bhaskar.java.features.switchcase.TraditionalSwitchCaseExamples.*;
import static org.junit.jupiter.api.Assertions.*;


public class TraditionalSwitchCaseExamplesTest {

    @ParameterizedTest
    @CsvSource({"1, Monday", "2, Tuesday", "3, Wednesday", "4, Thursday", "5, Friday", "6, Saturday", "7, Sunday"})
    @DisplayName("printDay(int): Should return the correct day name for valid day numbers")
    public void test_printDay_validDays(int dayNumber, String expectedResult) {
        testPrintDayForGivenInputOutput(dayNumber, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"0, Invalid day", "8, Invalid day"})
    @DisplayName("printDay(int): Should return 'Invalid day' for boundary values outside valid range")
    public void test_printDay_boundaryInvalidDays(int dayNumber, String expectedResult) {
        testPrintDayForGivenInputOutput(dayNumber, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"-1, Invalid day", "-100, Invalid day", "100, Invalid day"})
    @DisplayName("printDay(int): Should return 'Invalid day' for random invalid numbers")
    public void test_printDay_randomInvalidDays(int dayNumber, String expectedResult) {
        testPrintDayForGivenInputOutput(dayNumber, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "2147483647, Invalid day", // Integer.MAX_VALUE
            "-2147483648, Invalid day" // Integer.MIN_VALUE
    })
    @DisplayName("printDay(int): Should return 'Invalid day' for extreme int values")
    public void test_printDay_extremeInvalidDays(int dayNumber, String expectedResult) {
        testPrintDayForGivenInputOutput(dayNumber, expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"null, Invalid day", "'', Invalid day", "'some string', Invalid day"})
    @DisplayName("printDay(int): Defensive tests for unexpected inputs")
    public void test_printDay_defensiveTests(String unexpectedInput, String expectedResult) {
        try {
            int dayNumber = Integer.parseInt(unexpectedInput);
            testPrintDayForGivenInputOutput(dayNumber, expectedResult);
        } catch (NumberFormatException e) {
            assertEquals("Invalid day", expectedResult, "Unexpected input caused NumberFormatException");
        }
    }

    private static void testPrintDayForGivenInputOutput(int dayNumber, String expectedResult) {
        String actualResult = printDay(dayNumber);
        assertEquals(expectedResult, actualResult, "Unexpected result for day number: " + dayNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "Sunny, Wear Sunglasses and stay hydrated",
            "Rainy, Take an umbrella and wear waterproof shoes",
            "Cloudy, Carry a light jacket"
    })
    @DisplayName("getWeatherAdvice(String): Should return correct advice for known weather conditions")
    public void test_getWeatherAdvice_validInputs(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "'Foggy', Check the weather forecast and plan accordingly",
            "'Hot', Check the weather forecast and plan accordingly"
    })
    @DisplayName("getWeatherAdvice(String): Should return default advice for unknown weather conditions")
    public void test_getWeatherAdvice_unknownWeather(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdvice(String): Should throw NullPointerException when input is null")
    public void test_getWeatherAdvice_nullInput() {
        assertThrows(NullPointerException.class, () -> getWeatherAdvice(null),
                "Expected NullPointerException when input is null");
    }


    @ParameterizedTest
    @CsvSource({
            "SNOW, Dress in layers. Wear a light jacket on top and a sweater or hoodie as a middle layer",
            "RAINY, Take an umbrella and wear waterproof shoes",
            "CLOUDY, Carry a light jacket",
            "SUNNY, Wear sunglasses and stay hydrated",
            "WINDY, Wear a windbreaker and secure loose items",
            "DRIZZLE, Carry an umbrella and wear a light waterproof jacket"
    })
    @DisplayName("getWeatherAdviceForEnumValue(WeatherEnum): Should return correct advice for known weather conditions")
    public void getWeatherAdviceForEnumValue_validInputs(WeatherEnum weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdviceForEnumValue(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }


    @Test
    @DisplayName("getWeatherAdviceForEnumValue(WeatherEnum): Should throw NullPointerException when input is null")
    public void getWeatherAdviceForEnumValue_nullInput() {
        assertThrows(NullPointerException.class, () -> getWeatherAdviceForEnumValue(null),
                "Expected NullPointerException when input is null");
    }

    @ParameterizedTest
    @CsvSource({
            "SNOW, Dress in layers. Wear a light jacket on top and a sweater or hoodie as a middle layer",
            "RAINY, Take an umbrella and wear waterproof shoes",
            "CLOUDY, Carry a light jacket",
            "SUNNY, Wear sunglasses and stay hydrated",
            "WINDY, Wear a windbreaker and secure loose items",
            "DRIZZLE, Carry an umbrella and wear a light waterproof jacket"
    })
    @DisplayName("getWeatherAdviceForEnumValue(WeatherEnum): Should handle mixed case inputs correctly")
    public void getWeatherAdviceForEnumValue_mixedCaseInputs(WeatherEnum weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdviceForEnumValue(WeatherEnum.valueOf(weather.name().toUpperCase()));
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdviceForEnumValue(WeatherEnum): Should handle empty enum value")
    public void getWeatherAdviceForEnumValue_emptyEnumValue() {
        assertThrows(IllegalArgumentException.class, () -> getWeatherAdviceForEnumValue(WeatherEnum.valueOf("")),
                "Expected IllegalArgumentException when input is an empty enum value");
    }


}
