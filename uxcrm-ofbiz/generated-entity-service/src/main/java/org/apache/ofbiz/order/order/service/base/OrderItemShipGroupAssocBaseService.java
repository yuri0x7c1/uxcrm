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
import org.apache.ofbiz.order.order.OrderItemShipGroupAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.order.order.OrderItemShipGroup;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.order.OrderItemAssoc;
import org.apache.ofbiz.order.order.OrderItemShipGrpInvRes;
import org.apache.ofbiz.order.order.OrderShipment;
import org.apache.ofbiz.order.order.WorkOrderItemFulfillment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemShipGroupAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemShipGroupAssocBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItemShipGroupAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItemShipGroupAssocs
	 */
	public List<OrderItemShipGroupAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderItemShipGroupAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
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
				entityList = OrderItemShipGroupAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItemShipGroupAssoc
	 */
	public Optional<OrderItemShipGroupAssoc> findOne(Object orderId,
			Object orderItemSeqId, Object shipGroupSeqId) {
		List<OrderItemShipGroupAssoc> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderId),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId), new EntityExpr("shipGroupSeqId",
						EntityOperator.EQUALS, shipGroupSeqId)),
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
	 * Get order header
	 */
	public Optional<OrderHeader> getOrderHeader(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId())),
				EntityOperator.AND));
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
	 * Get order item
	 */
	public Optional<OrderItem> getOrderItem(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId())),
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
	 * Get order item ship group
	 */
	public Optional<OrderItemShipGroup> getOrderItemShipGroup(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc) {
		List<OrderItemShipGroup> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
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
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
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

	/**
	 * Get from order item assocs
	 */
	public List<OrderItemAssoc> getFromOrderItemAssocs(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
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
	 * Get to order item assocs
	 */
	public List<OrderItemAssoc> getToOrderItemAssocs(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
			Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("toOrderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"toOrderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("toShipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
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
	 * Get order item ship grp inv reses
	 */
	public List<OrderItemShipGrpInvRes> getOrderItemShipGrpInvReses(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderItemShipGrpInvRes> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvRes.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGrpInvRes.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order shipments
	 */
	public List<OrderShipment> getOrderShipments(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderShipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderShipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderShipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work order item fulfillments
	 */
	public List<WorkOrderItemFulfillment> getWorkOrderItemFulfillments(
			OrderItemShipGroupAssoc orderItemShipGroupAssoc, Integer start,
			Integer number, List<String> orderBy) {
		List<WorkOrderItemFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkOrderItemFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGroupAssoc.getShipGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkOrderItemFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}