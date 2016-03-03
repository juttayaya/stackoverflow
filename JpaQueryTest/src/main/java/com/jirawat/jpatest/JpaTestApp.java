package com.jirawat.jpatest;

import com.jirawat.jpatest.entity.EntityA;
import com.jirawat.jpatest.entity.EntityX;
import com.jirawat.jpatest.repository.EntityARepository;
import com.jirawat.jpatest.repository.EntitySpecifications;
import com.jirawat.jpatest.repository.EntityXRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaTestApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(JpaTestApp.class);

	public static void main(String... args) {
		SpringApplication.run(JpaTestApp.class);
	}

	@Bean
	public CommandLineRunner jpaTest(final EntityARepository entityARepository, final EntityXRepository entityXRepository) {
		return (args) -> {

			setUp(entityARepository);

			LOGGER.info("---------------------------------");
			LOGGER.info("Find greatest name for EntityX");
			for(final EntityX entityX: entityXRepository.findAll(EntitySpecifications.testCriteriaQuery())) {
				LOGGER.info("EntityX Greatest Name: " + entityX);
			}

			LOGGER.info("---------------------------------");
			LOGGER.info("JPQL Query");
			for(final EntityA entityA: entityARepository.testJPQLQuery()) {
				LOGGER.info("EntityA Query: " + entityA);
			}
		};
	}

	private void setUp(final EntityARepository entityARepository) {
		EntityA entityA_1_2 = new EntityA("nameA_0_2",0,2);
		List<EntityX> entityXList = new ArrayList<EntityX>() {{
			add(new EntityX("nameX_1_10",1,10));
			add(new EntityX("nameX_2_0",2,0));
			add(new EntityX("nameX_3_4",3,4));
		}};
		entityA_1_2.setEntityXList(entityXList);
		entityARepository.save(entityA_1_2);


		EntityA entityA_6_9 = new EntityA("nameA_6_9",6,9);
		List<EntityX> entityXList1 = new ArrayList<EntityX>() {{
			add(new EntityX("nameX_3_9",3,9));
			add(new EntityX("nameX_10_100", 10,100));
			add(new EntityX("nameX_15_2",15,2));
			add(new EntityX("nameX_2_365",2,365));
			add(new EntityX("nameX_23_21",23,21));
		}};
		entityA_6_9.setEntityXList(entityXList1);
		entityARepository.save(entityA_6_9);
	}
}
