package com.examportal.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}

