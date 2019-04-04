package com.hp.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hp.assignment.dao.AssetRepository;
import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;

@Service
public class AssetProviderServiceImpl implements AssetProviderService {

	@Autowired
    AssetRepository asDao;
	
	@Autowired
	AssetsMapperService assetsMapperService;
    
	@Override
	public void addAsset(Asset asset) {
		this.asDao.save(assetsMapperService.fromAssetToEntity(asset));		
	}

	@Override
	public void editAssets(Asset asset) {
		this.asDao.save(assetsMapperService.fromAssetToEntity(asset));
	}
	
	@Override
	public void deleteAssetsById(Integer assetId) {
		this.asDao.deleteById(assetId);
	}
	/*
	 * TODO: This is not used, still keeping it as this is just test exercise.
	 */
	@Override
	public Page<AssetFullResponse> listAllByPage(Pageable pageable) {
		return assetsMapperService.mapEntityPageIntoDTOPage(pageable, this.asDao.findAll(pageable));
	}

	@Override
	public Page<AssetFullResponse> listNameByPage(String name, Pageable pageable) {
		return assetsMapperService.mapEntityPageIntoDTOPage(pageable, this.asDao.findName(name, pageable));
	}

}
