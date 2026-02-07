package com.springai.tools.weather.dto;


import java.util.List;

public class GeoResponse {

	private List<Result> results;

	public List<Result> getResults() {
		return results;
	}

	public static class Result {

		private double latitude;
		private double longitude;

		public double getLatitude() {
			return latitude;
		}

		public double getLongitude() {
			return longitude;
		}
	}
}

