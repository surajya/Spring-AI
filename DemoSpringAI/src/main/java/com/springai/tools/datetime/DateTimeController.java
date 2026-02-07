package com.springai.tools.datetime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {

	private final ChatClient chatClient;

	DateTimeController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/datetime")
	public String getCurrentDateTime() {
		return chatClient.prompt("What day will be tomorrow?")
				.tools(new DateTimeTools())
				.call()
				.content();
	}

	@GetMapping("/set-alarm")
	public String setAlarm() {
		return chatClient.prompt("Use the available tools to determine the current time.\r\n"
				+ "Add 10 minutes to it.\r\n"
				+ "Then set an alarm using ISO-8601 format.")
				.tools(new DateTimeTools())
				.call()
				.content();
	}

	@GetMapping("/weather-mini")
	public String getWeather(@RequestParam String city) {

		return chatClient.prompt(
				"What is the current weather in " + city + "?")
				.tools(new DateTimeTools())
				.call()
				.content();
	}
}
