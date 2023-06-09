package com.stsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stsc.controllers.request.MaxIntegerRequest;
import com.stsc.controllers.request.MaxIntegerResponse;
import com.stsc.controllers.service.MaxIntegerService;

@RestController
@RequestMapping("/api")
public class MaximumIntegerController {

	@Autowired
	MaxIntegerService maxIntegerService;
	
	@GetMapping(path = "/getMaxInteger", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public MaxIntegerResponse getMaximumInteger(@RequestBody MaxIntegerRequest request) {
		
		MaxIntegerResponse response = new MaxIntegerResponse();
		response.setK(maxIntegerService.maxIntegerMod(request.getX(), request.getY(), request.getN()));
		
		return response;
	}
}
