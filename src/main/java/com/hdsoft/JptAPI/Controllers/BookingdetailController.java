package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Bookingdetail;
import com.hdsoft.JptAPI.Repositories.BookingdetailRepository;

@RestController
@RequestMapping("api/v1/bookingdetail")
public class BookingdetailController {
	
	@Autowired
	private BookingdetailRepository bookingdetailRepository;
	
	@GetMapping
	public List<Bookingdetail> findAll() {
		return bookingdetailRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{bookingValue}")
	public List<Bookingdetail> findByBookingValue(@PathVariable String bookingValue) {
		return bookingdetailRepository.findByBookingValue(bookingValue);
	}
}
