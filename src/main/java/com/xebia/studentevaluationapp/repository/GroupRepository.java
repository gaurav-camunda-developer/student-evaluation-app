package com.xebia.studentevaluationapp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.studentevaluationapp.entities.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {

	Optional<Group> findByName(String name);
	
}
