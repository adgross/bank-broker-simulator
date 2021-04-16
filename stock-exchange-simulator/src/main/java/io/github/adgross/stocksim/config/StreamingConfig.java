package io.github.adgross.stocksim.config;

import io.github.adgross.stocksim.streaming.StockQuoteUpdatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
    StockQuoteUpdatedSource.class
})
public class StreamingConfig {
}
