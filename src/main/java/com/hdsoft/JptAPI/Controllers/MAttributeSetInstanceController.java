package com.hdsoft.JptAPI.Controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MAttributeSetInstance;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;

@RestController
@RequestMapping("/api/v1/attributeset")
public class MAttributeSetInstanceController {

	@Autowired
	private MAttributeSetInstanceRepository attributeRepository;

	@GetMapping
	public List<MAttributeSetInstance> listAll() {
		return attributeRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/{id}")
	public MAttributeSetInstance findById(@PathVariable long id) {
		return attributeRepository.getOne(id);
	}

	@GetMapping
	@RequestMapping("/date/{guaranteeDate}")
	public List<MAttributeSetInstance> findByGuaranteeDate(@PathVariable Date guaranteeDate) {
		List<MAttributeSetInstance> setA = attributeRepository.findByGuaranteeDate(guaranteeDate);
		List<MAttributeSetInstance> result = new ArrayList<MAttributeSetInstance>();
		for (MAttributeSetInstance attributeSetInstance : setA) {
			if (attributeSetInstance.getAttributeSetId() == 1000037) {
				result.add(attributeSetInstance);
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/tantruong")
	public List<MAttributeSetInstance> findByTanTruong() {
		List<MAttributeSetInstance> attributeSetList = attributeRepository.findByClientIdAndAttributeSetId(1000010,
				1000037);
		List<MAttributeSetInstance> result = new ArrayList<MAttributeSetInstance>();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -10);
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, 2);
		java.util.Date dateAttribute = cal.getTime();
		for (MAttributeSetInstance attribute : attributeSetList) {
			try {
				String date = attribute.getValue();
				if (date.length() > 8) {
					String dateResult = date.substring(5, 8).concat(date.substring(10));
					attribute.setValue(dateResult);
					Date guaranteeDate = attribute.getGuaranteeDate();
					if (guaranteeDate.after(dateAttribute) && attribute.getValue().length() == 5
							&& guaranteeDate.before(now.getTime())
							&& attribute.getAttributeSetInstanceId() <= 1251609) {
						result.add(attribute);
					}
					if (attribute.getAttributeSetInstanceId() > 1251609) {
						break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result;
	}

}
