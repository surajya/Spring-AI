package com.springai.byod;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelComparison {
	
	private final ChatClient chatClient;
	
	ModelComparison(ChatClient.Builder builder) {
		this.chatClient = builder.build();
	}
	
	@GetMapping("/models")
	public String compareModels() {
		String prompt = "Can you give me up to date list popular large language models and their current context window?";
		
		return chatClient.prompt()
				.user(prompt)
				.call()
				.content();
	}
	
	@GetMapping("/models/stuff-details")
	public String compareModelsWithDetails() {
		String systemMessage = "any one asked up to date list popular large language models and their current context window?"
				+ "1) OpenAI Models\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "GPT-5	OpenAI	~400,000 tokens total (272K input + 128K output)	Large unified reasoning model with expanded context for deep tasks.\r\n"
				+ "GPT-4.1	OpenAI	~1,000,000 tokens	Released successor to GPT-4o with vastly expanded context.\r\n"
				+ "GPT-4o (legacy)	OpenAI	~128,000 tokens	Previous flagship multimodal; still widely used.\r\n"
				+ "GPT-oss-120B / 20B (open-weight)	OpenAI	~131,072 tokens	Open-weight models optimized for consumer GPUs.\r\n"
				+ "🔹 2) Anthropic (Claude) Family\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "Claude Sonnet 4	Anthropic	~1,000,000 tokens	Extended context, strong for enterprise document tasks.\r\n"
				+ "Claude Opus 4.1	Anthropic	~200,000 tokens	High-capability reasoning.\r\n"
				+ "Claude 2.1 (older)	Anthropic	~200,000 tokens	Earlier model variant.\r\n"
				+ "🔹 3) Google / DeepMind (Gemini & Gemma)\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "Gemini 2.5 Pro / Flash	Google DeepMind	~1,000,000+ tokens	Long-context multimodal capabilities.\r\n"
				+ "Gemini 1.5	Google DeepMind	>1,000,000 tokens (reported)	Early next-gen long-context variant.\r\n"
				+ "Gemma family (small open models)	Google DeepMind	~8,000 tokens (base)	Lightweight text-only models.\r\n"
				+ "🔹 4) Meta (Llama / LLaMA)\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "Llama 4 Scout	Meta	~10,000,000 tokens	Currently largest reported public context window.\r\n"
				+ "Llama 4 Maverick	Meta	~1,000,000 tokens	High-capability variant in the Llama 4 line.\r\n"
				+ "Llama 3 / 3.1 / 3.3	Meta	~variable (commonly 128K or less)	Earlier Llama variants; long-context depends on variant.\r\n"
				+ "🔹 5) xAI (Grok) Models\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "Grok-4 (latest generation)	xAI	Not publicly standardized	Context not widely published; latest Grok generation focuses on reasoning & coding.\r\n"
				+ "Grok-1.5 (older)	xAI	~128,000 tokens	Earlier step-change in long context.\r\n"
				+ "Grok-1	xAI	~8,192 tokens	First mainstream release.\r\n"
				+ "🔹 6) Other / Long-Context Models\r\n"
				+ "Model	Developer	Context Window	Notes\r\n"
				+ "Qwen3-Coder / Thinking	Alibaba	~262,000 tokens	Strong extended context & reasoning options.\r\n"
				+ "DeepSeek-R1	DeepSeek	~164,000 tokens	Premium reasoning with long context.\r\n"
				+ "MiniMax-Text-01	Startup (report)	~4,000,000 tokens	Reported ultra-long open LLM (subject to evolving claims).";
		
		return chatClient.prompt()
				.user("Can you give me up to date list popular large language models and their current context window? in json format.")
				.system(systemMessage)
				.call()
				.content();
	}
	
}
