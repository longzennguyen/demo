package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Contdeposit;
import com.hdsoft.JptAPI.Models.Job;
import com.hdsoft.JptAPI.Repositories.ContdepositRepository;
import com.hdsoft.JptAPI.Repositories.JobRepository;

@RestController
@RequestMapping("/api/v1/cntdep")
public class ContdepositController {

	@Autowired
	private ContdepositRepository contdepositRepository;

	@Autowired
	private JobRepository jobRepository;

	public List<Job> jobCntDep() {
		List<Job> jobCntDep = new ArrayList<Job>();
		List<Contdeposit> listCntDep = contdepositRepository.findAll();
		for (Contdeposit cntDep : listCntDep) {
			int id = cntDep.getBookingId();
			jobCntDep.add(jobRepository.findById(id));
		}
		return jobCntDep;
	}

	@GetMapping
	public List<Contdeposit> findAll() {
		return contdepositRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/findByBookingId/{bookingId}")
	public Contdeposit findByBookingId(@PathVariable int bookingId) {
		return contdepositRepository.findByBookingId(bookingId);
	}

	@GetMapping
	@RequestMapping("/search/")
	public List<Job> findCont(@RequestParam String bookingValue, @RequestParam String tokhaiNum,
			@RequestParam String contNum, @RequestParam String hawb, @RequestParam String mawb,
			@RequestParam String customerName, @RequestParam String bookingNo) {
		List<Job> listJob = jobRepository.findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase(bookingValue, tokhaiNum, contNum, hawb, mawb, customerName, bookingNo);
		List<Job> result = new ArrayList<Job>();
		for (Job job : listJob) {
			Contdeposit cntDep = contdepositRepository.findByBookingId(job.getId());
			if (cntDep != null && cntDep.getYeucauDuyet().equalsIgnoreCase("N")) {
				Job jobResult = jobRepository.getOne(job.getId());
				result.add(jobResult);
			}
		}
		return result;
	}
}
