package com.gm.spring.reactive.service;

import com.gm.spring.reactive.client.StockQuoteClient;
import com.gm.spring.reactive.domain.StockQuote;
import com.gm.spring.reactive.repositories.StockQuoteRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Classical Spring specify way of filling MangoDB to setup test data
 */
@Service
public class StockQuoteMonitorService implements ApplicationListener<ContextRefreshedEvent> {

    private final StockQuoteClient stockQuoteClient;
    private final StockQuoteRepository stockQuoteRepository;

    public StockQuoteMonitorService(StockQuoteClient stockQuoteClient, StockQuoteRepository stockQuoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.stockQuoteRepository = stockQuoteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        stockQuoteClient.getQuoteStream()
                .log("quote-monitor-service")
                .subscribe(stockQuote -> {
                    Mono<StockQuote> savedQuote = stockQuoteRepository.save(stockQuote);

                    System.out.println("I saved a stockQuote! Id: " +savedQuote.block().getId());
                });
    }
}
