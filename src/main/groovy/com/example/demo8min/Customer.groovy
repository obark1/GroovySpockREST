package com.example.demo8min

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column
    String givenName

    @Column
    String surname



}
