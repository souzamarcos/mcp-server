package com.marcos.mcpserver.core.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService();
    }

    @Test
    void getWeather_ShouldReturnWeatherInfo_WhenCityNameProvided() {
        // Arrange
        String cityName = "São Paulo";
        String expected = "The weather in São Paulo is sunny with a temperature of 25°C.";

        // Act
        String result = weatherService.getWeather(cityName);

        // Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void getWeatherForecastByLocation_ShouldReturnForecast_WhenCoordinatesProvided() {
        // Arrange
        double latitude = -23.5505;
        double longitude = -46.6333;
        String expected = "The weather forecast for coordinates (-23.5505, -46.6333) is cloudy with a chance of rain.";

        // Act
        String result = weatherService.getWeatherForecastByLocation(latitude, longitude);

        // Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void getAlerts_ShouldReturnAlerts_WhenStateProvided() {
        // Arrange
        String state = "Florida";
        String expected = "Weather alerts for Florida: Severe thunderstorm warning in effect.";

        // Act
        String result = weatherService.getAlerts(state);

        // Assert
        assertNotNull(result);
        assertEquals(expected, result);
    }
}
