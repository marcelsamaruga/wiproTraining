package com.wipro.rockers.repository;


import com.wipro.rockers.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamRepository extends JpaRepository<Team, Long> {

}
