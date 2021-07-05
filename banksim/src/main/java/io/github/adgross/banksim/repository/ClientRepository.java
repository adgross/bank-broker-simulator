package io.github.adgross.banksim.repository;

import io.github.adgross.banksim.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
