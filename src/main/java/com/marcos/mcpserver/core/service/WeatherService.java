package com.marcos.mcpserver.core.service;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Tool(name = "getWeather", description = "Get weather information by city name")
    public String getWeather(String cityName) {
        return "The weather in " + cityName + " is sunny with a temperature of 25°C.";
    }

    @Tool(name = "getWeatherForecast", description = "Get weather forecast for a specific latitude/longitude")
    public String getWeatherForecastByLocation(
            double latitude,
            double longitude
    ) {
        return "The weather forecast for coordinates (" + latitude + ", " + longitude + ") is cloudy with a chance of rain.";
    }

    @Tool(name = "getAlerts", description = "Get weather alerts for a US state")
    public String getAlerts(String state) {
        return "Weather alerts for " + state + ": Severe thunderstorm warning in effect.";
    }
}