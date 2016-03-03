package com.jirawat.jpatest.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EntityA {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int numValueA;
	private int numValueB;

	@OneToMany(mappedBy = "entityA", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<EntityX> entityXList;

	protected EntityA() { }

	public EntityA(final String nameStr, final int valueIntA, final int valueIntB) {
		this.name = nameStr;
		this.numValueA = valueIntA;
		this.numValueB = valueIntB;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumValueA() {
		return numValueA;
	}

	public void setNumValueA(int numValueA) {
		this.numValueA = numValueA;
	}

	public int getNumValueB() {
		return numValueB;
	}

	public void setNumValueB(int numValueB) {
		this.numValueB = numValueB;
	}

	public List<EntityX> getEntityXList() {
		return entityXList;
	}

	public void setEntityXList(List<EntityX> entityXList) {
		for(final EntityX entityX : entityXList) {
			entityX.setEntityA(this);
		}
		this.entityXList = entityXList;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EntityA{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", numValueA=").append(numValueA);
		sb.append(", numValueB=").append(numValueB);
		sb.append(", entityXList=").append(entityXList);
		sb.append('}');
		return sb.toString();
	}

}
