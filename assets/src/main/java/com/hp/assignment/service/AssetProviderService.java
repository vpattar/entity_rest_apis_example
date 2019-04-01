package com.hp.assignment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hp.assignment.domain.Asset;

public interface AssetProviderService {

	void addAsset(Asset asset);
	List<Asset> getAssets();
	void editAssets(Asset asset);
	void deleteAssetsById(Integer assetId);
	Page<Asset> listAllByPage(Pageable pageable);
	Page<Asset> listNameByPage(String name, Pageable pageable);
}
