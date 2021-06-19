package com.fsmob.controller;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/process")
public class ProcessDontHaveTable {
	private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

	@GetMapping
	@RequestMapping("gentoken")
	public String generateNewToken() {
	    byte[] randomBytes = new byte[10];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes).toUpperCase();
	}
}
