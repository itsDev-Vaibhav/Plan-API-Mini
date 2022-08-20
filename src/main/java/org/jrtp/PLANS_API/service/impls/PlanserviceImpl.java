 package org.jrtp.PLANS_API.service.impls;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jrtp.PLANS_API.db.entities.Plan;
import org.jrtp.PLANS_API.db.entities.PlanCatagory;
import org.jrtp.PLANS_API.db.repos.PlanCategoryRepo;
import org.jrtp.PLANS_API.db.repos.PlanRepo;
import org.jrtp.PLANS_API.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanserviceImpl implements PlanService{
	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	/**
	 *
	 */
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCatagory> findAll = planCategoryRepo.findAll();
		
		
		
		return null;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> plan = planRepo.findById(planId);
		return plan.isPresent() ? plan.get() : null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlanByid(Integer planId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean planStatusChange(Integer planId, String active_sw) {
		// TODO Auto-generated method stub
		return false;
	}

}
