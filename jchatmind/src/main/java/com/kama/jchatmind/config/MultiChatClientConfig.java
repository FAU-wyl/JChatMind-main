package com.kama.jchatmind.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.zhipuai.ZhiPuAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiChatClientConfig {

//    @Value("${spring.ai.ollama.base-url}")
//    private String primaryBaseUrl;
//
//    @Value("${spring.ai.ollama.chat.model}")
//    private String primaryModel;
//
//    @Value("${custom.ollama-secondary.base-url}")
//    private String secondaryBaseUrl;
//
//    @Value("${custom.ollama-secondary.model}")
//    private String secondaryModel;
//
//    @Bean("deepseekOllamaChatModel")
//    public OllamaChatModel deepseekOllamaChatModel() {
//        return OllamaChatModel.builder()
//                .ollamaApi(OllamaApi.builder().baseUrl(primaryBaseUrl).build())
//                .defaultOptions(OllamaChatOptions.builder().model(primaryModel).build())
//                .build();
//    }
//
//    @Bean("qwenChatModel")
//    public OllamaChatModel qwenChatModel() {
//        return OllamaChatModel.builder()
//                .ollamaApi(OllamaApi.builder().baseUrl(secondaryBaseUrl).build())
//                .defaultOptions(OllamaChatOptions.builder().model(secondaryModel).build())
//                .build();
//    }
//
//    @Bean("deepseek-chat")
//    public ChatClient deepSeekChatClient(@Qualifier("deepseekOllamaChatModel") OllamaChatModel deepseekModel) {
//        return ChatClient.create(deepseekModel);
//    }
//
//    @Bean("glm-4.6")
//    public ChatClient secondaryChatClient(@Qualifier("qwenChatModel") OllamaChatModel qwenModel) {
//        return ChatClient.create(qwenModel);
//    }

    // zhipuai
//    @Bean("glm-4.6")
//    public ChatClient zhiPuAiChatClient(ZhiPuAiChatModel zhiPuAiChatModel) {
//        return ChatClient.create(zhiPuAiChatModel);
//    }
    @Bean("deepseek-chat")
    public ChatClient deepSeekChatClient(DeepSeekChatModel deepSeekChatModel) {
        return ChatClient.create(deepSeekChatModel);
    }

}
