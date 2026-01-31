package com.springai.promt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbi")
public class SbiBankController {
	
	private final ChatClient chatClient;
	
	public SbiBankController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@GetMapping("/chat")
	public String chat(@RequestParam String message) {
		
		String systemInstruction = "You are a helpful assistant specialized in banking services for SBI Bank customers.";
		
		return chatClient.prompt()
				.system(systemInstruction)
				.user(message)
				.call()
				.content();
	}		
	
}
