package com.kabgig.AiNewsAnalizer.OpenAi;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AiPrompt {
    public String userinput =
            "На сколько изменилась цена биткоин за 7 дней? " +
            "Объясни на основании новостей почему? ";

    public String initPrompt =
            "You are cryptocurrency news advisor " +
                    "Based on the following user input:'''" + userinput + "''' you identify, " +
                    "which cryptocurrency user is talking about. " +
                    "Identify name and symbol of cryptocurrency." +
                    "Provide response strictly in the following format:" +
                    "'''CurrencyName:CurrencySymbol''', without delimiter('''), " +
                    "for example Bitcoin:BTC";
    public String secondPrompt =
            "You are cryptocurrency advisor." +
                    "Based on '''cryptoCurrencyInfo''' and '''news'''" +
                    "generate 5-10 line answer to the following question: " + userinput + "\n";

}

