package com.wipro.rockers.repository;


import com.wipro.rockers.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}
