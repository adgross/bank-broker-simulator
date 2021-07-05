package io.github.adgross.stocksim.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class StockQuote {

  Long id;
  Long value;
}
