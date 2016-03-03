package com.jirawat.jpatest;

import com.jirawat.jpatest.entity.Customer;
import com.jirawat.jpatest.entity.Order;
import com.jirawat.jpatest.repository.CustomerRepository;
import com.jirawat.jpatest.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomerOrderTestApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerOrderTestApp.class);

	public static void main(String... args) {
		SpringApplication.run(CustomerOrderTestApp.class);
	}

	@Bean
	public CommandLineRunner jpaTest(final CustomerRepository customerRepository, final OrderRepository orderRepository) {
		return (args) -> {

			setUp(customerRepository);

			LOGGER.info("---------------------------------");
			LOGGER.info("Finding order count by customer id");
			final Long orderCountForId1 = orderRepository.countByCustomerId(1L);
			LOGGER.info("There are " + orderCountForId1 + " orders(s) for customer ID 1");

			LOGGER.info("---------------------------------");
			LOGGER.info("Finding order count by customer id");
			final Long orderCountForSmith = orderRepository.countByCustomerLastName("Smith");
			LOGGER.info("There are " + orderCountForSmith + " orders(s) for customer with last name Smith");

		};
	}

	private void setUp(final CustomerRepository customerRepository) {
		Customer johnDoe = new Customer("John", "Doe");
		List<Order> orderList = new ArrayList<Order>() {{
			add(new Order("Nike123"));
			add(new Order("012387658"));
			add(new Order("401Lev-345P"));
		}};
		johnDoe.setOrders(orderList);
		customerRepository.save(johnDoe);


		Customer marySmith = new Customer("Mary", "Smith");
		List<Order> orderList1 = new ArrayList<Order>() {{
			add(new Order("Order001"));
			add(new Order("Order002"));
			add(new Order("Order003"));
			add(new Order("Order004"));
			add(new Order("Order005"));
		}};
		marySmith.setOrders(orderList1);
		customerRepository.save(marySmith);
	}
}
