package com.wipro.rockers.service;

import com.wipro.rockers.entity.Employee;
import com.wipro.rockers.entity.Project;
import com.wipro.rockers.entity.Team;
import com.wipro.rockers.entity.User;
import com.wipro.rockers.repository.IEmployeeRepository;
import com.wipro.rockers.repository.IProjectRepository;
import com.wipro.rockers.repository.ITeamRepository;
import com.wipro.rockers.repository.IUserRepository;
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

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    ITeamRepository teamRepository;

    private static final String MESSAGE_IS_EMPTY = "{message: value is empty}";

    /* http://localhost:8080/services/project/findAll */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ResponseBody public String findAll() {
        return projectRepository.findAll().toString();
    }

    /* http://localhost:8080/services/project/insert?name=Commercial */
    @RequestMapping(value = "save", method = RequestMethod.GET)
    @ResponseBody public String save(@RequestParam String name) {
        if (StringUtils.isEmpty(name) ) {
            return MESSAGE_IS_EMPTY;
        }

        Project project = new Project();
        project.setName(name);

        projectRepository.save( project );

        return project.toString();
    }

    /* http://localhost:8080/services/project/findById?id=1*/
    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ResponseBody public String findById(@PathVariable Long id) {
        if (id == null) {
            return MESSAGE_IS_EMPTY;
        }

        Project project = projectRepository.findOne( id );

        return project.toString();
    }


    /* http://localhost:8080/services/project/deleteById?id=1*/
    @RequestMapping(value = "deleteById/{id}", method = RequestMethod.GET)
    @ResponseBody public String deleteById(@PathVariable Long id) {
        if (id == null) {
            return MESSAGE_IS_EMPTY;
        }

        projectRepository.delete( id );

        return "{message: id " + id + " has been removed successfully}";
    }


    /* http://localhost:8080/services/project/startsWith?name=1*/
    @RequestMapping(value = "startsWith", method = RequestMethod.GET)
    @ResponseBody public String startsWith(@RequestParam String name) {
        if ( StringUtils.isEmpty(name) ) {
            return MESSAGE_IS_EMPTY;
        }

        List<Project> listProject = projectRepository.findByNameStartingWith( name );

        return listProject.toString();
    }


    /* http://localhost:8080/services/project/findByAllUsingQuery?name=1*/
    @RequestMapping(value = "findByAllUsingQuery", method = RequestMethod.GET)
    @ResponseBody public String findByAllUsingQuery() {
       List<Project> listProject = projectRepository.findByAllUsingQuery();

        return listProject.toString();
    }


    /* http://localhost:8080/services/project/findByNameUsingSQLQuery?name=1*/
    @RequestMapping(value = "findByNameUsingSQLQuery", method = RequestMethod.GET)
    @ResponseBody public String findByNameUsingSQLQuery() {
        List<Project> listProject = projectRepository.findByNameUsingSQLQuery();

        return listProject.toString();
    }


    /* http://localhost:8080/services/project/doTest?name=1*/
    @RequestMapping(value = "doTest", method = RequestMethod.GET)
    @ResponseBody public String doTest() {
        Project project = new Project();
        project.setName("Project name");

        projectRepository.save(project);

        Team team = new Team();
        team.setName("Team name");
        team.setProject(project);

        teamRepository.save(team);

        Employee employee = new Employee();
        employee.setName("Employee name");
        employee.setEmail("blah@mastercard.com");
        employee.setMcId("e000000");
        employee.setWiproId("em000000");
        employee.setTeam(team);

        employeeRepository.save(employee);

        User user = new User();
        user.setLogin("e00000");
        user.setPassword("blah");
        user.setEmployee(employee);

        userRepository.save(user);

        System.out.println( projectRepository.findAll() );
        System.out.println( teamRepository.findAll() );
        System.out.println( employeeRepository.findAll() );
        System.out.println( userRepository.findAll() );

        return user.toString();
    }

}
