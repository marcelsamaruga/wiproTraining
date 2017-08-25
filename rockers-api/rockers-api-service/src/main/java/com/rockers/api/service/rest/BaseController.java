package com.rockers.api.service.rest;

import com.rockers.api.model.Contract;
import com.rockers.api.repository.IContractRepository;
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

public abstract  class BaseController {

	protected static final String MESSAGE_INSERT_BLANK = "Can't insert empty object";
	protected static final String MESSAGE_DELETE_BLANK = "Can't delete empty object";
	protected static final String MESSAGE_ERROR_DELETE = "Error while deleting";

	protected static final String MESSAGE_DELETE_SUCCESS = "Record deleted";
	protected static final String MESSAGE_INSERT_SUCCESS = "Record has been inserted";

	protected static final String MESSAGE_RECORD_NOT_FOUND = "Record not found";

}


