package io.github.adgross.stocksim.service;

import io.github.adgross.stocksim.event.StockQuoteUpdatedEvent;
import io.github.adgross.stocksim.model.StockQuote;
import io.github.adgross.stocksim.streaming.StockQuoteUpdatedSource;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockQuoteServiceImpl implements StockQuoteService {

  @Autowired
  StockQuoteUpdatedSource stockQuoteUpdatedSource;

  @Override
  public void update(StockQuote stockQuote) {
    log.info("M=update, stockquote={}", stockQuote);

    final var event = StockQuoteUpdatedEvent.newBuilder()
        .setValue(stockQuote.getValue())
        .build();
    stockQuoteUpdatedSource.output().send(
        MessageBuilder.withPayload(event).build()
    );
  }
}
