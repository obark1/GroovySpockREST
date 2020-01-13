package com.example.demo8min

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/api/customer')
@Slf4j
class CustomerController {

    @Autowired
    CustomerRepository repository

    @GetMapping
    List<Customer> getCustomers() {
        return repository.findAll()
    }

    @GetMapping('/{id}')
    Customer getCustomer(@PathVariable Long id)
    {return repository.findById(id).orElse(null)}

    @PostMapping
    void saveCustomer(@RequestBody Customer customer) {
        repository.save(customer)
        log.info("Succesfully saved customer $customer")
    }

    @DeleteMapping('/{id}')
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id)
        log.info("Successfully deleted customer $id")
    }

    @PutMapping('/{id}')
    void updateCustomer(@RequestBody Customer requestBody, @PathVariable Long id){
        def customer = repository.findById(id)
        if (customer) {
            repository.save(requestBody)
            log.info("Successfully updated customer $customer")
        }
        log.info("Error, customer does not exist $id")
    }
}
