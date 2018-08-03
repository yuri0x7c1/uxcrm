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
import org.apache.ofbiz.order.order.OrderItemAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderItemAssocType;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.order.order.OrderItemShipGroupAssoc;
import org.apache.ofbiz.order.order.OrderItemShipGroup;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemAssocBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItemAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItemAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItemAssocs
	 */
	public List<OrderItemAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderItemAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemAssoc.NAME);
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
				entityList = OrderItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItemAssoc
	 */
	public Optional<OrderItemAssoc> findOne(Object orderId,
			Object orderItemSeqId, Object shipGroupSeqId, Object toOrderId,
			Object toOrderItemSeqId, Object toShipGroupSeqId,
			Object orderItemAssocTypeId) {
		List<OrderItemAssoc> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderId),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId), new EntityExpr("shipGroupSeqId",
						EntityOperator.EQUALS, shipGroupSeqId), new EntityExpr(
						"toOrderId", EntityOperator.EQUALS, toOrderId),
				new EntityExpr("toOrderItemSeqId", EntityOperator.EQUALS,
						toOrderItemSeqId), new EntityExpr("toShipGroupSeqId",
						EntityOperator.EQUALS, toShipGroupSeqId),
				new EntityExpr("orderItemAssocTypeId", EntityOperator.EQUALS,
						orderItemAssocTypeId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAssoc.fromValues(out.getListIt()
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
	 * Get order item assoc type
	 */
	public Optional<OrderItemAssocType> getOrderItemAssocType(
			OrderItemAssoc orderItemAssoc) {
		List<OrderItemAssocType> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderItemAssocTypeId",
						EntityOperator.EQUALS, orderItemAssoc
								.getOrderItemAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAssocType.fromValues(out.getListIt()
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
	 * Get from order header
	 */
	public Optional<OrderHeader> getFromOrderHeader(
			OrderItemAssoc orderItemAssoc) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemAssoc.getOrderId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
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
	 * Get from order item
	 */
	public Optional<OrderItem> getFromOrderItem(OrderItemAssoc orderItemAssoc) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
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
	 * Get from order item ship group assoc
	 */
	public Optional<OrderItemShipGroupAssoc> getFromOrderItemShipGroupAssoc(
			OrderItemAssoc orderItemAssoc) {
		List<OrderItemShipGroupAssoc> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroupAssoc.fromValues(out.getListIt()
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
	 * Get from order item ship group
	 */
	public Optional<OrderItemShipGroup> getFromOrderItemShipGroup(
			OrderItemAssoc orderItemAssoc) {
		List<OrderItemShipGroup> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getOrderId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
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
	 * Get to order header
	 */
	public Optional<OrderHeader> getToOrderHeader(OrderItemAssoc orderItemAssoc) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemAssoc.getToOrderId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
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
	 * Get to order item
	 */
	public Optional<OrderItem> getToOrderItem(OrderItemAssoc orderItemAssoc) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getToOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getToOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
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
	 * Get to order item ship group assoc
	 */
	public Optional<OrderItemShipGroupAssoc> getToOrderItemShipGroupAssoc(
			OrderItemAssoc orderItemAssoc) {
		List<OrderItemShipGroupAssoc> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getToOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getToOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getToShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroupAssoc.fromValues(out.getListIt()
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
	 * Get to order item ship group
	 */
	public Optional<OrderItemShipGroup> getToOrderItemShipGroup(
			OrderItemAssoc orderItemAssoc) {
		List<OrderItemShipGroup> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItemAssoc
						.getToOrderId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemAssoc.getToShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroup.fromValues(out.getListIt()
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