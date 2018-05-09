package com.gm.spring.reactive.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Document
public class StockQuote {

    @Id
    private String id;
    private String ticker;
    private BigDecimal price;
    private Instant instant;
}
