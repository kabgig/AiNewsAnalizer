package com.kabgig.AiNewsAnalizer.OpenAi;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.kabgig.AiNewsAnalizer.ApiKeys.OPENAI_API_KEY;
import static dev.langchain4j.model.openai.OpenAiModelName.GPT_3_5_TURBO;
import static java.time.Duration.ofSeconds;

@Service
public class OpenAiApiService {

    public void makeApiRequest(){
        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey(OPENAI_API_KEY)
                .modelName(GPT_3_5_TURBO)
                .temperature(0.4)
                .timeout(ofSeconds(60))
                .logRequests(true)
                .logResponses(true)
                .build();

        String prompt = "На сколько изменилась цена биткойна за 7 дней? " +
                "Объясни на основании новостей почему? " +
                "give me short brief 3 line response based on todays date " +
                LocalDateTime.now();

        String response = model.generate(prompt);

        System.out.println(response);
    }
}
