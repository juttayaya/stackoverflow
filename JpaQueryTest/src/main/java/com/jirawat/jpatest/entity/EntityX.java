package com.jirawat.jpatest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntityX {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nameX;
	private int numValueY;
	private int numValueZ;

	@ManyToOne
	@JoinColumn(name = "ENTITYA_ID")
	private EntityA entityA;

	protected EntityX() { }

	public EntityX(final String nameStr, final int valueIntY, final int valueIntZ) {
		this.nameX = nameStr;
		this.numValueY = valueIntY;
		this.numValueZ = valueIntZ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameX() {
		return nameX;
	}

	public void setNameX(String nameX) {
		this.nameX = nameX;
	}

	public int getNumValueY() {
		return numValueY;
	}

	public void setNumValueY(int numValueY) {
		this.numValueY = numValueY;
	}

	public int getNumValueZ() {
		return numValueZ;
	}

	public void setNumValueZ(int numValueZ) {
		this.numValueZ = numValueZ;
	}

	public EntityA getEntityA() {
		return entityA;
	}

	public void setEntityA(EntityA entityA) {
		this.entityA = entityA;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("EntityX{");
		sb.append("id=").append(id);
		sb.append(", nameX='").append(nameX).append('\'');
		sb.append(", numValueY=").append(numValueY);
		sb.append(", numValueZ=").append(numValueZ);
		sb.append('}');
		return sb.toString();
	}
}
