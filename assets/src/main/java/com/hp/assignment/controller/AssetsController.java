package com.hp.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hp.assignment.service.AssetProviderService;
import com.hp.assignment.custom.exception.InvalidInputException;
import com.hp.assignment.domain.Asset;
import com.hp.assignment.domain.AssetFullResponse;

/**
 * Ideally the assets should have APIs under,
 * 	/organization/<org_id>/assets/
 * But since, this is test, this just returns the basic asset information.
 * @author vpattar
 * 
 * Few things to note:
 * 1. Relying on the exceptions from validation and service. Purpose is to keep code simple.
 * 2. Generally ResponseEntity can be used.
 *
 */
@RestController
@RequestMapping("/assets")
public class AssetsController {

	@Autowired
	AssetProviderService assetProviderService;
    
	/**
	 * Return simple Assets object, the contents of table.
	 * ex:
	 * 	http://localhost:8080/assets?name=name1&sort=cost,desc
  	 * 	http://localhost:8080/assets?name=name1&page=0&size=2&sort=cost,asc
	 * 	http://localhost:8080/assets?name=top4

	 * @param name
	 * @param pageable
	 * @return
	 */
    @RequestMapping(method=RequestMethod.GET)
    ResponseEntity<Page<AssetFullResponse>> listAssets(@RequestParam("name") String name, Pageable pageable){
		Page<AssetFullResponse> assets = assetProviderService.listNameByPage(name, pageable);
		return new ResponseEntity<Page<AssetFullResponse>> (assets, HttpStatus.OK);
	}
    
    
    /**
     * 
     * @param asset
     * @throws 	Exception Exception only for Id check, for others relying on exception from service.
     *  		Ideally should have been through controller advice, but keeping it simple. 
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Asset> addAssets(@RequestBody Asset asset) throws Exception {
    	if (asset.getId() != null) {
    		throw new InvalidInputException("Id is not required to be set");
    	}
        this.assetProviderService.addAsset(asset);
        
        return new ResponseEntity<Asset>(HttpStatus.CREATED);
    }
     /**
      * 
      * @param asset
      * @throws Exception Exception only for Id check, for others relying on exception from service.
      *  		Ideally should have been through controller advice, but keeping it simple. 
      */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<HttpStatus> editAssets(@RequestBody Asset asset) throws Exception {
    	if (asset.getId() == null) {
    		throw new InvalidInputException("Id is required for edit");
    	}

        this.assetProviderService.addAsset(asset);
        
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * 
     * @param assetId
     * @throws Exception
     */
    @RequestMapping(value={"/{assetId}"}, method = RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> editAssets(@PathVariable Integer assetId) throws Exception {
    	this.assetProviderService.deleteAssetsById(assetId);
    	return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
    
    
}
