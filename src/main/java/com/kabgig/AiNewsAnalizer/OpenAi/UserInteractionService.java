package com.kabgig.AiNewsAnalizer.OpenAi;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserInteractionService {
    @Bean
    public void startInteraction(){
        System.out.print("User: ");
    }
}
