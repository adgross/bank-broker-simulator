package io.github.adgross.stocksim.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StockQuoteUpdatedSource {

  String OUTPUT = "stockquote-updated-output";

  @Output(OUTPUT)
  MessageChannel output();
}
