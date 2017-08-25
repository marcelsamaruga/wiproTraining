package com.rockers.api.service.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rockers.api.model.Contract;
import com.rockers.api.repository.IContractRepository;


@RestController
@RequestMapping(value="/contract")
public class ContractController extends BaseController {

	@Autowired
	private IContractRepository repository;

	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity<String> saveUser(@RequestBody Contract contract){
		if ( contract == null || StringUtils.isEmpty(contract.getName()) ){
			return new ResponseEntity<String>( MESSAGE_INSERT_BLANK , HttpStatus.BAD_REQUEST );
		} 
		
		repository.save(contract);
		String message = contract.getName() + " saved";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}


	@RequestMapping(method=RequestMethod.GET, value="/findAll")
	public ResponseEntity<List<Contract>> findAll(){
		return new ResponseEntity<List<Contract>>( repository.findAll(), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.GET, value="/findById/{id}")
	public ResponseEntity<Contract> findById(@PathVariable Long id){
		return new ResponseEntity<Contract>( repository.findOne(id), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if (id == null) {
			return new ResponseEntity<String>( MESSAGE_DELETE_BLANK , HttpStatus.BAD_REQUEST );
		}

		try {
			repository.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<String>(MESSAGE_ERROR_DELETE, HttpStatus.OK);
		}
		return new ResponseEntity<String>( MESSAGE_DELETE_SUCCESS , HttpStatus.OK);
	}



}


