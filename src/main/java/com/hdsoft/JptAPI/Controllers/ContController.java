package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Cont;
import com.hdsoft.JptAPI.Repositories.ContRepository;

@RestController
@RequestMapping("/api/v1/cont")
public class ContController {
	@Autowired
	private ContRepository contRepository;
	
	@GetMapping
	public List<Cont> listCont() {
		return contRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{bookingValue}")
	public List<Cont> getCont(@PathVariable String bookingValue) {
		List<Cont> listContNotNull = new ArrayList<Cont>();
		List<Cont> listAllCont = contRepository.findByBookingValue(bookingValue);
		for (Cont cont : listAllCont) {
			if (cont.getCont_serial() != null) {
				listContNotNull.add(cont);
			}
		}
		return listContNotNull;
	}
}
