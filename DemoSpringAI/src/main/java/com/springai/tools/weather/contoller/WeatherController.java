package com.springai.tools.weather.contoller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springai.tools.weather.tools.WeatherTools;

@RestController
public class WeatherController {

	private final ChatClient chatClient;
	private final WeatherTools weatherTools;

	public WeatherController(ChatClient.Builder builder, WeatherTools weatherTools) {
		this.chatClient = builder.build();
		this.weatherTools = weatherTools;
	}

	@GetMapping("/weather")
	public String weather(@RequestParam String city) {

		return chatClient
				.prompt("What is the current weather in " + city + "?")
				.tools(weatherTools)
				.call()
				.content();
	}
}

