package com.kabgig.AiNewsAnalizer.OpenAi;

import com.kabgig.AiNewsAnalizer.CoinMarketCap.entity.CurrentData;
import com.kabgig.AiNewsAnalizer.CoinMarketCap.service.CoinMarketCapService;
import com.kabgig.AiNewsAnalizer.GNews.GNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static com.kabgig.AiNewsAnalizer.Utils.Logger.lgr;

@Component
public class UserInteractionService {
    @Autowired
    private AiPrompt aiPrompt;
    @Autowired
    private OpenAiApiService openAiApiService;
    @Autowired
    private CoinMarketCapService coinMarketCapService;
    @Autowired
    private GNewsService gNewsService;

    @Bean
    public void AiScripFlow() {

        //1st Prompt
        String prompt = aiPrompt.getInitPrompt();
        String currency = openAiApiService.makeApiRequest(prompt);
        lgr().info("Identified coin: " + currency);

        //Processing coin name
        String[] split = currency.split(":");
        String currencyName = split[0].trim().toLowerCase();
        String currencySymbol = split[1].trim().toUpperCase();

        //Getting coin data
        CurrentData coinData = coinMarketCapService.getOneCoinBySymbol(currencySymbol);
        String coindata = "-----'''cryptoCurrencyInfo''':\n" + coinData.toString();
        System.out.println(formatString(coindata, 80));

        // Getting news
        String news = gNewsService.getNews(currencyName);
        System.out.println(formatString(news, 80));

        // 2nd Prompt
        String secondPrompt =
                aiPrompt.getSecondPrompt() + news + coinData;
        //System.out.println(secondPrompt);
        String response = openAiApiService.makeApiRequest(secondPrompt);
        System.out.println("\nAI FINAL RESPONSE:\n" + formatString(response, 80));

    }

    private static String formatString(String input, int lineLength) {
        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < input.length(); i += lineLength) {
            int end = Math.min(i + lineLength, input.length());
            formattedString.append(input, i, end);
            formattedString.append(System.lineSeparator());
        }

        return formattedString.toString();
    }
}
