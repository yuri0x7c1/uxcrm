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
import org.apache.ofbiz.product.cost.CostComponentAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.cost.CostComponent;
import org.apache.ofbiz.product.cost.CostComponentTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class CostComponentAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public CostComponentAttributeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count CostComponentAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(CostComponentAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find CostComponentAttributes
	 */
	public List<CostComponentAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<CostComponentAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(CostComponentAttribute.NAME);
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
				entityList = CostComponentAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one CostComponentAttribute
	 */
	public Optional<CostComponentAttribute> findOne(Object costComponentId,
			Object attrName) {
		List<CostComponentAttribute> entityList = null;
		In in = new In();
		in.setEntityName(CostComponentAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("costComponentId", EntityOperator.EQUALS,
						costComponentId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponentAttribute.fromValues(out.getListIt()
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
	 * Get cost component
	 */
	public Optional<CostComponent> getCostComponent(
			CostComponentAttribute costComponentAttribute) {
		List<CostComponent> entityList = null;
		In in = new In();
		in.setEntityName(CostComponent.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("costComponentId",
						EntityOperator.EQUALS, costComponentAttribute
								.getCostComponentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CostComponent.fromValues(out.getListIt()
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
	 * Get cost component type attrs
	 */
	public List<CostComponentTypeAttr> getCostComponentTypeAttrs(
			CostComponentAttribute costComponentAttribute, Integer start,
			Integer number, List<String> orderBy) {
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
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						costComponentAttribute.getAttrName())),
				EntityOperator.AND));
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
}