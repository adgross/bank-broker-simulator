package io.github.adgross.balance.service;

import io.github.adgross.balance.model.Balance;
import io.github.adgross.balance.model.Transaction;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BalanceServiceImpl implements BalanceService {

  @Override
  public Optional<Balance> findByAccount(String account) {
    var balance = new Balance();
    balance.account = account;
    balance.value = 1_000_00_00L;

    return Optional.of(balance);
  }

  @Override
  public Balance recalculate(Transaction transaction) {
    var balance = new Balance();
    balance.account = transaction.getAccount();
    balance.value = transaction.getValue();
    return balance;
  }
}
