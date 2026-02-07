package com.springai.tools.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
class DateTimeTools {

	@Tool(description = "Returns the current system date and time. Use this tool whenever the user asks about time, dates, scheduling, alarms, or time-based calculations.")
	String getCurrentDateTime() {
		return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();
	}

	@Tool(description = "Set a user alarm for the given time, provided in ISO-8601 format")
	void setAlarm(String time) {
		LocalDateTime alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("Alarm set for " + alarmTime);
	}

	@Tool(
			description = "Returns the current weather information for a given city. " +
					"Use this tool whenever the user asks about temperature, weather, climate, rain, or forecast.")
	public String getCurrentWeather(String city) {

		// 🔹 For demo purposes (replace with real API call)
		return String.format(
				"Current weather in %s: Temperature 28°C, Clear sky, Humidity 60%%, Wind 10 km/h",
				city);
	}

}
