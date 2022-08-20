package org.jrtp.PLANS_API.service;

import java.util.Map;
import java.util.List;

import org.jrtp.PLANS_API.db.entities.Plan;

public interface PlanService {
	public Map<Integer, String> getPlanCategories();
	public boolean savePlan(Plan plan);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
	public boolean updatePlan(Plan plan);
	public boolean deletePlanByid(Integer planId);
	public boolean planStatusChange(Integer planId, String active_sw);
}
