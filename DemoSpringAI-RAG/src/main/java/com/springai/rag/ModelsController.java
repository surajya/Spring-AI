package com.springai.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelsController {

	private final ChatClient chatClient;

	public ModelsController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}

	@GetMapping("/rag/models")
	public Models getModels(
			@RequestParam(value = "message", defaultValue = "give me list of model of goole genai") String message) {
		return chatClient.prompt()
				.user(message)
				.call()
				.entity(Models.class);
	}
}
