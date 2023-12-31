CREATE TABLE current_data (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    symbol VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL,
    cmc_rank INT NOT NULL,
    num_market_pairs INT NOT NULL,
    circulating_supply DOUBLE NOT NULL,
    total_supply DOUBLE NOT NULL,
    max_supply DOUBLE,
    infinite_supply TINYINT(1) NOT NULL,
    last_updated DATETIME NOT NULL,
    date_added DATETIME NOT NULL,
    tags VARCHAR(255),
    usd_price DOUBLE NOT NULL,
    usd_volume24h DOUBLE NOT NULL,
    usd_volume_change24h DOUBLE NOT NULL,
    usd_percent_change1h DOUBLE NOT NULL,
    usd_percent_change24h DOUBLE NOT NULL,
    usd_percent_change7d DOUBLE NOT NULL,
    usd_market_cap DOUBLE NOT NULL,
    usd_market_cap_dominance INT NOT NULL,
    usd_fully_diluted_market_cap DOUBLE NOT NULL,
    usd_last_updated DATETIME NOT NULL
);
