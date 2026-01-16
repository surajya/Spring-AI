package com.springai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
//@AllArgsConstructor
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	// Add your chat handling methods here
	@GetMapping("/chat")
	public String chat() {
		return chatClient.prompt()
				.user("what is today date")
				.call()
				.content();
	}
	
	@GetMapping("/stream")
	public Flux<String> stream() {
		return chatClient.prompt()
				.user("tell me a joke")
				.stream()
				.content();
	}
	
	@GetMapping("/chat-response")
	public ChatResponse chatResponse() {
		return chatClient.prompt()
				.user("what is today date")
				.call()
				.chatResponse();
	}
}
