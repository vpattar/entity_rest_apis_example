package com.hp.assignment.service;

import java.util.LinkedList;
 
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.hp.assignment.model.AssetEntity;

public class AssetsMapperUtility {

	
	// Can use mapper like dozer mapper, but since this is simple object doing it in code
	public static AssetEntity fromAssetToEntity(Asset asset) {
		AssetEntity entity = new AssetEntity();

		entity.setId(asset.getId());
		entity.setName(asset.getName());
		entity.setBrand(asset.getBrand());
		entity.setModel(asset.getModel());
		entity.setSerial_number(asset.getSerial_number());
		entity.setType(asset.getType());
		entity.setAcquisition(asset.getAcquisition());
		entity.setWarranty_expiration(asset.getWarranty_expiration());
		entity.setOwner_id(asset.getOwner_id());
		entity.setUser_id(asset.getUser_id());
		entity.setAsset_id(asset.getAsset_id());
		entity.setRetired(asset.getRetired());
		entity.setCost(asset.getCost());
		
		return entity;
	}
	
	public static Asset fromEntityToAsset(AssetEntity entity) {
		Asset asset = new Asset();
		asset.setId(entity.getId());
		asset.setName(entity.getName());
		asset.setBrand(entity.getBrand());
		asset.setModel(entity.getModel());
		asset.setSerial_number(entity.getSerial_number());
		asset.setType(entity.getType());
		asset.setAcquisition(entity.getAcquisition());
		asset.setWarranty_expiration(entity.getWarranty_expiration());
		asset.setOwner_id(entity.getOwner_id());
		asset.setUser_id(entity.getUser_id());
		asset.setAsset_id(entity.getAsset_id());
		asset.setRetired(entity.getRetired());
		asset.setCost(entity.getCost());

		
		return asset;
	}

	//TODO: Find a better way to do this
	public static List<Asset> fromEntityToAsset(List<AssetEntity> assetEntities) {
		List<Asset> assetsList = new LinkedList<Asset>();
		for(AssetEntity entity : assetEntities) {
			assetsList.add(fromEntityToAsset(entity));
		}
		
		return assetsList;
	}
	
	 /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    static Page<Asset> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<AssetEntity> source) {
        List<Asset> dtos = fromEntityToAsset(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
