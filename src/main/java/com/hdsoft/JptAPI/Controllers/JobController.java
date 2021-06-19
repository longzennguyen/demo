package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Job;
import com.hdsoft.JptAPI.Repositories.JobRepository;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {
	@Autowired
	private JobRepository jobRepository;

	@GetMapping
	public List<Job> listJobs() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date date = cal.getTime();
		List<Job> result = new ArrayList<Job>();
		List<Job> listAllJob = jobRepository.findAll();
		for (Job job : listAllJob) {
			if (job.getCreated().compareTo(date) > 0) {
				result.add(job);
			}
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/getJobByID/{bookingID}")
	public Job findJobById(@PathVariable int bookingID) {
		return jobRepository.findById(bookingID);
	}

	@RequestMapping(value = "{customerName}", method = RequestMethod.GET)
	public List<Job> getJob(@PathVariable String customerName) {
		return jobRepository.findByCustomerNameContainingIgnoreCase(customerName);
	}

//	@RequestMapping(value = "{bookingValue}", method = RequestMethod.GET)
//	public List<Job> getJobByBookingValue(@PathVariable String bookingValue) {
//		return jobRepository.findByBookingValue(bookingValue);
//	}

	@RequestMapping(value = "/getJobSEDisplay", method = RequestMethod.GET)
	public List<Job> getJobSEDisplay() {
		List<Job> listJob = jobRepository.findAll();
		int size = listJob.size();
		List<Job> result = new ArrayList<Job>();
		for (int i = size - 1; i > 0; i--) {
			if (listJob.get(i).getBookingValue().toLowerCase().contains("se")) {
				result.add(listJob.get(i));
			}
			if (result.size() == 10) {
				break;
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/getJobAEDisplay", method = RequestMethod.GET)
	public List<Job> getJobAEDisplay() {
		List<Job> listJob = jobRepository.findAll();
		int size = listJob.size();
		List<Job> result = new ArrayList<Job>();
		for (int i = size - 1; i > 0; i--) {
			if (listJob.get(i).getBookingValue().toLowerCase().contains("ae")) {
				result.add(listJob.get(i));
			}
			if (result.size() == 10) {
				break;
			}
		}
		return result;
	}

	@RequestMapping(value = "/getJobSIDisplay", method = RequestMethod.GET)
	public List<Job> getJobSIDisplay() {
		List<Job> listJob = jobRepository.findAll();
		int size = listJob.size();
		List<Job> result = new ArrayList<Job>();
		for (int i = size - 1; i > 0; i--) {
			if (listJob.get(i).getBookingValue().toLowerCase().contains("si")) {
				result.add(listJob.get(i));
			}
			if (result.size() == 10) {
				break;
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/getJobAIDisplay", method = RequestMethod.GET)
	public List<Job> getJobAIDisplay() {
		List<Job> listJob = jobRepository.findAll();
		int size = listJob.size();
		List<Job> result = new ArrayList<Job>();
		for (int i = size - 1; i > 0; i--) {
			if (listJob.get(i).getBookingValue().toLowerCase().contains("ai")) {
				result.add(listJob.get(i));
			}
			if (result.size() == 10) {
				break;
			}
		}
		return result;
	}

	@RequestMapping(value = "/getJobSE", method = RequestMethod.GET)
	public List<Job> getJobByBookingValueSE(@RequestParam String bookingValue, @RequestParam String tokhaiNum,
			@RequestParam String contNum, @RequestParam String hawb, @RequestParam String mawb,
			@RequestParam String customerName, @RequestParam String bookingNo) {
		List<Job> listJob = new ArrayList<Job>();
		List<Job> result = new ArrayList<Job>();
		if (bookingValue.length() >= 5) {
			listJob = jobRepository
					.findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase(
							bookingValue, tokhaiNum, contNum, hawb, mawb, customerName, bookingNo);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("se") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
			}
			return result;
		} else {
			int i = 0;
			listJob = jobRepository.findByCustomerNameContainingIgnoreCase(customerName);
			for (Job job : listJob) {
				i = i + 1;
				if (job.getBookingValue().toLowerCase().contains("se") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
				if (i == 100) {
					break;
				}
			}
			return result;
		}
	}
	
	@RequestMapping(value = "/getJobAE", method = RequestMethod.GET)
	public List<Job> getJobByBookingValueAE(@RequestParam String bookingValue, @RequestParam String tokhaiNum,
			@RequestParam String contNum, @RequestParam String hawb, @RequestParam String mawb,
			@RequestParam String customerName, @RequestParam String bookingNo) {
		List<Job> listJob = new ArrayList<Job>();
		List<Job> result = new ArrayList<Job>();
		if (bookingValue.length() >= 5) {
			listJob = jobRepository
					.findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase(
							bookingValue, tokhaiNum, contNum, hawb, mawb, customerName, bookingNo);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("ae") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
			}
			return result;
		} else {
			int i = 0;
			listJob = jobRepository.findByCustomerNameContainingIgnoreCase(customerName);
			for (Job job : listJob) {
				i = i + 1;
				if (job.getBookingValue().toLowerCase().contains("ae") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
				if (i == 100) {
					break;
				}
			}
			return result;
		}
	}

	@RequestMapping(value = "/getJobSI", method = RequestMethod.GET)
	public List<Job> getJobByBookingValueSI(@RequestParam String bookingValue, @RequestParam String tokhaiNum,
			@RequestParam String contNum, @RequestParam String hawb, @RequestParam String mawb,
			@RequestParam String customerName, @RequestParam String bookingNo) {
		List<Job> listJob = new ArrayList<Job>();
		List<Job> result = new ArrayList<Job>();
		if (bookingValue.length() >= 5) {
			listJob = jobRepository
					.findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase(
							bookingValue, tokhaiNum, contNum, hawb, mawb, customerName, bookingNo);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("si") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
			}
			return result;
		} else {
			int i = 0;
			listJob = jobRepository.findByCustomerNameContainingIgnoreCase(customerName);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("si") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					i = i + 1;
					result.add(job);
				}
				if (i == 100) {
					break;
				}
			}
			return result;
		}
	}
	
	@RequestMapping(value = "/getJobAI", method = RequestMethod.GET)
	public List<Job> getJobByBookingValueAI(@RequestParam String bookingValue, @RequestParam String tokhaiNum,
			@RequestParam String contNum, @RequestParam String hawb, @RequestParam String mawb,
			@RequestParam String customerName, @RequestParam String bookingNo) {
		List<Job> listJob = new ArrayList<Job>();
		List<Job> result = new ArrayList<Job>();
		if (bookingValue.length() >= 5) {
			listJob = jobRepository
					.findByBookingValueContainingOrTokhaiNumContainingOrContNumContainingOrHawbContainingOrMawbContainingOrCustomerNameContainingOrBookingNoContainingAllIgnoreCase(
							bookingValue, tokhaiNum, contNum, hawb, mawb, customerName, bookingNo);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("ai") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					result.add(job);
				}
			}
			return result;
		} else {
			int i = 0;
			listJob = jobRepository.findByCustomerNameContainingIgnoreCase(customerName);
			for (Job job : listJob) {
				if (job.getBookingValue().toLowerCase().contains("ai") && job.getIsactive().equalsIgnoreCase("Y") && job.getProcessed().equalsIgnoreCase("N")) {
					i = i + 1;
					result.add(job);
				}
				if (i == 100) {
					break;
				}
			}
			return result;
		}
	}
}
