package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.hds_pushnotification;
import com.hdsoft.JptAPI.HDS.Impl.hds_pushnotificationImpl;
import com.hdsoft.JptAPI.HDS.Repositories.hds_pushnotificationsReposotiry;
import com.hdsoft.JptAPI.HDS.Service.hds_pushnotificationService;

@RestController
@RequestMapping("api/v1/hds_pushnotification")
public class hds_pushnotificationController {
	@Autowired
	hds_pushnotificationsReposotiry hdp;
	
	@Autowired
	private hds_pushnotificationService hdsPushService = new hds_pushnotificationImpl();

	
	
	@GetMapping
	public List<hds_pushnotification> findAll(){
		List<hds_pushnotification> listIDPush = new ArrayList<hds_pushnotification>();
		listIDPush = hdp.findAll();
		return listIDPush;
	}
	
	@GetMapping
	@RequestMapping(value = "find/{id}")
	public List<hds_pushnotification> findById(@RequestParam long id){
		List<hds_pushnotification> listAll = hdp.findAll();
		List<hds_pushnotification> listByID1 = null;
		for(hds_pushnotification hd: listAll) {
			if(hd.getId() == id) {
				listByID1.add(hd);
				break;
			}
		}
//		List<hds_pushnotification> listById = hdp.findById(id);
		return listByID1;
	}
	
	@GetMapping
	@RequestMapping(value = "/findisdisplay")
	public List<hds_pushnotification> findByDisplay(){
		List<hds_pushnotification> listByID1 = new ArrayList<>();
		List<hds_pushnotification> listAll = hdp.findAll();

		System.out.println("Size:=============="+listAll.size());
		for(hds_pushnotification hd: listAll) {
			System.out.println("ISDISPLAY:=============="+hd.isIsdisplay());
			if(hd.isIsdisplay() == false) {
				listByID1.add(hd);
			}
		}
		if (!listByID1.isEmpty()) {
			return listByID1;
		}
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/insert")
	public hds_pushnotification createNewID(@RequestParam long id,@RequestParam String Client_id,@RequestParam String SerialNum,@RequestParam String noidung,@RequestParam boolean isdisplay) {
		hds_pushnotification hdsp = new hds_pushnotification();
		id=0;
		for(hds_pushnotification hd: hdp.findAll()) {
			if(hd.getClient_id()==Client_id) {
				hdsp = hd;
				break;
			}
			if(hd.getId()>id)
				id=(int) hd.getId();
		}
		id+=1;
		return hdsPushService.createNewID(hdsp,id, Client_id, SerialNum,noidung,true);
	}
	
	@RequestMapping(method =  RequestMethod.PUT,value="/update")
	public hds_pushnotification changisDisplayA(@RequestParam Boolean isdisplay,@RequestParam long id) {
		hds_pushnotification hd = new hds_pushnotification();
		for(hds_pushnotification hds: hdp.findAll()) {
			if(hds.getId()==id) {
				hd = hds;
				break;
			}
		}
		hd.setIsdisplay(true);
		return hdp.save(hd);
//		return hdsPushService.changisDisplay(hd, true);
	}
	
	@PostMapping
	@RequestMapping("create-new-user")
	public String createNewUser(@RequestParam String username,@RequestParam String password) {
		hds_pushnotification hds1 = new hds_pushnotification();
		hds1.setClient_id("DemoFS_MOS");
		hds1.setId(hdp.findAll().size()+1);
		hds1.setIsdisplay(true);
		hds1.setPassword(password);
		hds1.setUsername(username);
		if (hdp.findByUsernameAndPassword(username, password) == null) {
			hdp.save(hds1);
			return "Tao Tai Khoan Thanh Cong!";
		}else {
			return "Tai Khoan Da Ton Tai, Khong The Tao Moi!=> Ngu LOL :))";
		}
		
	}
	
	@GetMapping
	@RequestMapping("list-user")
	public List<hds_pushnotification> listuser(){
		return hdp.findAll();
	}
	
	@GetMapping
	@RequestMapping("find-by-username-and-password")
	public hds_pushnotification findbyusernameandpassword(@RequestParam String username,@RequestParam String password) {
		return hdp.getByUsernameAndPassword(username, password);
	}
	@DeleteMapping
	@RequestMapping("delete-account")
	public String deleteAccount(@RequestParam String username,@RequestParam String password) {
		hds_pushnotification h1 = new hds_pushnotification();
		h1 = hdp.getByUsernameAndPassword(username, password);
		System.out.println("id : "+h1.getId());
//		hdp.deleteAccount(Integer.parseInt( h1.getId()+""));
		hdp.delete(h1);
		return "Xóa thành công , hạnh óc chó :)))))))))))))))))))))))";
	}
}
