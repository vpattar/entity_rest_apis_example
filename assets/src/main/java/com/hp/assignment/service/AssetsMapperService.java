package com.hp.assignment.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;
import com.hp.assignment.entity.AssetEntity;

public interface AssetsMapperService {

	/*
	 * 	Multiple options here, like a generic mapper like modelmapper, or dozer mapper.
	 *  Written this to kept it simple and fast.
	 */
	AssetEntity fromAssetToEntity(Asset asset);

	List<AssetFullResponse> fromEntityToAssetFullResponse(List<AssetEntity> assetEntities);

	/**
	 * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
	 * @param pageRequest   The information of the requested page.
	 * @param source        The {@code Page<ENTITY>} object.
	 * @return The created {@code Page<DTO>} object.
	 */

	Page<AssetFullResponse> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<AssetEntity> source);

	AssetEntity fromAssetFullResponseToEntity(AssetFullResponse asset);

}