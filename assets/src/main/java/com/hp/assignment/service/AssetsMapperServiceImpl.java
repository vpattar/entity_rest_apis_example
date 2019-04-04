package com.hp.assignment.service;

import java.util.LinkedList;
 
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;
import com.hp.assignment.entity.AssetEntity;
import com.hp.assignment.entity.OrganizationEntity;
import com.hp.assignment.entity.UserEntity;

@Service
public class AssetsMapperServiceImpl implements AssetsMapperService {
	
	/*
	 * 	Multiple options here, like a generic mapper like modelmapper, or dozer mapper.
	 *  Written this to kept it simple and fast.
	 */
	@Override
	public AssetEntity fromAssetToEntity(Asset asset) {
		AssetEntity entity = new AssetEntity();

		entity.setId(asset.getId());
		entity.setName(asset.getName());
		entity.setBrand(asset.getBrand());
		entity.setModel(asset.getModel());
		entity.setSerial_number(asset.getSerial_number());
		entity.setType(asset.getType());
		entity.setAcquisition(asset.getAcquisition());
		entity.setWarranty_expiration(asset.getWarranty_expiration());
		AssetEntity parentAsset = new AssetEntity();
		parentAsset.setId(asset.getAsset_id());
		entity.setParentAsset(parentAsset);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(asset.getUser_id());
		entity.setUser(userEntity);
		OrganizationEntity orgEntity = new OrganizationEntity();
		orgEntity.setId(asset.getOwner_id());
		entity.setOrganization(orgEntity);
		entity.setRetired(asset.getRetired());
		entity.setCost(asset.getCost());
		
		return entity;
	}
	
	@Override
	public AssetEntity fromAssetFullResponseToEntity(AssetFullResponse asset) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		return mapper.map(asset, AssetEntity.class);
	}
	
	
	@Override
	public List<AssetFullResponse> fromEntityToAssetFullResponse(List<AssetEntity> assetEntities) {
		List<AssetFullResponse> assetsList = new LinkedList<AssetFullResponse>();
		DozerBeanMapper mapper = new DozerBeanMapper();
		assetEntities.forEach(entity->assetsList.add(mapper.map(entity, AssetFullResponse.class)));
		return assetsList;
	}
	
	 /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    
    @Override
	public Page<AssetFullResponse> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<AssetEntity> source) {
        List<AssetFullResponse> dtos = fromEntityToAssetFullResponse(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
