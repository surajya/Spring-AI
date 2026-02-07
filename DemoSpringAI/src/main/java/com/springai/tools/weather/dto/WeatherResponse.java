package com.springai.tools.weather.dto;


public class WeatherResponse {

	private CurrentWeather current_weather;

	public CurrentWeather getCurrent_weather() {
		return current_weather;
	}

	public static class CurrentWeather {

		private double temperature;
		private double windspeed;
		private int weathercode;

		public double getTemperature() {
			return temperature;
		}

		public double getWindspeed() {
			return windspeed;
		}

		public int getWeathercode() {
			return weathercode;
		}
	}
}
