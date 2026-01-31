package com.springai.memory;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoryControll {
 
	private final ChatClient chatClient;
	
	public MemoryControll(ChatClient.Builder builder, ChatMemory memory) {
		this.chatClient = builder
				.defaultAdvisors(MessageChatMemoryAdvisor.builder(memory).build())
				.build();
	}
	
	@GetMapping("/chat/memory")
	public String chatWithMemory(@RequestParam String message) {
		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}
}
