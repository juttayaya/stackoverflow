package com.jirawat.jpatest.repository;

import com.jirawat.jpatest.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
