package com.jirawat.jpatest.repository;

import com.jirawat.jpatest.entity.EntityX;
import com.jirawat.jpatest.entity.EntityX_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

public final class EntitySpecifications {
	private EntitySpecifications() {}

	public static Specification<EntityX> testCriteriaQuery() {
		return (root, query, cb) -> {
			Subquery<String> maxSubQuery = query.subquery(String.class);
			Root<EntityX> fromEntityX = maxSubQuery.from(EntityX.class);
			maxSubQuery.select(cb.greatest(fromEntityX.get(EntityX_.nameX)));

			return cb.equal(root.get(EntityX_.nameX), maxSubQuery);
		};
	}
}
