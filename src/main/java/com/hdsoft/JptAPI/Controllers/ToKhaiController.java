package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.ToKhai;
import com.hdsoft.JptAPI.Repositories.TokhaiRepository;

@RestController
@RequestMapping("/api/v1/tokhai")
public class ToKhaiController {

	@Autowired
	private TokhaiRepository tokhaiRepository;
	
	@GetMapping
	public List<ToKhai> listTokhai() {
		return tokhaiRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{bookingValue}")
	public List<ToKhai> getTokhai(@PathVariable String bookingValue) {
		List<ToKhai> tokhaiNotNull = new ArrayList<ToKhai>();
		List<ToKhai> listAllByBookingValue = tokhaiRepository.findByBookingValue(bookingValue);
		for (ToKhai tokhai : listAllByBookingValue) {
			if (tokhai.getDcln_num() != null) {
				tokhaiNotNull.add(tokhai);
			}
		}
		return tokhaiNotNull;
	}
	
}
