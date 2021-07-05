package io.github.adgross.banksim;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.github.adgross.stocksim.event.StockQuoteUpdatedEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankSimApplication {

  public static void main(String[] args) {
    SpringApplication.run(BankSimApplication.class, args);
  }

  @Bean
  public Serde<StockQuoteUpdatedEvent> avroInSerde() {
    final SpecificAvroSerde<StockQuoteUpdatedEvent> avroInSerde = new SpecificAvroSerde<>();
    Map<String, Object> serdeProperties = new HashMap<>();
    return avroInSerde;
  }

  @Bean
  public Consumer<KStream<StockQuoteUpdatedEvent, StockQuoteUpdatedEvent>> stockQuoteListener() {
    return input -> {
      input.peek(((key, value) -> System.out.println(" value: " + value.toString())));
    };
  }
}
