package io.github.adgross.stocksim.util;

import io.github.adgross.stocksim.model.StockQuote;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StockQuoteGenerator {

  private static StockQuote current = new StockQuote(0L, 1000000L);
  private static final Random rnd = new Random();

  public static StockQuote next() {
    var range = 1000000; // 100,00(00), [-100, +100] money unit
    var rndValue = rnd.nextLong() % range;
    var currentValue = current.getValue();

    // force swap rndValue if needed, so operation don't pass 0 or Long.MAX_VALUE
    if (rndValue > 0) {
      if (Long.MAX_VALUE - rndValue < currentValue) {
        rndValue = -rndValue;
      }
    } else if (currentValue + rndValue < 0) {
      rndValue = -rndValue;
    }

    log.info("StockQuote change: " + rndValue);
    current = new StockQuote(current.getId() + 1, current.getValue() + rndValue);
    return current;
  }
}
