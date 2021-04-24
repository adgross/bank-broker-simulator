package io.github.adgross.balance.service;

import io.github.adgross.balance.model.Balance;
import io.github.adgross.balance.model.Transaction;
import java.util.Optional;
import javax.transaction.Transactional;

public interface BalanceService {

  Optional<Balance> findByAccount(String account);

  //@Transactional
  Balance recalculate(Transaction transaction);
}
