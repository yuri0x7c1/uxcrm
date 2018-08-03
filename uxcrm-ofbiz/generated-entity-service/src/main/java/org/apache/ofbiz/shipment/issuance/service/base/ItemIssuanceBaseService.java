package org.apache.ofbiz.shipment.issuance.service.base;

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
import org.apache.ofbiz.shipment.issuance.ItemIssuance;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.order.order.OrderItemShipGrpInvRes;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.ShipmentItem;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.product.inventory.InventoryItemDetail;
import org.apache.ofbiz.product.inventory.InventoryTransfer;
import org.apache.ofbiz.shipment.issuance.ItemIssuanceRole;
import org.apache.ofbiz.order.order.OrderItemBilling;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ItemIssuanceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ItemIssuanceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ItemIssuances
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ItemIssuances
	 */
	public List<ItemIssuance> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ItemIssuance> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
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
				entityList = ItemIssuance.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ItemIssuance
	 */
	public Optional<ItemIssuance> findOne(Object itemIssuanceId) {
		List<ItemIssuance> entityList = null;
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						itemIssuanceId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ItemIssuance.fromValues(out.getListIt()
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
	 * Get inventory item
	 */
	public Optional<InventoryItem> getInventoryItem(ItemIssuance itemIssuance) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, itemIssuance
								.getInventoryItemId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
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
			ItemIssuance itemIssuance) {
		List<OrderItemShipGrpInvRes> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvRes.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, itemIssuance
						.getOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						itemIssuance.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						itemIssuance.getShipGroupSeqId()),
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						itemIssuance.getInventoryItemId())), EntityOperator.AND));
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

	/**
	 * Get shipment
	 */
	public Optional<Shipment> getShipment(ItemIssuance itemIssuance) {
		List<Shipment> entityList = null;
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						itemIssuance.getShipmentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
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
	 * Get shipment item
	 */
	public Optional<ShipmentItem> getShipmentItem(ItemIssuance itemIssuance) {
		List<ShipmentItem> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						itemIssuance.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						itemIssuance.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentItem.fromValues(out.getListIt()
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
	 * Get fixed asset maint
	 */
	public Optional<FixedAssetMaint> getFixedAssetMaint(
			ItemIssuance itemIssuance) {
		List<FixedAssetMaint> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						itemIssuance.getFixedAssetId()),
				new EntityExpr("maintHistSeqId", EntityOperator.EQUALS,
						itemIssuance.getMaintHistSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaint.fromValues(out.getListIt()
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
	public Optional<OrderHeader> getOrderHeader(ItemIssuance itemIssuance) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						itemIssuance.getOrderId())), EntityOperator.AND));
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
	public Optional<OrderItem> getOrderItem(ItemIssuance itemIssuance) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, itemIssuance
						.getOrderId()),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						itemIssuance.getOrderItemSeqId())), EntityOperator.AND));
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
	 * Get issued by user login
	 */
	public Optional<UserLogin> getIssuedByUserLogin(ItemIssuance itemIssuance) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						itemIssuance.getIssuedByUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get inventory item details
	 */
	public List<InventoryItemDetail> getInventoryItemDetails(
			ItemIssuance itemIssuance, Integer start, Integer number,
			List<String> orderBy) {
		List<InventoryItemDetail> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemDetail.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						itemIssuance.getItemIssuanceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemDetail.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get inventory transfers
	 */
	public List<InventoryTransfer> getInventoryTransfers(
			ItemIssuance itemIssuance, Integer start, Integer number,
			List<String> orderBy) {
		List<InventoryTransfer> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryTransfer.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						itemIssuance.getItemIssuanceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryTransfer.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get item issuance roles
	 */
	public List<ItemIssuanceRole> getItemIssuanceRoles(
			ItemIssuance itemIssuance, Integer start, Integer number,
			List<String> orderBy) {
		List<ItemIssuanceRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ItemIssuanceRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						itemIssuance.getItemIssuanceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ItemIssuanceRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item billings
	 */
	public List<OrderItemBilling> getOrderItemBillings(
			ItemIssuance itemIssuance, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemBilling.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						itemIssuance.getItemIssuanceId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemBilling.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}