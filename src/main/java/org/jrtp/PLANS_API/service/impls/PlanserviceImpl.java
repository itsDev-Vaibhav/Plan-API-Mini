 package org.jrtp.PLANS_API.service.impls;

import java.util.HashMap;
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

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCatagory> catagoryList = planCategoryRepo.findAll();
		if(!(catagoryList.isEmpty())) {
			Map<Integer, String> map = new HashMap<>();
			catagoryList.forEach((PlanCatagory p) -> {
				map.put(p.getCategoryId(), p.getCategoryName());
			});
			return map;
		}
		return null;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = planRepo.save(plan);
		return saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> plan = planRepo.findById(planId);
		return plan.isPresent() ? plan.get() : null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan saved = planRepo.save(plan);
		return saved.getPlanId() != null;
	}

	@Override
	public boolean deletePlanByid(Integer planId) {
		boolean status = false;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			e.fillInStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String active_sw) {
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(active_sw);
			planRepo.save(plan);
			return true;
		}
		return false;
	}
}