package com.hp.assignment.dao;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hp.assignment.model.AssetEntity;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Integer> {
	@SuppressWarnings("unchecked")
	AssetEntity save(AssetEntity entity);
	List<AssetEntity> findAll();
	void deleteById(Id id);
	Page<AssetEntity> findAll(Pageable pageable);
	
	 @Query(value = "SELECT * FROM assets WHERE name like %?1%",
			    nativeQuery = true)
	Page<AssetEntity> findName(String name, Pageable pageable);
	
}
