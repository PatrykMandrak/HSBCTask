package com.mandrak.HSBCTask.repositories;

import com.mandrak.HSBCTask.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
