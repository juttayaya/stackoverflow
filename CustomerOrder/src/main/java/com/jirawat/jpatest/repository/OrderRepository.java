package com.jirawat.jpatest.repository;

import com.jirawat.jpatest.entity.Order;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
	Long countByCustomerId(Long id);
	Long countByCustomerLastName(String lastName);
}
