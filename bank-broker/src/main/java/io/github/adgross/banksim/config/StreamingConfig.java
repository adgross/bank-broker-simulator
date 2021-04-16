package io.github.adgross.banksim.config;

import io.github.adgross.banksim.streaming.StockQuoteUpdatedSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(StockQuoteUpdatedSink.class)
public class StreamingConfig {
}
