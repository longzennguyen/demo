package com.hdsoft.JptAPI.HDS.Service;

import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.HDS.model.hds_pushnotification;

@Service
public interface hds_pushnotificationService {
	public hds_pushnotification createNewID(hds_pushnotification hdpush,long id,String Clinet_id,String SerialNum,String noidung,boolean isdisplay);
	public hds_pushnotification changisDisplay(hds_pushnotification hdpush,Boolean isdisplay);
}
