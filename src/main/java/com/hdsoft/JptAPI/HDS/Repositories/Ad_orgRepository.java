package com.hdsoft.JptAPI.HDS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.Ad_OrgModel;

public interface Ad_orgRepository extends JpaRepository<Ad_OrgModel, Long> {
	public Ad_OrgModel findByNameAndValue(String name,String value);
}
