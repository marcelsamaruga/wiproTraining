package com.wipro.rockers.repository;

/*
* https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
* */

import com.wipro.rockers.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProjectRepository extends JpaRepository<Project, Long> {


    List<Project> findByNameStartingWith(String name);

    @Query( "select p from Project p order by p.name" )
    List<Project> findByAllUsingQuery();


    @Query( value = "SELECT * FROM project ORDER BY name", nativeQuery = true)
    List<Project> findByNameUsingSQLQuery();

}
