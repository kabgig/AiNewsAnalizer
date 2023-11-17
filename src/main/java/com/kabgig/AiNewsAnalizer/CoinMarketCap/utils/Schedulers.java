package com.kabgig.AiNewsAnalizer.CoinMarketCap.utils;

import com.kabgig.AiNewsAnalizer.CoinMarketCap.service.CoinMarketCapService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.kabgig.AiNewsAnalizer.Utils.Logger.lgr;

@Component
//@EnableScheduling
public class Schedulers {
    @Autowired
    private CoinMarketCapService coinMarketCapService;

    @PostConstruct //or @Bean
    //@Scheduled(cron = "0 0 */5 * * *")
    public void dbRefresh() {
        if (!coinMarketCapService.isCurrentdate()) {
            coinMarketCapService.updateDatabase();
            lgr().info("EXECUTED DAILY DATABASE REFRESH");
        }
    }
}
