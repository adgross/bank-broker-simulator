package io.github.adgross.banksim.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StockQuoteUpdatedSink {

  String INPUT = "stockquote-updated-input";

  @Input(INPUT)
  SubscribableChannel input();
}
