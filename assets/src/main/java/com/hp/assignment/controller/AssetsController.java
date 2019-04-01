package com.hp.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.assignment.service.AssetProviderService;
import com.hp.assignment.service.Asset;

@RestController
@RequestMapping("/assets")
public class AssetsController {

	@Autowired
	AssetProviderService assetProviderService;

//    @RequestMapping(value={"", "/{assetId}"}, method = RequestMethod.GET)
//    public List<Asset> getAssets(@PathVariable Optional<Integer> assetId) {
//    	if (assetId.isPresent()) {
//    		// Modify this for by Id
//    		return this.assetProviderService.getAssets();
//    	}
//        return this.assetProviderService.getAssets();
//    }
    
    @RequestMapping(value="/list",method=RequestMethod.GET)
	Page<Asset> list( Pageable pageable){
		Page<Asset> assets = assetProviderService.listAllByPage(pageable);
		return assets;
	}
    
    @RequestMapping(method = RequestMethod.POST)
    public void addAssets(@RequestBody Asset asset) {
        this.assetProviderService.addAsset(asset);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void editAssets(@RequestBody Asset asset) {
        this.assetProviderService.addAsset(asset);
    }
    
    @RequestMapping(value={"/{assetId}"}, method = RequestMethod.DELETE)
    public void editAssets(@PathVariable Integer assetId) throws Exception {
    	this.assetProviderService.deleteAssetsById(assetId);
    }
    
    
}
