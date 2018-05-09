package com.gm.spring.reactive.repositories;

import com.gm.spring.reactive.domain.StockQuote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;


public interface StockQuoteRepository extends ReactiveMongoRepository<StockQuote, String> {

    @Tailable
    Flux<StockQuote> findWithTailableCursorBy(); //must be capped collection
}
