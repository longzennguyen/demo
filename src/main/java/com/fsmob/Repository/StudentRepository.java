package com.fsmob.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsmob.model.student;

public interface StudentRepository extends JpaRepository<student	, Long> {
	

}
