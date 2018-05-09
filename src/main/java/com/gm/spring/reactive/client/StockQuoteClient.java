package com.gm.spring.reactive.client;

import com.gm.spring.reactive.domain.StockQuote;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Setter
@Component
@ConfigurationProperties("gm")
public class StockQuoteClient {

    private String host;
    private String port;
    private String path;

    public Flux<StockQuote> getQuoteStream(){

        String url = "http://" + host + ":" + port;

        log.debug("Url Set is: " + url);

        return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(path)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(StockQuote.class);
    }
}
