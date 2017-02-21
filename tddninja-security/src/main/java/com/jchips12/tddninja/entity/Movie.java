package com.jchips12.tddninja.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String title;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@PrePersist
	public void prePersist() {
		id = UUID.randomUUID().toString();
	}

}
