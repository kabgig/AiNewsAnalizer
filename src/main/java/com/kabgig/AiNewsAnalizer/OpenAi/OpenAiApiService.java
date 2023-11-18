package com.kabgig.AiNewsAnalizer.OpenAi;

import static com.kabgig.AiNewsAnalizer.Utils.Logger.lgr;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.kabgig.AiNewsAnalizer.ApiKeys.LATOKEN;
import static com.kabgig.AiNewsAnalizer.ApiKeys.OPENAI_API_KEY;
import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;
import static java.time.Duration.ofSeconds;

@Service
public class OpenAiApiService {
    public String makeApiRequest(String prompt){
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(LATOKEN)
                .modelName(GPT_3_5_TURBO)
                .temperature(0.4)
                .timeout(ofSeconds(60))
                .logRequests(true)
                .logResponses(true)
                .build();
        //lgr().info("Nr of chars: " + prompt.length());
        //lgr().info("Nr of tokens: " + model.estimateTokenCount(prompt));
        String response = model.generate(prompt);
        return response;
    }
}
