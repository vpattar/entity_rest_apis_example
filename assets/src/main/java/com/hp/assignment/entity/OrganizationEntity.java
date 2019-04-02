package com.hp.assignment.entity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "organizations")
public class OrganizationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull(message = "Name cannot be null")
    private String name;
	
    private String address;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="organization")
    private List<UserEntity> users;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="organization")
    private List<AssetEntity> assets;
 
    
    public OrganizationEntity() {
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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<AssetEntity> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetEntity> assets) {
		this.assets = assets;
	}

}
