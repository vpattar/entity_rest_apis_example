/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hp.assignment.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hp.assignment.common.AssetType;
import com.hp.assignment.dao.AssetRepository;
import com.hp.assignment.domain.Asset;
import com.hp.assignment.entity.AssetEntity;
import com.hp.assignment.entity.OrganizationEntity;
import com.hp.assignment.entity.UserEntity;

@RunWith(MockitoJUnitRunner.class)
public class AssetProviderServiceTest {

    @Mock
    private AssetsMapperService assetsMapperService;
    
    @Mock
    private AssetRepository asDao;
    
    @InjectMocks
    private AssetProviderServiceImpl assetProviderService;
    
    private Asset asset;
    
    private AssetEntity assetEntity;

    @Before
    public void setUp(){
    	asset = new Asset();
    	asset.setAcquisition(new Date(new java.util.Date().getTime()));
    	asset.setAsset_id(0);
    	asset.setBrand("Nimble");
    	asset.setCost(10000);
    	asset.setId(1);
    	asset.setModel("Director Special");
    	asset.setName("HCI");
    	asset.setOwner_id(2);
    	asset.setRetired(false);
    	asset.setSerial_number("2344");
    	asset.setType(AssetType.compute);
    	asset.setUser_id(1);
    	asset.setWarranty_expiration(new Date(new java.util.Date().getTime()));
    	
    	assetEntity = new AssetEntity();
    	assetEntity.setAcquisition(new Date(new java.util.Date().getTime()));
    	AssetEntity parentAsset = new AssetEntity();
    	parentAsset.setId(0);
    	assetEntity.setParentAsset(parentAsset); 
    	assetEntity.setBrand("Nimble");
    	assetEntity.setCost(10000);
    	assetEntity.setId(1);
    	assetEntity.setModel("Director Special");
    	assetEntity.setName("HCI");
    	OrganizationEntity orEntity = new OrganizationEntity();
    	orEntity.setId(2);
    	assetEntity.setOrganization(orEntity);
    	assetEntity.setRetired(false);
    	assetEntity.setSerial_number("2344");
    	assetEntity.setType(AssetType.compute);
    	UserEntity usEntity = new UserEntity();
    	usEntity.setId(1);
    	assetEntity.setUser(usEntity);
    	assetEntity.setWarranty_expiration(new Date(new java.util.Date().getTime()));
    	
    }

    @Test
    public void addAssetShouldCallAsDaoSave() throws Exception {
    	when(assetsMapperService.fromAssetToEntity(asset)).thenReturn(assetEntity);
    	assetProviderService.addAsset(asset);
    	verify(asDao, times(1)).save(assetEntity);
    }
    
    @Test
    public void addAssetShouldCallFromAssetToEntity() throws Exception {
    	assetProviderService.addAsset(asset);
    	verify(assetsMapperService, times(1)).fromAssetToEntity(asset);
    }

}
