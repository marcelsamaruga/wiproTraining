package com.rockers.api.service.rest;

import com.rockers.api.model.Employee;
import com.rockers.api.repository.IEmployeeRepository;
import com.rockers.api.repository.ITeamRepository;
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
@RequestMapping(value="/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private IEmployeeRepository repository;

	@Autowired
	private ITeamRepository teamRepository;

	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity<String> saveUser(@RequestBody Employee employee){
		if ( employee == null || StringUtils.isEmpty(employee.getName()) ){
			return new ResponseEntity<String>( MESSAGE_INSERT_BLANK , HttpStatus.BAD_REQUEST );
		}

		employee.setTeam(
			teamRepository.findOne(employee.getTeam().getId())
		);
		
		repository.save(employee);
		String message = employee.getName() + " saved";
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/findAll")
	public ResponseEntity<List<Employee>> findAll(){
		return new ResponseEntity<List<Employee>>(repository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/findById/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		return new ResponseEntity<Employee>( repository.findOne(id), HttpStatus.OK );
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if (id == null) {
			return new ResponseEntity<String>( MESSAGE_DELETE_BLANK , HttpStatus.BAD_REQUEST );
		}

		try {
			repository.delete(id);
		} catch (Exception e) {
			return new ResponseEntity<String>( MESSAGE_ERROR_DELETE, HttpStatus.OK );
		}
		return new ResponseEntity<String>( MESSAGE_DELETE_SUCCESS, HttpStatus.OK );
	}

	
}
