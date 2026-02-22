package dev.danvega.spring_io_mcp;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//System.out.println("Spring IO MCP is running...");
	}

	@Bean
	public List<ToolCallback> springIOSessionTools(SessionTools sessionTools) {
		return List.of(ToolCallbacks.from(sessionTools));
	}
}
