package com.wipro.rockers.service;

import com.wipro.rockers.entity.Employee;
import com.wipro.rockers.entity.Project;
import com.wipro.rockers.entity.Team;
import com.wipro.rockers.entity.User;
import com.wipro.rockers.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/services/project")
public class ProjectService {


    /* http://localhost:8080/services/project/findAll */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody public String findAll() {


    }

    /* http://localhost:8080/services/project/insert?name=Commercial */
    @RequestMapping(value = "save", method = RequestMethod.GET)
    @ResponseBody public String save(@RequestParam String name) {


    }

    /* http://localhost:8080/services/project/findById?id=1*/
    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ResponseBody public String findById(@PathVariable Long id) {


    }


    /* http://localhost:8080/services/project/deleteById?id=1*/
    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.GET)
    @ResponseBody public String deleteById(@PathVariable Long id) {


    }


    /* http://localhost:8080/services/project/startsWith?name=1*/
    @RequestMapping(value = "startsWith", method = RequestMethod.GET)
    @ResponseBody public String startsWith(@RequestParam String name) {


    }


    /* http://localhost:8080/services/project/findByAllUsingQuery?name=1*/
    @RequestMapping(value = "findByAllUsingQuery", method = RequestMethod.GET)
    @ResponseBody public String findByAllUsingQuery() {


    }


    /* http://localhost:8080/services/project/findByNameUsingSQLQuery?name=1*/
    @RequestMapping(value = "findByNameUsingSQLQuery", method = RequestMethod.GET)
    @ResponseBody public String findByNameUsingSQLQuery() {


    }


    /* http://localhost:8080/services/project/doTest?name=1*/
    @RequestMapping(value = "doTest", method = RequestMethod.GET)
    @ResponseBody public String doTest() {

    }

}
