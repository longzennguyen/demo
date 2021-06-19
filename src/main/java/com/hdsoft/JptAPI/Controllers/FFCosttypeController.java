package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.CostType;
import com.hdsoft.JptAPI.Models.FFCostType;
import com.hdsoft.JptAPI.Repositories.CostTypeRepository;

@RestController
@RequestMapping("/api/v1/ffcosttype")
public class FFCosttypeController {


	
	@Autowired
	CostTypeRepository costtypeRepository;

	@GetMapping
	public List<FFCostType> listAll() {
		List<FFCostType> result = new ArrayList<FFCostType>();
		List<CostType> listAllCostType = costtypeRepository.findAll();
		for (CostType costType : listAllCostType) {
			String value = costType.getValue();
			String name = costType.getName();
			String display = value.concat("-").concat(name);
			if ((display.contains("CK") || display.contains("TT")) && costType.getIsactive()=='Y')
				result.add(new FFCostType(costType.getFf_costtype_id(), display));
		}
		Collections.sort(result);
		return result;
	}

}
