package org.apache.ofbiz.order.order.service.base;

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
import org.apache.ofbiz.order.order.OrderAdjustmentTypeAttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderAdjustmentType;
import org.apache.ofbiz.order.order.OrderAdjustmentAttribute;
import org.apache.ofbiz.order.order.OrderAdjustment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderAdjustmentTypeAttrBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderAdjustmentTypeAttrBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderAdjustmentTypeAttrs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderAdjustmentTypeAttr.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderAdjustmentTypeAttrs
	 */
	public List<OrderAdjustmentTypeAttr> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderAdjustmentTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustmentTypeAttr.NAME);
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
				entityList = OrderAdjustmentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderAdjustmentTypeAttr
	 */
	public Optional<OrderAdjustmentTypeAttr> findOne(
			Object orderAdjustmentTypeId, Object attrName) {
		List<OrderAdjustmentTypeAttr> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentTypeAttr.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderAdjustmentTypeId", EntityOperator.EQUALS,
						orderAdjustmentTypeId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentTypeAttr.fromValues(out.getListIt()
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
	 * Get order adjustment type
	 */
	public Optional<OrderAdjustmentType> getOrderAdjustmentType(
			OrderAdjustmentTypeAttr orderAdjustmentTypeAttr) {
		List<OrderAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentTypeAttr
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentType.fromValues(out.getListIt()
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
	 * Get order adjustment attributes
	 */
	public List<OrderAdjustmentAttribute> getOrderAdjustmentAttributes(
			OrderAdjustmentTypeAttr orderAdjustmentTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustmentAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustmentAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						orderAdjustmentTypeAttr.getAttrName())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentAttribute.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(
			OrderAdjustmentTypeAttr orderAdjustmentTypeAttr, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentTypeAttr
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}