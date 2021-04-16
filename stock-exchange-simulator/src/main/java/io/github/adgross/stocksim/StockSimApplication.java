package io.github.adgross.stocksim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StockSimApplication {

  public static void main(String[] args) {
    SpringApplication.run(StockSimApplication.class, args);
  }

}
