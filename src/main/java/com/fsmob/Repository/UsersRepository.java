package com.fsmob.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fsmob.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	public Users findByUsername(String username);
	public Users findByEmail(String email);
	public Users findByPhone(String phone);
	public Users findByUsernameAndPassword(String username,String password);
	@Query(value = "select max(userid) from users",nativeQuery = true)
	public Long	maxID();
	public Users findByToken(String token);
	
}
