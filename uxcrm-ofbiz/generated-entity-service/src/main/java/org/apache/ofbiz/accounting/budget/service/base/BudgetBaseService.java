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
import org.apache.ofbiz.accounting.budget.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.BudgetType;
import org.apache.ofbiz.common.period.CustomTimePeriod;
import org.apache.ofbiz.accounting.budget.BudgetTypeAttr;
import org.apache.ofbiz.accounting.budget.BudgetAttribute;
import org.apache.ofbiz.accounting.budget.BudgetItem;
import org.apache.ofbiz.accounting.budget.BudgetReview;
import org.apache.ofbiz.accounting.budget.BudgetRevision;
import org.apache.ofbiz.accounting.budget.BudgetRevisionImpact;
import org.apache.ofbiz.accounting.budget.BudgetRole;
import org.apache.ofbiz.accounting.budget.BudgetScenarioApplication;
import org.apache.ofbiz.accounting.budget.BudgetStatus;
import org.apache.ofbiz.accounting.payment.PaymentBudgetAllocation;
import org.apache.ofbiz.order.requirement.RequirementBudgetAllocation;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count Budgets
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(Budget.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find Budgets
	 */
	public List<Budget> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<Budget> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Budget.NAME);
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
				entityList = Budget.fromValues(out.getListIt().getPartialList(
						start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one Budget
	 */
	public Optional<Budget> findOne(Object budgetId) {
		List<Budget> entityList = null;
		In in = new In();
		in.setEntityName(Budget.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetId)), EntityOperator.AND));
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
	 * Get budget type
	 */
	public Optional<BudgetType> getBudgetType(Budget budget) {
		List<BudgetType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetTypeId", EntityOperator.EQUALS,
						budget.getBudgetTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetType.fromValues(out.getListIt()
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
	 * Get custom time period
	 */
	public Optional<CustomTimePeriod> getCustomTimePeriod(Budget budget) {
		List<CustomTimePeriod> entityList = null;
		In in = new In();
		in.setEntityName(CustomTimePeriod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("customTimePeriodId",
						EntityOperator.EQUALS, budget.getCustomTimePeriodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomTimePeriod.fromValues(out.getListIt()
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
	 * Get budget type attrs
	 */
	public List<BudgetTypeAttr> getBudgetTypeAttrs(Budget budget,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetTypeId", EntityOperator.EQUALS,
						budget.getBudgetTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget attributes
	 */
	public List<BudgetAttribute> getBudgetAttributes(Budget budget,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget items
	 */
	public List<BudgetItem> getBudgetItems(Budget budget, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget reviews
	 */
	public List<BudgetReview> getBudgetReviews(Budget budget, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetReview> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetReview.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetReview.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget revisions
	 */
	public List<BudgetRevision> getBudgetRevisions(Budget budget,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetRevision> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetRevision.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetRevision.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget revision impacts
	 */
	public List<BudgetRevisionImpact> getBudgetRevisionImpacts(Budget budget,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetRevisionImpact> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetRevisionImpact.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetRevisionImpact.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget roles
	 */
	public List<BudgetRole> getBudgetRoles(Budget budget, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget scenario applications
	 */
	public List<BudgetScenarioApplication> getBudgetScenarioApplications(
			Budget budget, Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
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
	 * Get budget statuses
	 */
	public List<BudgetStatus> getBudgetStatuses(Budget budget, Integer start,
			Integer number, List<String> orderBy) {
		List<BudgetStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get payment budget allocations
	 */
	public List<PaymentBudgetAllocation> getPaymentBudgetAllocations(
			Budget budget, Integer start, Integer number, List<String> orderBy) {
		List<PaymentBudgetAllocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PaymentBudgetAllocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentBudgetAllocation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get requirement budget allocations
	 */
	public List<RequirementBudgetAllocation> getRequirementBudgetAllocations(
			Budget budget, Integer start, Integer number, List<String> orderBy) {
		List<RequirementBudgetAllocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(RequirementBudgetAllocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budget.getBudgetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RequirementBudgetAllocation.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}