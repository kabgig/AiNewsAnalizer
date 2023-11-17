package com.kabgig.AiNewsAnalizer.OpenAi;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserInteractionService {
    @PostConstruct
    public void startInteraction(){
        System.out.println("User: ");
    }


}
