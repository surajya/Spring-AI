package com.springai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	// Add your chat handling methods here
	@GetMapping("/chat")
	public String chat() {
		return chatClient.prompt()
				.user("Tell me about spring ai in one line")
				.call()
				.content();
	}
}
