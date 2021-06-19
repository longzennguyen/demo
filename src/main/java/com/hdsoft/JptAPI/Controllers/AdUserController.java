package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.AdUser;
import com.hdsoft.JptAPI.Repositories.AdOrgRepository;
import com.hdsoft.JptAPI.Repositories.AdUserRepository;

@RestController
@RequestMapping("/api/v1/aduser")
public class AdUserController {

	@Autowired
	private AdUserRepository adUserRepository;
	
	
	@GetMapping
	public List<AdUser> findAll() {
		List<AdUser> listUserWithOrgId = new ArrayList<AdUser>();
		List<AdUser> listUserWithoutOrgId = adUserRepository.findAll();
		for (AdUser user : listUserWithoutOrgId) {
			if (user.getClientId() == 1000000) {
				user.setOrgId((long)1000000);
				listUserWithOrgId.add(user);
			} else if (user.getClientId() == 1000010) {
				user.setOrgId((long)1000022);
				listUserWithOrgId.add(user);
			}
		}
		return listUserWithOrgId;
	}
	
	@GetMapping
	@RequestMapping("/{email}")
	public List<AdUser> findByEmail(@PathVariable String email) {
		return adUserRepository.findByEmail(email);
	}
	
}
