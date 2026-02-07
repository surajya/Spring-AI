package com.springai.tools.weather.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springai.tools.weather.dto.GeoResponse;
import com.springai.tools.weather.dto.WeatherResponse;

@Service
public class WeatherService {

	private final RestTemplate restTemplate = new RestTemplate();

	public WeatherResponse getWeatherByCity(String city) {

		// 1️⃣ Geocoding
		String geoUrl =
				"https://geocoding-api.open-meteo.com/v1/search?name="
						+ city + "&count=1";

		GeoResponse geo = restTemplate.getForObject(geoUrl, GeoResponse.class);

		if (geo == null || geo.getResults() == null || geo.getResults().isEmpty()) {
			throw new RuntimeException("City not found");
		}

		double lat = geo.getResults().get(0).getLatitude();
		double lon = geo.getResults().get(0).getLongitude();

		// 2️⃣ Weather
		String weatherUrl =
				"https://api.open-meteo.com/v1/forecast"
						+ "?latitude=" + lat
						+ "&longitude=" + lon
						+ "&current_weather=true";

		return restTemplate.getForObject(weatherUrl, WeatherResponse.class);
	}
}
