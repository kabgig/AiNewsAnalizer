package com.kabgig.AiNewsAnalizer.GNews;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.kabgig.AiNewsAnalizer.ApiKeys.GNEWS_API;

@Service
public class GNewsService {

    private final RestTemplate restTemplate;
    private final Gson gson;

    @Autowired
    public GNewsService(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public String getNews(String currencyName) {
        String formatedDate = getDateTime(90);
        String newsResponse = "-------'''news''':\n";
        String response = "{\"totalArticles\":29,\"articles\":[{\"title\":\"Grayscale Bitcoin Trust: Lightening But Still Long\",\"description\":\"Discover the latest in Bitcoin news as its price skyrockets in 2023, with insights on Grayscale Bitcoin Trust's performance. Click here to read my analysis.\",\"content\":\"IgorIgorevich/iStock Editorial via Getty Images\\nBitcoin (BTC-USD) has been on a rocket in 2023. Year to date, the price of BTC has essentially doubled. And the performance since mid-September has been particularly impressive as well with BTC moving f... [7154 chars]\",\"url\":\"https://seekingalpha.com/article/4652740-grayscale-bitcoin-trust-lightening-but-still-long\",\"image\":\"https://static.seekingalpha.com/cdn/s3/uploads/getty_images/1398658467/image_1398658467.jpg?io=getty-c-w1536\",\"publishedAt\":\"2023-11-17T19:17:10Z\",\"source\":{\"name\":\"Seeking Alpha\",\"url\":\"https://seekingalpha.com\"}},{\"title\":\"Decentralization and Security: How Bitcoin's Blockchain Achieves Trustworthiness\",\"description\":\"Read more about Decentralization and Security: How Bitcoin's Blockchain Achieves Trustworthiness on Devdiscourse\",\"content\":\"In the digital currency realm, Bitcoin stands out, not merely for its pioneering status but for its unique blend of decentralization and security. These twin pillars serve as the bedrock of its unparalleled trustworthiness. As Bitcoin's blockchain gr... [5158 chars]\",\"url\":\"https://www.devdiscourse.com/article/business/2715770-decentralization-and-security-how-bitcoins-blockchain-achieves-trustworthiness\",\"image\":\"https://www.devdiscourse.com/remote.axd?https://devdiscourse.blob.core.windows.net/devnews/17_11_2023_10_30_35_9822337.jpg?width=920&format=jpeg\",\"publishedAt\":\"2023-11-17T05:01:31Z\",\"source\":{\"name\":\"Devdiscourse\",\"url\":\"https://www.devdiscourse.com\"}},{\"title\":\"Next Bitcoin Halving is Looming: Can it Propel the Crypto to New Highs?\",\"description\":\"Market Analysis by Marc Munier covering: Bitcoin Futures CME, Bitcoin. Read Marc Munier's Market Analysis on Investing.com\",\"content\":\"BTC/USD +1.38% Add to/Remove from Watchlist\\n4th Halving is on April 24th, 2024 - in about 5 months.\\nWhat should you make of it?\\nWhat is Bitcoin Halving?\\nBitcoin halving is an event that happens approximately every four years where the reward for mini... [3949 chars]\",\"url\":\"https://www.investing.com/analysis/next-bitcoin-halving-is-looming-200643701\",\"image\":\"https://i-invdn-com.investing.com/redesign/images/seo/investingcom_analysis_og.jpg\",\"publishedAt\":\"2023-11-17T05:00:00Z\",\"source\":{\"name\":\"Investing.com\",\"url\":\"https://www.investing.com\"}},{\"title\":\"Bitcoin wallet vulnerability revealed in old Blockchain wallets\",\"description\":\"A new vulnerability in certain old Bitcoin wallets means it's open season for hackers.\",\"content\":\"One of the best articles I read this week was a Washington Post report that revealed how some Bitcoin wallets from the pre-2016 era have a major vulnerability that could let hackers guess their private key, which is the password that controls the wal... [3802 chars]\",\"url\":\"https://fortune.com/crypto/2023/11/17/early-bitcoin-wallets-flaw-hacker-vulnerability-exposed/\",\"image\":\"https://content.fortune.com/wp-content/uploads/2023/11/bitcoin-hacked-11-17-23-e1700237672878.jpg?resize=1200,600\",\"publishedAt\":\"2023-11-17T05:00:00Z\",\"source\":{\"name\":\"Fortune\",\"url\":\"https://fortune.com\"}},{\"title\":\"Bitcoin falls 4.94% to $36,007\",\"description\":\"Bitcoin dropped 4.94% to $36,007 at 2117 GMT on Thursday, losing $1,870 from its previous close.\",\"content\":\"A representation of cryptocurrency bitcoin is seen in front of a stock graph and U.S. dollar in this illustration taken, January 24, 2022. REUTERS/Dado Ruvic/File Photo Acquire Licensing Rights\\nNov 16 (Reuters) - Bitcoin dropped 4.94% to $36,007 at 2... [436 chars]\",\"url\":\"https://www.reuters.com/technology/bitcoin-falls-494-36007-2023-11-16/\",\"image\":\"https://www.reuters.com/resizer/o--ZjBYwKniE8QdQAKTZuoq4dwk=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/N6QV3YJHDZJDFJX2Y3A6ILORD4.jpg\",\"publishedAt\":\"2023-11-16T21:45:21Z\",\"source\":{\"name\":\"Reuters\",\"url\":\"https://www.reuters.com\"}},{\"title\":\"Bitcoin ICO Stands Strong in the Crypto Market\",\"description\":\"Bitcoin Spark's ICO stands resolute, offering a beacon of stability and innovation\",\"content\":\"Bitcoin, the pioneer of this fast-paced financial revolution, has witnessed highs and lows in its 15-year reign. The digital assets' fate in this fast-paced crypto world is uncertain, but amid this volatile landscape, Bitcoin Spark's ICO stands resol... [4460 chars]\",\"url\":\"https://www.livemint.com/brand-stories/bitcoin-ico-stands-strong-in-the-crypto-market-11695918963673.html\",\"image\":\"https://www.livemint.com/lm-img/img/2023/11/16/1600x900/Screenshot_2023-11-16_172522_1700135855324_1700135861641.png\",\"publishedAt\":\"2023-11-16T18:30:00Z\",\"source\":{\"name\":\"Livemint\",\"url\":\"https://www.livemint.com\"}},{\"title\":\"Dogecoin, Tron and Bitcoin Spark in the Crypto Market 2023\",\"description\":\"Learn more about Dogecoin, Tron and Bitcoin Spark in the crypto market\",\"content\":\"Dogecoin, Tron, and Bitcoin Spark have experienced significant interest in the crypto market. This article covers how DOGE, TRX, and BTCS have caught the attention of crypto enthusiasts.\\nDogecoin\\nDogecoin (DOGE) was reportedly seeing a strong price p... [2345 chars]\",\"url\":\"https://www.livemint.com/brand-stories/dogecoin-tron-and-bitcoin-spark-in-the-crypto-market-2023-11695918963305.html\",\"image\":\"https://www.livemint.com/lm-img/img/2023/11/16/1600x900/Screenshot_2023-11-16_172136_1700135552225_1700135561098.png\",\"publishedAt\":\"2023-11-16T18:30:00Z\",\"source\":{\"name\":\"Livemint\",\"url\":\"https://www.livemint.com\"}},{\"title\":\"How Jane Street-backed ZetaChain aims to expand Bitcoin's use cases\",\"description\":\"Despite its dominant market share in the crypto sphere, Bitcoin has had limited applications compared to other blockchains which have blossomed to\",\"content\":\"Despite its dominant market share in the crypto sphere, Bitcoin has had limited applications compared to other blockchains which have blossomed to facilitate asset transfers in everything from financial products to video games.\\nEthereum, for example,... [2762 chars]\",\"url\":\"https://techcrunch.com/2023/11/16/zetachain-bitcoin-trading/\",\"image\":\"https://techcrunch.com/wp-content/uploads/2023/10/GettyImages-1366240594.jpg?resize=1200,800\",\"publishedAt\":\"2023-11-16T18:10:44Z\",\"source\":{\"name\":\"TechCrunch\",\"url\":\"https://techcrunch.com\"}},{\"title\":\"Unveiling the enigmatic Bitcoin ecosystem: A roadmap through cryptocurrency's unusual alliances\",\"description\":\"Bitcoin, since its inception in 2009, has grown to become a global phenomenon, revolutionizing the way we perceive and utilize money. It operates on a\",\"content\":\"Bitcoin, since its inception in 2009, has grown to become a global phenomenon, revolutionizing the way we perceive and utilize money. It operates on a decentralized network, removing the need for intermediaries and offering a level of transparency an... [5398 chars]\",\"url\":\"https://www.androidheadlines.com/2023/11/unveiling-the-enigmatic-bitcoin-ecosystem-a-roadmap-through-cryptocurrencys-unusual-alliances.html\",\"image\":\"https://www.androidheadlines.com/wp-content/uploads/2022/08/Bitcoin-image-8394389348.jpg\",\"publishedAt\":\"2023-11-16T11:05:50Z\",\"source\":{\"name\":\"Android Headlines\",\"url\":\"https://www.androidheadlines.com\"}},{\"title\":\"Untapped crypto realms: Bitcoin's synergy with unconventional Altcoins\",\"description\":\"The world of cryptocurrency has come a long way since the inception of Bitcoin in 2009. While Bitcoin remains the flagship cryptocurrency, the crypto\",\"content\":\"The world of cryptocurrency has come a long way since the inception of Bitcoin in 2009. While Bitcoin remains the flagship cryptocurrency, the crypto landscape has expanded to include thousands of alternative cryptocurrencies, often referred to as “a... [8734 chars]\",\"url\":\"https://www.androidheadlines.com/2023/11/untapped-crypto-realms-bitcoins-synergy-with-unconventional-altcoins.html\",\"image\":\"https://www.androidheadlines.com/wp-content/uploads/2022/07/Cryptocurrency-image-2839298239.jpg\",\"publishedAt\":\"2023-11-16T09:06:25Z\",\"source\":{\"name\":\"Android Headlines\",\"url\":\"https://www.androidheadlines.com\"}}]}\n";
        String url = "https://gnews.io/api/v4/search?q=" + currencyName + "&lang=en&in=title,description&sortby=publishedAt&from=" + formatedDate + "&apikey=" + GNEWS_API;
        response = restTemplate.getForObject(url, String.class);

        JsonObject jsonResponse = gson.fromJson(response, JsonObject.class);

        JsonArray articlesArray = jsonResponse.getAsJsonArray("articles");
        for (int i = 0; i < articlesArray.size(); i++) {
            JsonObject article = articlesArray.get(i).getAsJsonObject();
            String title = article.get("title").getAsString();
            String content = article.get("content").getAsString();

            newsResponse += title + "\n";
            newsResponse += content + "\n\n";
        }
        return newsResponse + "----------- END OF NEWS";
    }

    private String getDateTime(int amountOfDaysAgo) {
        LocalDateTime date = LocalDateTime.now().minusDays(amountOfDaysAgo);

        // Define the desired date-time pattern
        String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";

        // Create a DateTimeFormatter with the specified pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        // Format the LocalDateTime using the formatter
        return date.format(formatter);
    }
}
