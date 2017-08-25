package com.rockers.api.service.rest;

import com.rockers.api.model.User;
import com.rockers.api.repository.IEmployeeRepository;
import com.rockers.api.repository.IUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		if (user == null || StringUtils.isEmpty(user.getLogin()) ){
			return new ResponseEntity<String>( MESSAGE_INSERT_BLANK , HttpStatus.BAD_REQUEST );
		} 

		user.setEmployee(
			employeeRepository.findOne( user.getEmployee().getId() )
		);

		repository.save(user);
		String message = user.getLogin() + " saved";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/findAll")
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/findById/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return new ResponseEntity<User>( repository.findOne(id), HttpStatus.OK );
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if (id == null) {
			return new ResponseEntity<String>( MESSAGE_DELETE_BLANK , HttpStatus.BAD_REQUEST );
		}
				
		try {
			repository.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<String>( MESSAGE_ERROR_DELETE , HttpStatus.OK);
		}
		return new ResponseEntity<String>( MESSAGE_DELETE_SUCCESS , HttpStatus.OK);
	}

}
