package com.jirawat.jpatest.repository;

import com.jirawat.jpatest.entity.EntityX;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface EntityXRepository extends CrudRepository<EntityX,Long>,JpaSpecificationExecutor<EntityX> {

}
