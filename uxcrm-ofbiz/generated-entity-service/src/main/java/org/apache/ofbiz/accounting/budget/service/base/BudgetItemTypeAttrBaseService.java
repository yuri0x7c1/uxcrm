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
import org.apache.ofbiz.accounting.budget.BudgetItemTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.budget.BudgetItemType;
import org.apache.ofbiz.accounting.budget.BudgetItemAttribute;
import org.apache.ofbiz.accounting.budget.BudgetItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class BudgetItemTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public BudgetItemTypeAttrBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count BudgetItemTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(BudgetItemTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find BudgetItemTypeAttrs
	 */
	public List<BudgetItemTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one BudgetItemTypeAttr
	 */
	public Optional<BudgetItemTypeAttr> findOne(Object budgetItemTypeId,
			Object attrName) {
		List<BudgetItemTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItemTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("budgetItemTypeId", EntityOperator.EQUALS,
						budgetItemTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = BudgetItemTypeAttr.fromValues(out.getListIt()
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
	public Optional<BudgetItemType> getBudgetItemType(
			BudgetItemTypeAttr budgetItemTypeAttr) {
		List<BudgetItemType> entityList = null;
		In in = new In();
		in.setEntityName(BudgetItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemTypeAttr
								.getBudgetItemTypeId())), EntityOperator.AND));
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
	 * Get budget item attributes
	 */
	public List<BudgetItemAttribute> getBudgetItemAttributes(
			BudgetItemTypeAttr budgetItemTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						budgetItemTypeAttr.getAttrName())), EntityOperator.AND));
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
	 * Get budget items
	 */
	public List<BudgetItem> getBudgetItems(
			BudgetItemTypeAttr budgetItemTypeAttr, Integer start,
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
				.asList(new EntityExpr("budgetItemTypeId",
						EntityOperator.EQUALS, budgetItemTypeAttr
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
}