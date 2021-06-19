package com.hdsoft.JptAPI.HDS.Impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.HDS.Repositories.hds_pushnotificationsReposotiry;
import com.hdsoft.JptAPI.HDS.Service.hds_pushnotificationService;
import com.hdsoft.JptAPI.HDS.model.hds_pushnotification;
@Service
public class hds_pushnotificationImpl implements hds_pushnotificationService {
	@Autowired
	private hds_pushnotificationsReposotiry hdpr;

	@Override
	public hds_pushnotification createNewID(hds_pushnotification hdpush,long id, String Client_id, String SerialNum,String noidung,boolean isDisplay) {
		
			hds_pushnotification hd1 = new hds_pushnotification();
			hd1.setClient_id(Client_id);
			hd1.setUsername(SerialNum);
			hd1.setId(id);
			hd1.setPassword(noidung);
			hd1.setIsdisplay(false);
			System.out.println("ABD");
			return hdpr.saveAndFlush(hd1);
		
	}

	@Override
	public hds_pushnotification changisDisplay(hds_pushnotification hdpush, Boolean isdisplay) {
		// TODO Auto-generated method stub
		hds_pushnotification hd = new hds_pushnotification();
		hd.setIsdisplay(isdisplay);
		return hdpr.save(hd);
//		return null;
	}
}
