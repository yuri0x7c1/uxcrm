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
import org.apache.ofbiz.order.order.OrderItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.order.order.OrderItemTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItemTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItemTypes
	 */
	public List<OrderItemType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
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
				entityList = OrderItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItemType
	 */
	public Optional<OrderItemType> findOne(Object orderItemTypeId) {
		List<OrderItemType> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItemTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemType.fromValues(out.getListIt()
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
	 * Get parent order item type
	 */
	public Optional<OrderItemType> getParentOrderItemType(
			OrderItemType orderItemType) {
		List<OrderItemType> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItemType.getParentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemType.fromValues(out.getListIt()
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
	 * Get order items
	 */
	public List<OrderItem> getOrderItems(OrderItemType orderItemType,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItemType
								.getOrderItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child order item types
	 */
	public List<OrderItemType> getChildOrderItemTypes(
			OrderItemType orderItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						orderItemType.getOrderItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item type attrs
	 */
	public List<OrderItemTypeAttr> getOrderItemTypeAttrs(
			OrderItemType orderItemType, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItemType
								.getOrderItemTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}