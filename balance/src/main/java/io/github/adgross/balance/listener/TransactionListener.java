package io.github.adgross.balance.listener;

import io.github.adgross.balance.model.Transaction;
import io.github.adgross.balance.service.BalanceService;
import io.vertx.kafka.client.serialization.JsonObjectDeserializer;
import io.vertx.kafka.client.serialization.JsonObjectSerializer;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;

@ApplicationScoped
public class TransactionListener {

  private final Logger log = Logger.getLogger(TransactionListener.class.getName());
  private final BalanceService balanceService;

  @Inject
  public TransactionListener(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  @Produces
  public Topology onTransactionTopology() {
    var builder = new StreamsBuilder();
    builder.stream("transactions",
        Consumed.with(Serdes.String(),
            Serdes.serdeFrom(
                new JsonObjectSerializer(),
                new JsonObjectDeserializer())))
        .foreach((unused, value) -> {
          log.info("Receiving transaction " + value);
          var transaction = Transaction.ofMap(value.getMap());
          var newBalance = balanceService.recalculate(transaction);
          log.info("New balance " + newBalance);
        });
    return builder.build();
  }
}
