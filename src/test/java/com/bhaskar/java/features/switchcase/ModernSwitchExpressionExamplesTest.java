package com.bhaskar.java.features.switchcase;

import com.bhaskar.java.features.switchcase.enums.WeatherEnum;
import com.bhaskar.java.features.switchcase.model.Delivery;
import com.bhaskar.java.features.switchcase.model.WeatherRecord;
import com.bhaskar.java.features.testutil.DeliveryConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static com.bhaskar.java.features.switchcase.ModernSwitchExpressionExamples.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModernSwitchExpressionExamplesTest {
    @ParameterizedTest
    @CsvSource({
            "1, Monday",
            "2, Tuesday",
            "3, Wednesday",
            "4, Thursday",
            "5, Friday",
            "6, Saturday",
            "7, Sunday"
    })
    @DisplayName("printDay(int): Should return correct day of the week for valid days")
    public void printDay_validDays(int dayNumber, String expectedDay) {
        String actualDay = printDay(dayNumber);
        assertEquals(expectedDay, actualDay, "Unexpected day for day number: " + dayNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "0, Invalid day",
            "8, Invalid day",
            "-1, Invalid day"
    })
    @DisplayName("printDay(int): Should return 'Invalid day' for invalid days")
    public void printDay_invalidDays(int dayNumber, String expectedDay) {
        String actualDay = printDay(dayNumber);
        assertEquals(expectedDay, actualDay, "Unexpected day for day number: " + dayNumber);
    }

    @ParameterizedTest
    @CsvSource({
            "Sunny, Wear Sunglasses and stay hydrated",
            "Rainy, Take an umbrella and wear waterproof shoes",
            "Cloudy, Carry a light jacket"
    })
    @DisplayName("getWeatherAdvice(String): Should return correct advice for known weather conditions")
    public void getWeatherAdvice_knownWeatherConditions(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "Stormy, Invalid weather condition",
            "Snowy, Invalid weather condition",
            "Windy, Invalid weather condition"
    })
    @DisplayName("getWeatherAdvice(String): Should return 'Invalid weather condition' for unknown weather conditions")
    public void getWeatherAdvice_unknownWeatherConditions(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "'', Invalid weather condition",
            "' ', Invalid weather condition",
            "'Unknown', Invalid weather condition"
    })
    @DisplayName("getWeatherAdvice(String): Should return 'Invalid weather condition' for empty or unknown weather conditions")
    public void getWeatherAdvice_emptyOrUnknownWeatherConditions(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "Sunny, Wear Sunglasses and stay hydrated",
            "Rainy, Take an umbrella and wear waterproof shoes",
            "Cloudy, Carry a light jacket"
    })
    @DisplayName("getWeatherAdvice(String): Should handle case-insensitive weather conditions")
    public void getWeatherAdvice_caseInsensitiveWeatherConditions(String weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdvice(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdvice(String): Should throw NullPointerException when input is null")
    public void getWeatherAdvice_nullInput() {
        assertThrows(NullPointerException.class, () -> getWeatherAdvice(null),
                "Expected NullPointerException when input is null");
    }

    @ParameterizedTest
    @CsvSource({
            "SUNNY, Wear Sunglasses and stay hydrated",
            "RAINY, Take an umbrella and wear waterproof shoes",
            "CLOUDY, Carry a light jacket"
    })
    @DisplayName("getWeatherAdviceForEnum(WeatherEnum): Should return correct advice for known weather conditions")
    public void getWeatherAdviceForEnum_knownWeatherConditions(WeatherEnum weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdviceForEnum(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdviceForEnum(WeatherEnum): Should throw NullPointerException when input is null")
    public void getWeatherAdviceForEnum_nullInput() {
        assertThrows(NullPointerException.class, () -> getWeatherAdviceForEnum(null),
                "Expected NullPointerException when input is null");
    }

    @ParameterizedTest
    @CsvSource({
            "SUNNY, 35, Wear Sunglasses and stay hydrated",
            "RAINY, 20, Take an umbrella and wear waterproof shoes",
            "CLOUDY, 25, Carry a light jacket"
    })
    @DisplayName("getWeatherAdviceForRecord(WeatherRecord): Should return correct advice for known weather conditions")
    public void getWeatherAdviceForRecord_knownWeatherConditions(String weatherStr, int temp, String expectedAdvice) {
        WeatherRecord weather = new WeatherRecord(weatherStr, temp);
        String actualAdvice = getWeatherAdviceForRecord(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "SNOWY, 10, Carry a light jacket",
            "WINDY, 15, Carry a light jacket",
            "STORMY, 5, Carry a light jacket"
    })
    @DisplayName("getWeatherAdviceForRecord(WeatherRecord): Should return default advice for unknown weather conditions")
    public void getWeatherAdviceForRecord_unknownWeatherConditions(String weatherStr, int temp, String expectedAdvice) {
        WeatherRecord weather = new WeatherRecord(weatherStr, temp);
        String actualAdvice = getWeatherAdviceForRecord(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdviceForRecord(WeatherRecord): Should throw NullPointerException when input is null")
    public void getWeatherAdviceForRecord_nullInput() {
        assertThrows(NullPointerException.class, () -> getWeatherAdviceForRecord(null),
                "Expected NullPointerException when input is null");
    }

    @ParameterizedTest
    @CsvSource({
            "SUNNY, 30, Carry a light jacket",
            "RAINY, 27, Carry a light jacket",
            "CLOUDY, 0, Carry a light jacket"
    })
    @DisplayName("getWeatherAdviceForRecord(WeatherRecord): Should handle edge cases for temperature")
    public void getWeatherAdviceForRecord_edgeCases(String weatherStr, int temp, String expectedAdvice) {
        WeatherRecord weather = new WeatherRecord(weatherStr, temp);
        String actualAdvice = getWeatherAdviceForRecord(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @ParameterizedTest
    @CsvSource({
            "BeanPackage(Colombia; 600), Large beans from Colombia",
            "BeanPackage(Brazil; 400), Some beans from Brazil",
            "BeanPackage(Ethiopia; 500), Some beans from Ethiopia",
            "BeanPackage(Kenya; 501), Large beans from Kenya",
            "CupPackage(10), Cups: 10",
            "CupPackage(0), Unknown delivery",
            "CupPackage(-1), Unknown delivery"
    })
    @DisplayName("analyzeDelivery(Delivery): Should handle various delivery scenarios")
    public void analyzeDelivery_variousScenarios(@ConvertWith(DeliveryConverter.class)  Delivery delivery, String expectedAnalysis) {
        String actualAnalysis = analyzeDelivery(delivery);
        assertEquals(expectedAnalysis, actualAnalysis, "Unexpected analysis for delivery: " + delivery);
    }

    @ParameterizedTest
    @CsvSource({
            "BeanPackage(Unknown; 0), Some beans from Unknown",
            "BeanPackage(Unknown; -1), Some beans from Unknown",
            "BeanPackage(Unknown; 501), Large beans from Unknown",
            "CupPackage(Integer.MAX_VALUE), Cups: 2147483647",
            "CupPackage(Integer.MIN_VALUE), Unknown delivery"
    })
    @DisplayName("analyzeDelivery(Delivery): Should handle edge cases for delivery scenarios")
    public void analyzeDelivery_edgeCases(@ConvertWith(DeliveryConverter.class)  Delivery delivery, String expectedAnalysis) {
        String actualAnalysis = analyzeDelivery(delivery);
        assertEquals(expectedAnalysis, actualAnalysis, "Unexpected analysis for delivery: " + delivery);
    }

    @Test
    @DisplayName("analyzeDelivery(Delivery): Should return 'No delivery' when input is null")
    public void analyzeDelivery_nullInput() {
        String actualAnalysis = analyzeDelivery(null);
        assertEquals("No delivery", actualAnalysis, "Unexpected analysis for null delivery");
    }

    @ParameterizedTest
    @CsvSource({
            "BeanPackage(Colombia; 600), Large beans from Colombia",
            "BeanPackage(Brazil; 400), Some beans from Brazil",
            "CupPackage(10), Cups: 10",
            "CupPackage(0), Unknown delivery",
            "BeanPackage(Ethiopia; 500), Some beans from Ethiopia",
            "CupPackage(-1), Unknown delivery",
            "BeanPackage(Kenya; 501), Large beans from Kenya",
            "CupPackage(Integer.MAX_VALUE), Cups: 2147483647",
            "BeanPackage(Unknown; 0), Some beans from Unknown",
            "CupPackage(Integer.MIN_VALUE), Unknown delivery"
    })
    @DisplayName("analyzeDelivery(Delivery): Should handle mixed delivery scenarios")
    public void analyzeDelivery_mixedScenarios(@ConvertWith(DeliveryConverter.class) Delivery delivery, String expectedAnalysis) {
        String actualAnalysis = analyzeDelivery(delivery);
        assertEquals(expectedAnalysis, actualAnalysis, "Unexpected analysis for delivery: " + delivery);
    }

    @ParameterizedTest
    @CsvSource({
            "SUNNY, Wear Sunglasses and stay hydrated. Enjoy the sunny day!",
            "RAINY, Take an umbrella and wear waterproof shoes. Stay dry!",
            "CLOUDY, Carry a light jacket. Stay warm!"
    })
    @DisplayName("getWeatherAdviceWithLogic(WeatherEnum): Should return correct advice with additional logic for known weather conditions")
    public void getWeatherAdviceWithLogic_knownWeatherConditionsInsideEachCase(WeatherEnum weather, String expectedAdvice) {
        String actualAdvice = getWeatherAdviceWithLogicInsideEachCase(weather);
        assertEquals(expectedAdvice, actualAdvice, "Unexpected advice for weather: " + weather);
    }

    @Test
    @DisplayName("getWeatherAdviceWithLogic(WeatherEnum): Should throw nullpointer exception for null passed as input")
    public void getWeatherAdviceWithLogic_unknownWeatherConditionInsideEachCase() {
        //this method will throw nullpointer exception as null case isn't present
        assertThrows(NullPointerException.class, () -> getWeatherAdviceWithLogicInsideEachCase(null),
                "Expected NullPointerException when input is null");
    }
}
