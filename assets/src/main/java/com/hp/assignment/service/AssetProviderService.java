package com.hp.assignment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;

public interface AssetProviderService {

	void addAsset(Asset asset);
	void editAssets(Asset asset);
	void deleteAssetsById(Integer assetId);
	Page<AssetFullResponse> listAllByPage(Pageable pageable);
	Page<AssetFullResponse> listNameByPage(String name, Pageable pageable);
}
