package com.example.demo8min

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Demo8minApplication {

	@Autowired
	CustomerRepository repository

	static void main(String[] args) {
		SpringApplication.run(Demo8minApplication, args)
	}

	@Bean
	CommandLineRunner initCustomerDatabase() {
		return {
			repository.saveAll([new Customer([id: 1L, givenName: 'Jon', surname: 'Snow']),
								new Customer([id: 2L, givenName: 'Tyrion', surname: 'Lannister'])
			])
		}
	}
}
