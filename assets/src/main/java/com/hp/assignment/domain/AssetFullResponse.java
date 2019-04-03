package com.hp.assignment.domain;

import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hp.assignment.common.AssetType;
import com.hp.assignment.entity.AssetEntity;
import com.hp.assignment.entity.OrganizationEntity;
import com.hp.assignment.entity.UserEntity;

public class AssetFullResponse {

    private Integer id;
    
	@NotNull(message = "Name cannot be null")
    private String name;
	
	@NotNull(message = "Brand cannot be null")
    private String brand;
	
	@NotNull(message = "Model cannot be null")
    private String model;
	
	@NotNull(message = "Serial Number cannot be null")
    private String serial_number;
	
	@NotNull(message = "Type cannot be null")
    private AssetType type;
	
	@NotNull(message = "Acquisition cannot be null")
    private Date acquisition;
	
	@NotNull(message = "Warranty Expiration cannot be null")
    private Date warranty_expiration;
	
	@JsonManagedReference
	private Organization organization;
	@JsonManagedReference
	private User user;
	@JsonManagedReference
	private AssetFullResponse parentAsset;;
    
    @NotNull(message = "Retired cannot be null")
    private Boolean retired;
    
    @NotNull(message = "Cost cannot be null")
    private Integer cost;
    
    @JsonBackReference
    private Set<AssetFullResponse> childAssets;

    public AssetFullResponse() {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	public Date getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(Date acquisition) {
		this.acquisition = acquisition;
	}

	public Date getWarranty_expiration() {
		return warranty_expiration;
	}

	public void setWarranty_expiration(Date warranty_expiration) {
		this.warranty_expiration = warranty_expiration;
	}

	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AssetFullResponse getParentAsset() {
		return parentAsset;
	}

	public void setParentAsset(AssetFullResponse parentAsset) {
		this.parentAsset = parentAsset;
	}

	public Boolean getRetired() {
		return retired;
	}

	public void setRetired(Boolean retired) {
		this.retired = retired;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Set<AssetFullResponse> getChildAssets() {
		return childAssets;
	}

	public void setChildAssets(Set<AssetFullResponse> childAssets) {
		this.childAssets = childAssets;
	}
	
	

}
