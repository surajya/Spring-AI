package com.springai.multimodality;


import java.io.IOException;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageDetection {
	
	private final ChatClient chatClient;
	
	public ImageDetection(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@Value("classpath:images/carImage.jpg")
	Resource imageResource;
	
	@GetMapping("/image/detect")
	public String detectObjectsInImage() throws IOException {
		// Placeholder for image detection logic
		return chatClient.prompt()
				.user( u -> 	{
						u.text("Analyze the image and identify the objects present with discription.")
						.media(MimeTypeUtils.IMAGE_JPEG, imageResource);
				})
				.call()
				.content();
		
	}
	
}
