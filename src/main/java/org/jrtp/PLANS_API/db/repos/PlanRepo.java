package org.jrtp.PLANS_API.db.repos;

import org.jrtp.PLANS_API.db.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
