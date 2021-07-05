package io.github.adgross.banksim.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whoami")
public class WhoAmI {

  @GetMapping
  public String getAddress() throws UnknownHostException {
    var ip = InetAddress.getLocalHost();
    return "Iam the server " + ip;
  }
}
