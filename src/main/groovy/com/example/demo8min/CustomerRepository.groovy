package com.example.demo8min

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  CustomerRepository extends JpaRepository<Customer, Long> {

}
