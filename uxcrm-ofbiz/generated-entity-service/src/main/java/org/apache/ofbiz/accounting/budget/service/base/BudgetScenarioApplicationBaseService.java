package org.apache.ofbiz.accounting.budget.service.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.apache.ofbiz.common.ExecuteFindService.In;
import org.apache.ofbiz.common.ExecuteFindService.Out;
import org.apache.ofbiz.common.ExecuteFindService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Optional;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.condition.EntityConditionList;
import org.apache.ofbiz.entity.condition.EntityExpr;
import org.apache.ofbiz.entity.condition.EntityOperator;
import com.github.yuri0x7c1.uxcrm.util.OfbizUtil;
import org.apache.ofbiz.accounting.budget.BudgetScenarioApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.BudgetScenario;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.accounting.budget.BudgetItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetScenarioApplicationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetScenarioApplicationBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetScenarioApplications
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetScenarioApplication.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetScenarioApplications
	 */
	public List<BudgetScenarioApplication> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BudgetScenarioApplication> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetScenarioApplication.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetScenarioApplication.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BudgetScenarioApplication
	 */
	public Optional<BudgetScenarioApplication> findOne(
			Object budgetScenarioApplicId, Object budgetScenarioId) {
		List<BudgetScenarioApplication> entityList = null;
		In in = new In();
		in.setEntityName(BudgetScenarioApplication.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetScenarioApplicId", EntityOperator.EQUALS,
						budgetScenarioApplicId), new EntityExpr(
						"budgetScenarioId", EntityOperator.EQUALS,
						budgetScenarioId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetScenarioApplication.fromValues(out
						.getListIt().getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get budget scenario
	 */
	public Optional<BudgetScenario> getBudgetScenario(
			BudgetScenarioApplication budgetScenarioApplication) {
		List<BudgetScenario> entityList = null;
		In in = new In();
		in.setEntityName(BudgetScenario.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetScenarioId",
						EntityOperator.EQUALS, budgetScenarioApplication
								.getBudgetScenarioId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetScenario.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get budget
	 */
	public Optional<Budget> getBudget(
			BudgetScenarioApplication budgetScenarioApplication) {
		List<Budget> entityList = null;
		In in = new In();
		in.setEntityName(Budget.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetScenarioApplication.getBudgetId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Budget.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}

	/**
	 * Get budget item
	 */
	public Optional<BudgetItem> getBudgetItem(
			BudgetScenarioApplication budgetScenarioApplication) {
		List<BudgetItem> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetScenarioApplication.getBudgetId()),
				new EntityExpr("budgetItemSeqId", EntityOperator.EQUALS,
						budgetScenarioApplication.getBudgetItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItem.fromValues(out.getListIt()
						.getCompleteList());
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		if (CollectionUtils.isNotEmpty(entityList)) {
			return Optional.of(entityList.get(0));
		}
		return Optional.empty();
	}
}