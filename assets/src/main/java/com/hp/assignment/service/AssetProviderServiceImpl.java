package com.hp.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hp.assignment.dao.AssetRepository;
import com.hp.assignment.domain.Asset;

@Service
public class AssetProviderServiceImpl implements AssetProviderService {

	@Autowired
    AssetRepository asDao;
    
	@Override
	public void addAsset(Asset asset) {
		// Log
		this.asDao.save(AssetsMapperUtility.fromAssetToEntity(asset));		
	}
	
	@Override
	public List<Asset> getAssets() {
		// Log
		return AssetsMapperUtility.fromEntityToAsset(this.asDao.findAll());
	}
	
	@Override
	public void editAssets(Asset asset) {
		// Log
		this.asDao.save(AssetsMapperUtility.fromAssetToEntity(asset));
	}
	
	@Override
	public void deleteAssetsById(Integer assetId) {
		//Log
		this.asDao.deleteById(assetId);
	}
	/*
	 * TODO: This is not used, still keeping it as this is just test exercise.
	 */
	@Override
	public Page<Asset> listAllByPage(Pageable pageable) {
		return AssetsMapperUtility.mapEntityPageIntoDTOPage(pageable, this.asDao.findAll(pageable));
	}

	@Override
	public Page<Asset> listNameByPage(String name, Pageable pageable) {
		return AssetsMapperUtility.mapEntityPageIntoDTOPage(pageable, this.asDao.findName(name, pageable));
	}

}
