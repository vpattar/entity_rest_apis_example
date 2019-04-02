package com.hp.assignment.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "assets")
public class AssetEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@NotNull(message = "Name cannot be null")
    private String name;
    
	@NotNull(message = "Brand cannot be null")
	private String brand;
	
	@NotNull(message = "Model cannot be null")
    private String model;
	
	@NotNull(message = "Serial Number cannot be null")
    private String serial_number;
	
	//TODO: Ideally this should be an Enum, will update this as enum later
	@NotNull(message = "Type cannot be null")
    private String type;
	
	@NotNull(message = "Acquisition cannot be null")
    private Date acquisition;
	
	@NotNull(message = "Warranty Expiration cannot be null")
    private Date warranty_expiration;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private OrganizationEntity organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id")
    private AssetEntity parentAsset;

    @NotNull(message = "Retired cannot be null")
    private Boolean retired;
    
    @NotNull(message = "Cost cannot be null")
    private Integer cost;

    public AssetEntity() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AssetEntity getParentAsset() {
		return parentAsset;
	}

	public void setParentAsset(AssetEntity parentAsset) {
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

}
