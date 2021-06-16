package io.github.adgross.stocksim;

import io.github.adgross.stocksim.event.StockQuoteUpdatedEvent;
import io.github.adgross.stocksim.util.StockQuoteGenerator;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class StockSimApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockSimApplication.class, args);
  }

  @Bean
  public Supplier<StockQuoteUpdatedEvent> generator() {
    return () -> {
      var stockQuote = StockQuoteGenerator.next();
      var stockQuoteUpdatedEvent = StockQuoteUpdatedEvent.newBuilder()
          .setValue(stockQuote.getValue())
          .build();
      log.info("stockQuote={}", stockQuote);
      log.info("stockQuoteUpdatedEvent={}", stockQuoteUpdatedEvent);
      return stockQuoteUpdatedEvent;
    };
  }

}
