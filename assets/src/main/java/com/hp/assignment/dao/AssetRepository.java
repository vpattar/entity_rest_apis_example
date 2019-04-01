package com.hp.assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hp.assignment.model.AssetEntity;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Integer> {
}
