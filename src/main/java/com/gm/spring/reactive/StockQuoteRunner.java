package com.gm.spring.reactive;

import com.gm.spring.reactive.client.StockQuoteClient;
import com.gm.spring.reactive.domain.StockQuote;
import com.gm.spring.reactive.repositories.StockQuoteRepository;
import org.springframework.boot.CommandLineRunner;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

/**
 * Spring BOOT specify way of filling MangoDB to setup test data
 */
//@Component
public class StockQuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;
    private final StockQuoteRepository repository;

    public StockQuoteRunner(StockQuoteClient stockQuoteClient, StockQuoteRepository repository) {
        this.stockQuoteClient = stockQuoteClient;
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Flux<StockQuote> quoteFlux = repository.findWithTailableCursorBy();

        Disposable disposable = quoteFlux.subscribe(stockQuote -> {
            System.out.println("*#*#*#*#*#*#*#*#*#*#*#*#* Id: " + stockQuote.getId());
        });

        disposable.dispose();
    }
}
