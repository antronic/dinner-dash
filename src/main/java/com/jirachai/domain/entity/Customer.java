package com.jirachai.domain.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
	private int id;
	private String name;
	private int tableId;
	private Date lastVisited;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "name")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Basic
	@Column(name = "table_id")
	public int getTableId() {
		return this.tableId;
	}
	
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	
	@Basic
	@Column(name = "last_visited")
	public Date getLastVisited() {
		return lastVisited;
	}

	public void setLastVisited(Date lastVisited) {
		this.lastVisited = lastVisited;
	}
}
