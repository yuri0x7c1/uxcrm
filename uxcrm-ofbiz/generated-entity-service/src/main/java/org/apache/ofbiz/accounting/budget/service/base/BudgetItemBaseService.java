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
import org.apache.ofbiz.accounting.budget.BudgetItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.accounting.budget.BudgetItemType;
import org.apache.ofbiz.accounting.budget.BudgetItemTypeAttr;
import org.apache.ofbiz.accounting.budget.BudgetItemAttribute;
import org.apache.ofbiz.accounting.budget.BudgetRevisionImpact;
import org.apache.ofbiz.accounting.budget.BudgetScenarioApplication;
import org.apache.ofbiz.humanres.position.EmplPosition;
import org.apache.ofbiz.accounting.payment.PaymentBudgetAllocation;
import org.apache.ofbiz.order.requirement.RequirementBudgetAllocation;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetItems
	 */
	public List<BudgetItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one BudgetItem
	 */
	public Optional<BudgetItem> findOne(Object budgetId, Object budgetItemSeqId) {
		List<BudgetItem> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetId", EntityOperator.EQUALS, budgetId),
				new EntityExpr("budgetItemSeqId", EntityOperator.EQUALS,
						budgetItemSeqId)), EntityOperator.AND));
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

	/**
	 * Get budget
	 */
	public Optional<Budget> getBudget(BudgetItem budgetItem) {
		List<Budget> entityList = null;
		In in = new In();
		in.setEntityName(Budget.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetId", EntityOperator.EQUALS,
						budgetItem.getBudgetId())), EntityOperator.AND));
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
	 * Get budget item type
	 */
	public Optional<BudgetItemType> getBudgetItemType(BudgetItem budgetItem) {
		List<BudgetItemType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItem.getBudgetItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItemType.fromValues(out.getListIt()
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
	 * Get budget item type attrs
	 */
	public List<BudgetItemTypeAttr> getBudgetItemTypeAttrs(
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
		List<BudgetItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItem.getBudgetItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget item attributes
	 */
	public List<BudgetItemAttribute> getBudgetItemAttributes(
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
		List<BudgetItemAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetItemAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItemAttribute.fromValues(out.getListIt()
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
	public List<BudgetRevisionImpact> getBudgetRevisionImpacts(
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
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
	 * Get budget scenario applications
	 */
	public List<BudgetScenarioApplication> getBudgetScenarioApplications(
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
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
	 * Get empl positions
	 */
	public List<EmplPosition> getEmplPositions(BudgetItem budgetItem,
			Integer start, Integer number, List<String> orderBy) {
		List<EmplPosition> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(EmplPosition.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = EmplPosition.fromValues(out.getListIt()
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
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
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
			BudgetItem budgetItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("budgetId", EntityOperator.EQUALS,
								budgetItem.getBudgetId()),
						new EntityExpr("budgetItemSeqId",
								EntityOperator.EQUALS, budgetItem
										.getBudgetItemSeqId())),
				EntityOperator.AND));
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