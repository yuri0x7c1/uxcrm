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
import org.apache.ofbiz.accounting.budget.BudgetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.Budget;
import org.apache.ofbiz.accounting.budget.BudgetTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetTypes
	 */
	public List<BudgetType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BudgetType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetType.NAME);
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
				entityList = BudgetType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BudgetType
	 */
	public Optional<BudgetType> findOne(Object budgetTypeId) {
		List<BudgetType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetTypeId", EntityOperator.EQUALS,
						budgetTypeId)), EntityOperator.AND));
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
	 * Get parent budget type
	 */
	public Optional<BudgetType> getParentBudgetType(BudgetType budgetType) {
		List<BudgetType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetTypeId", EntityOperator.EQUALS,
						budgetType.getParentTypeId())), EntityOperator.AND));
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
	 * Get budgets
	 */
	public List<Budget> getBudgets(BudgetType budgetType, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetTypeId", EntityOperator.EQUALS,
						budgetType.getBudgetTypeId())), EntityOperator.AND));
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
	 * Get child budget types
	 */
	public List<BudgetType> getChildBudgetTypes(BudgetType budgetType,
			Integer start, Integer number, List<String> orderBy) {
		List<BudgetType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						budgetType.getBudgetTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget type attrs
	 */
	public List<BudgetTypeAttr> getBudgetTypeAttrs(BudgetType budgetType,
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
						budgetType.getBudgetTypeId())), EntityOperator.AND));
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
}