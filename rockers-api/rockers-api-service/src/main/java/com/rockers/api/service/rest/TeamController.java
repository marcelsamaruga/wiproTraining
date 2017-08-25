package com.rockers.api.service.rest;

import com.rockers.api.model.Team;
import com.rockers.api.repository.IContractRepository;
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
@RequestMapping(value="/team")
public class TeamController extends BaseController {

		@Autowired
		private ITeamRepository repository;

		@Autowired
		private IContractRepository contractRepository;
		
		@RequestMapping(method=RequestMethod.POST, value="/save")
		public ResponseEntity<String> saveUser(@RequestBody Team team){
			if (team == null || StringUtils.isEmpty(team.getName()) ) {
				return new ResponseEntity<String>( MESSAGE_INSERT_BLANK , HttpStatus.BAD_REQUEST);
			}

			team.setContract(
				contractRepository.findOne(team.getContract().getId())
			);
			
			repository.save(team);
			String message = team.getName() + " saved";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/findAll")
		public ResponseEntity<List<Team>> findAll(){
			return new ResponseEntity<List<Team>>(repository.findAll(), HttpStatus.OK);
		}

		@RequestMapping(method=RequestMethod.GET, value="/findById/{id}")
		public ResponseEntity<Team> findById(@PathVariable Long id){
			return new ResponseEntity<Team>( repository.findOne(id), HttpStatus.OK );
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable Long id){
			if (id == null) {
				return new ResponseEntity<String>( MESSAGE_DELETE_BLANK , HttpStatus.BAD_REQUEST );
			}
					
			try {
				repository.delete(id);
			} catch (Exception e) {
				return new ResponseEntity<String>(MESSAGE_ERROR_DELETE , HttpStatus.OK );
			}
			return new ResponseEntity<String>( MESSAGE_DELETE_SUCCESS , HttpStatus.OK );
		}

	

}
