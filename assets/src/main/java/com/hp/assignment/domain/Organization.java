package com.hp.assignment.domain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hp.assignment.entity.AssetEntity;
import com.hp.assignment.entity.UserEntity;

public class Organization {
    private Integer id;
    private String name;
    private String address;
    
    @JsonBackReference
    private Set<UserEntity> users;
    
    @JsonBackReference
    private Set<AssetEntity> assets;
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

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	public Set<AssetEntity> getAssets() {
		return assets;
	}

	public void setAssets(Set<AssetEntity> assets) {
		this.assets = assets;
	}
	
}
