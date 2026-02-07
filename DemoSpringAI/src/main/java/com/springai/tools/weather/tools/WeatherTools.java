package com.springai.tools.weather.tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import com.springai.tools.weather.dto.WeatherResponse;
import com.springai.tools.weather.service.WeatherService;

@Component
public class WeatherTools {

	private final WeatherService weatherService;

	public WeatherTools(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@Tool(
			description = "Returns the current weather for a city including temperature and wind speed. " +
					"Use this tool whenever the user asks about weather or temperature.")
	public String getCurrentWeather(String city) {

		try {
			WeatherResponse weather = weatherService.getWeatherByCity(city);

			return String.format(
					"Current weather in %s: Temperature %.1f°C, Wind %.1f km/h",
					city,
					weather.getCurrent_weather().getTemperature(),
					weather.getCurrent_weather().getWindspeed());

		} catch (Exception e) {
			return "Sorry, I couldn't find weather information for " + city + ".";
		}
	}
}

