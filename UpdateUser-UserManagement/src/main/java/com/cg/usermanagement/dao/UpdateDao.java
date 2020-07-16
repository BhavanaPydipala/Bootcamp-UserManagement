package com.cg.usermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.usermanagement.entity.UserDto;

@Repository
public interface UpdateDao extends JpaRepository<UserDto,Integer> {

}
