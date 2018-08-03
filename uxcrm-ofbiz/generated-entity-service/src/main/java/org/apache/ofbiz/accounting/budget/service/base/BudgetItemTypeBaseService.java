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
import org.apache.ofbiz.accounting.budget.BudgetItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.BudgetItem;
import org.apache.ofbiz.accounting.budget.BudgetItemTypeAttr;
import org.apache.ofbiz.accounting.budget.BudgetScenarioRule;
import org.apache.ofbiz.accounting.ledger.GlBudgetXref;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetItemTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetItemTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetItemTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetItemTypes
	 */
	public List<BudgetItemType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<BudgetItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
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
				entityList = BudgetItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one BudgetItemType
	 */
	public Optional<BudgetItemType> findOne(Object budgetItemTypeId) {
		List<BudgetItemType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemTypeId)),
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
	 * Get parent budget item type
	 */
	public Optional<BudgetItemType> getParentBudgetItemType(
			BudgetItemType budgetItemType) {
		List<BudgetItemType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemType.getParentTypeId())),
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
	 * Get budget items
	 */
	public List<BudgetItem> getBudgetItems(BudgetItemType budgetItemType,
			Integer start, Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemType
								.getBudgetItemTypeId())), EntityOperator.AND));
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
	 * Get child budget item types
	 */
	public List<BudgetItemType> getChildBudgetItemTypes(
			BudgetItemType budgetItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<BudgetItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						budgetItemType.getBudgetItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get budget item type attrs
	 */
	public List<BudgetItemTypeAttr> getBudgetItemTypeAttrs(
			BudgetItemType budgetItemType, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemType
								.getBudgetItemTypeId())), EntityOperator.AND));
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
	 * Get budget scenario rules
	 */
	public List<BudgetScenarioRule> getBudgetScenarioRules(
			BudgetItemType budgetItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<BudgetScenarioRule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(BudgetScenarioRule.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemType
								.getBudgetItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetScenarioRule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gl budget xrefs
	 */
	public List<GlBudgetXref> getGlBudgetXrefs(BudgetItemType budgetItemType,
			Integer start, Integer number, List<String> orderBy) {
		List<GlBudgetXref> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlBudgetXref.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemType
								.getBudgetItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlBudgetXref.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}