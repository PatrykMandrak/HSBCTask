package com.mandrak.HSBCTask.controllers;

import com.mandrak.HSBCTask.models.Customer;
import com.mandrak.HSBCTask.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/api/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Optional<Customer> stock = customerService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    //Additional methods not included in requirements

/*    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        if (!customerService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customerService.save(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!customerService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        customerService.deleteById(id);

        return ResponseEntity.ok().build();
    }*/
}
