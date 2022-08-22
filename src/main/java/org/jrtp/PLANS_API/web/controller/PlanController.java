package org.jrtp.PLANS_API.web.controller;

import java.util.List;
import java.util.Map;

import org.jrtp.PLANS_API.db.entities.Plan;
import org.jrtp.PLANS_API.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vaibhav
 *@date 22-Aug-2022
 * 
 */
@RestController
@RequestMapping("/api")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/catagories")
	public ResponseEntity<Map<Integer, String>> getPlanCategories() {
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param plan
	 * @return
	 */
	@PostMapping("/plan")
	public ResponseEntity<String> save(@RequestBody Plan plan) {
		String msg = (planService.savePlan(plan) != true) ? "Plan not saved" : "Plan saved";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	/**
	 * @return
	 */
	@GetMapping("/plan")
	public ResponseEntity<List<Plan>> plans() {
		return new ResponseEntity<>(planService.getAllPlans(), HttpStatus.OK);
	}
	
	
	/**
	 * @param planId
	 * @return
	 */
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> plan(@PathVariable Integer planId) {
		return new ResponseEntity<>(planService.getPlanById(planId), HttpStatus.OK);
	}
	
	
	/**
	 * @param planId
	 * @param plan
	 * @return
	 */
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
//		boolean updatePlan = planService.updatePlan(plan);
		String msg = (planService.updatePlan(plan) != true) ? "Plan not Updated" : "Plan updated";
//		if(updatePlan)
//			msg = "Data is Updated!!";
//		msg = ;
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}	
	
	
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
		String msg = (planService.deletePlanByid(planId) != true) ? "Plan not deleted" : "Plan deleted"; 
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	@PutMapping("/change-status/{planId}/{status}")
	public ResponseEntity<String> changeStatus(Integer planId, String status) {
		String msg = (planService.planStatusChange(planId, status) != true) ? "Status not changed" : "Status not changed"; 
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}