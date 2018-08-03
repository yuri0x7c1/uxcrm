package org.apache.ofbiz.product.cost.service.base;

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
import org.apache.ofbiz.product.cost.CostComponentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.cost.CostComponent;
import org.apache.ofbiz.product.cost.CostComponentTypeAttr;
import org.apache.ofbiz.product.cost.ProductCostComponentCalc;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortCostCalc;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CostComponentTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CostComponentTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CostComponentTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CostComponentType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CostComponentTypes
	 */
	public List<CostComponentType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CostComponentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponentType.NAME);
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
				entityList = CostComponentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CostComponentType
	 */
	public Optional<CostComponentType> findOne(Object costComponentTypeId) {
		List<CostComponentType> entityList = null;
		In in = new In();
		in.setEntityName(CostComponentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentType.fromValues(out.getListIt()
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
	 * Get parent cost component type
	 */
	public Optional<CostComponentType> getParentCostComponentType(
			CostComponentType costComponentType) {
		List<CostComponentType> entityList = null;
		In in = new In();
		in.setEntityName(CostComponentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentType.fromValues(out.getListIt()
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
	 * Get cost components
	 */
	public List<CostComponent> getCostComponents(
			CostComponentType costComponentType, Integer start, Integer number,
			List<String> orderBy) {
		List<CostComponent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentType
								.getCostComponentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child cost component types
	 */
	public List<CostComponentType> getChildCostComponentTypes(
			CostComponentType costComponentType, Integer start, Integer number,
			List<String> orderBy) {
		List<CostComponentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponentType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						costComponentType.getCostComponentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get cost component type attrs
	 */
	public List<CostComponentTypeAttr> getCostComponentTypeAttrs(
			CostComponentType costComponentType, Integer start, Integer number,
			List<String> orderBy) {
		List<CostComponentTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponentTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentType
								.getCostComponentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product cost component calcs
	 */
	public List<ProductCostComponentCalc> getProductCostComponentCalcs(
			CostComponentType costComponentType, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductCostComponentCalc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductCostComponentCalc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentType
								.getCostComponentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductCostComponentCalc.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work effort cost calcs
	 */
	public List<WorkEffortCostCalc> getWorkEffortCostCalcs(
			CostComponentType costComponentType, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkEffortCostCalc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortCostCalc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentTypeId",
						EntityOperator.EQUALS, costComponentType
								.getCostComponentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortCostCalc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}