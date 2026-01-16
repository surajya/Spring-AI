package com.springai.promt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

	private final ChatClient chatClient;
	
	public ArticleController(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@GetMapping("/article/post")
	public String generateArticle(@RequestParam(value = "topic", defaultValue = "jdk-25") String topic) {
		
		String systemInstruction =
	            "You are a senior technology writer and industry analyst who creates well-researched, clear, and engaging " +
	                    "articles on software engineering and technology trends. Your writing is accurate, structured, and tailored " +
	                    "for a professional technical audience.";
		
		return chatClient.prompt()
				.system(systemInstruction)
				.user(u -> {
					u.text("write a blog post me about {topic}");
					u.param("topic", topic);
				})
				.call()
				.content();
	}
}
