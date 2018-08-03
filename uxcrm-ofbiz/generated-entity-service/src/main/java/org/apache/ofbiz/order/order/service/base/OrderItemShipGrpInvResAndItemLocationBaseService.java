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
import org.apache.ofbiz.order.order.OrderItemShipGrpInvResAndItemLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.order.order.OrderItemShipGrpInvRes;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemShipGrpInvResAndItemLocationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemShipGrpInvResAndItemLocationBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItemShipGrpInvResAndItemLocations
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvResAndItemLocation.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItemShipGrpInvResAndItemLocations
	 */
	public List<OrderItemShipGrpInvResAndItemLocation> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<OrderItemShipGrpInvResAndItemLocation> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvResAndItemLocation.NAME);
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
				entityList = OrderItemShipGrpInvResAndItemLocation
						.fromValues(out.getListIt().getPartialList(start,
								number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItemShipGrpInvResAndItemLocation
	 */
	public Optional<OrderItemShipGrpInvResAndItemLocation> findOne(
			Object orderItemSeqId, Object orderId, Object shipGroupSeqId,
			Object inventoryItemId) {
		List<OrderItemShipGrpInvResAndItemLocation> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvResAndItemLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId), new EntityExpr("orderId",
						EntityOperator.EQUALS, orderId),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						shipGroupSeqId), new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGrpInvResAndItemLocation
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get product
	 */
	public Optional<Product> getProduct(
			OrderItemShipGrpInvResAndItemLocation orderItemShipGrpInvResAndItemLocation) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation.getProductId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
	 * Get facility location
	 */
	public Optional<FacilityLocation> getFacilityLocation(
			OrderItemShipGrpInvResAndItemLocation orderItemShipGrpInvResAndItemLocation) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation
								.getLocationSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FacilityLocation.fromValues(out.getListIt()
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
	 * Get order item ship grp inv res
	 */
	public Optional<OrderItemShipGrpInvRes> getOrderItemShipGrpInvRes(
			OrderItemShipGrpInvResAndItemLocation orderItemShipGrpInvResAndItemLocation) {
		List<OrderItemShipGrpInvRes> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvRes.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation.getOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation
								.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation
								.getShipGroupSeqId()),
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						orderItemShipGrpInvResAndItemLocation
								.getInventoryItemId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGrpInvRes.fromValues(out.getListIt()
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