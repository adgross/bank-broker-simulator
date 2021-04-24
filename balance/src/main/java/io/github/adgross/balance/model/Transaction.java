package io.github.adgross.balance.model;

import java.util.Map;

public class Transaction {

  private final String account;
  private final Long value;

  public Transaction(String account, Long value) {
    this.account = account;
    this.value = value;
  }

  public String getAccount() {
    return account;
  }

  public Long getValue() {
    return value;
  }

  public static Transaction ofMap(Map<String, Object> map) {
    return new Transaction(
        map.get("account").toString(),
        Long.parseLong(map.get("value").toString())
    );
  }
}
