package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MInoutLine;

public interface MInoutLineRepository extends JpaRepository<MInoutLine, Long> {

	public List<MInoutLine> findByProductIDAndMaterialID(long productID, long materialID);
	
	public List<MInoutLine> findAllByMaterialID(long materialID);

}
