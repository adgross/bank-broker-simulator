package io.github.adgross.balance.controller;

import io.github.adgross.balance.service.BalanceService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/balances")
public class BalanceController {

  private final BalanceService balanceService;

  @Inject
  public BalanceController(BalanceService balanceService) {
    this.balanceService = balanceService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  //@Transactional
  public Response findByAccountId(@QueryParam("account") String account) {
    return balanceService.findByAccount(account)
        .map(balance -> Response.ok(balance).build())
        .orElseThrow(IllegalArgumentException::new);
  }

}
