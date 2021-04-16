package io.github.adgross.banksim.listener;

import io.github.adgross.banksim.streaming.StockQuoteUpdatedSink;
import io.github.adgross.stocksim.event.StockQuoteUpdatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StockQuoteListener {

  @StreamListener(StockQuoteUpdatedSink.INPUT)
  public void handler(StockQuoteUpdatedEvent stockQuoteUpdatedEvent) {
    log.info("stockQuoteUpdatedEvent={}", stockQuoteUpdatedEvent);
  }
}
