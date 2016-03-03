package com.jirawat.jpatest.repository;

import com.jirawat.jpatest.entity.EntityA;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntityARepository extends CrudRepository<EntityA,Long>,JpaSpecificationExecutor<EntityA> {
	@Query("select a from EntityA a join a.entityXList x " +
		"where a.numValueA=CASE WHEN x.numValueY <= x.numValueZ THEN x.numValueY ELSE x.numValueZ END " +
		" and a.numValueB=CASE WHEN x.numValueY >= x.numValueZ THEN x.numValueY ELSE x.numValueZ END")
	List<EntityA> testJPQLQuery();
}
