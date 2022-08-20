package org.jrtp.PLANS_API.web.controller;

import org.jrtp.PLANS_API.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlanController {
	
	@Autowired
	private PlanService planService;


}
