package com.springai.output;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VocationTrip {

	private final ChatClient chatClient;
	
	public VocationTrip(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@GetMapping("/vocation/unstructured")
	public String generateVocationTrip() {
		return chatClient.prompt()
				.user("Plan a vacation trip to a tropical island with beaches, adventure activities, and local culture.")
				.call()
				.content();
	}
	
	@GetMapping("/vocation/structured")
	public Itinerary generateStructuredVocationTrip() {
		return chatClient.prompt()
				.user("Create a 5-day vacation itinerary to a tropical island with beaches, adventure activities, and local culture.")
				.call()
				.entity(Itinerary.class);
	}
}
