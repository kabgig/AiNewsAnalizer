package com.kabgig.AiNewsAnalizer.CoinMarketCap.repository;

import com.kabgig.AiNewsAnalizer.CoinMarketCap.entity.CurrentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentDataRepository extends JpaRepository<CurrentData,Long> {
    CurrentData findBySymbol(String symbol);

}
