package com.hp.assignment.domain;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Organization implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4624759285241581182L;
	private Integer id;
    private String name;
    private String address;
    
    @JsonBackReference
    private Set<User> users;
    
    @JsonBackReference
    private Set<AssetFullResponse> assets;
    public Organization() {
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<AssetFullResponse> getAssets() {
		return assets;
	}

	public void setAssets(Set<AssetFullResponse> assets) {
		this.assets = assets;
	}
	
}
