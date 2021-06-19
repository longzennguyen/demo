package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.hds_appuserReposotiry;
import com.hdsoft.JptAPI.HDS.model.hds_appuser;

@RestController
@RequestMapping("api/v1/hds_appuser")
public class hds_appuserController {
	@Autowired
	hds_appuserReposotiry hdar;
	GetIDUUDate g = new GetIDUUDate();
	@GetMapping
	public List<hds_appuser> findAll(){
		List<hds_appuser> listUser = new ArrayList<hds_appuser>();
		listUser = hdar.findAll();
		return listUser;
	}
	
	@GetMapping
	@RequestMapping(value= "{email}")
	public List<hds_appuser> findByEmail(@PathVariable String email){
		List<hds_appuser> listUser = hdar.findAll();
		List<hds_appuser> listUserFindByemail= new ArrayList<hds_appuser>();
		
		for(hds_appuser user: listUser) {
			String email1=user.getEmail();
//			System.out.println("Email just find: "+email1);
//			if(email1.contains("long")) {
//				listUserFindByemail.add(user);
//			}
//			System.out.println("Done 1!!!!!!!!!!!!!!!!!!!!!");
			if(email1.contains(email)) {
				System.out.println("Receiving");
				listUserFindByemail.add(user);
			}
			
		}
		
		return listUserFindByemail;
		
	}
	@GetMapping
	@RequestMapping(value= "searchbyuser/{username}")
	public List<hds_appuser> findByUsername(@PathVariable String username){
		System.out.println("Search By User");
		List<hds_appuser> listUser = hdar.findAll();
		List<hds_appuser> listUserFindByUsername= new ArrayList<hds_appuser>();
		
		for(hds_appuser user: listUser) {
				String username1=user.getUsername();
				if(username.equals(username1)) {
					System.out.println("Receiving");
					listUserFindByUsername.add(user);
				}
			
		}
	return listUserFindByUsername;
	
	}
	//HDS Base App Mobile
	//GET
	//Find by username , org_id
	@GetMapping
	@RequestMapping("findbyvalueandorg")
	public hds_appuser getByValueAndOrg(@RequestParam String username,@RequestParam long adorgid ) {
		return hdar.findByAdorgidAndUsernameAndAdclientid(adorgid, username, 1000003);
	}
	@GetMapping
	@RequestMapping("findbyvalueandorgandemail")
	public hds_appuser getByValueAndOrg(@RequestParam String username,@RequestParam long adorgid,@RequestParam String email ) {
		return hdar.findByAdorgidAndUsernameAndAdclientidAndEmail(adorgid, username, 1000003,email);
	}
	@GetMapping
	@RequestMapping("findbyusernameandpassword")
	public hds_appuser findbyusernameandpassword(@RequestParam String username,@RequestParam String password) {
		return hdar.findByUsernameAndPassword(username,password);
	}
	
	///POST
	@RequestMapping(method = RequestMethod.POST,value="/createaccount/")
	public hds_appuser createNewAccount(@RequestParam String username, @RequestParam String password,@RequestParam String email  ,@RequestParam long ad_org_id) {
		System.out.println("Create new Account");
		GetIDUUDate giud = new GetIDUUDate();
		hds_appuser newAccount = new hds_appuser();
		newAccount.setAd_client_id(1000014);
		newAccount.setCreatedby(1000014);
		newAccount.setUpdatedby(1000014);
		newAccount.setExpirydate(giud.getDate());
		newAccount.setHds_appuser_id(giud.getNextID("HDS_AppUser"));
		newAccount.setAd_org_id(ad_org_id);
		newAccount.setEmail(email);
		newAccount.setUsername(username);
		newAccount.setHds_appuser_uu(giud.getUUID());
		newAccount.setC_bpartner_id(null);
		newAccount.setCreated(g.getDate());
		newAccount.setUpdated(g.getDate());
		newAccount.setPassword(password);
		System.out.println("Create new Account: "+username);
		return hdar.saveAndFlush(newAccount);
	}
	//HDS Base App Mobile
	//ad_client_id = 1000003
	@RequestMapping(method = RequestMethod.POST,value="/taotaikhoan/")
	public hds_appuser taoTK(@RequestParam long ad_org_id,@RequestParam String username,@RequestParam String password,@RequestParam String email) {
		hds_appuser h = new hds_appuser();
		h.setAd_client_id(1000003);
		h.setAd_org_id(ad_org_id);
		h.setC_bpartner_id((long) 1000274);
		h.setCreatedby(100);// id của ad_user 
		h.setEmail(email);
		h.setExpirydate(g.getDate());
		h.setHds_appuser_id(g.getNextID("HDS_AppUser"));
		h.setHds_appuser_uu(g.getUUID());
		h.setPassword(password);
		h.setUpdatedby(100);
		h.setUsername(username);
		h.setCreated(g.getDate());
		h.setUpdated(g.getDate());
		h.setValidationkey(null);
		System.out.println("ID New User: "+h.getHds_appuser_id());
		return hdar.saveAndFlush(h);
	}
	//PUT HDS Base
	@RequestMapping(method = RequestMethod.PUT,value="/thaydoimatkhau/")
	public hds_appuser thayPass(@RequestParam String username,@RequestParam  long ad_org_id,@RequestParam String email,@RequestParam String password) {
		hds_appuser hds_appuser = new hds_appuser();
		hds_appuser = hdar.findByAdorgidAndUsernameAndAdclientidAndEmail(ad_org_id, username, 1000003, email);
		hds_appuser.setPassword(password);
		hds_appuser.setUpdated(g.getDate());
		return hdar.saveAndFlush(hds_appuser);
	}
}
