package org.apache.ofbiz.product.inventory.service.base;

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
import org.apache.ofbiz.product.inventory.InventoryItemDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.order.order.OrderItemShipGrpInvRes;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.apache.ofbiz.shipment.issuance.ItemIssuance;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortInventoryAssign;
import org.apache.ofbiz.workeffort.workeffort.WorkEffortInventoryProduced;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;
import org.apache.ofbiz.product.inventory.PhysicalInventory;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.product.inventory.InventoryItemVariance;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InventoryItemDetailBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InventoryItemDetailBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InventoryItemDetails
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InventoryItemDetail.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InventoryItemDetails
	 */
	public List<InventoryItemDetail> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one InventoryItemDetail
	 */
	public Optional<InventoryItemDetail> findOne(Object inventoryItemId,
			Object inventoryItemDetailSeqId) {
		List<InventoryItemDetail> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItemDetail.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemId), new EntityExpr(
						"inventoryItemDetailSeqId", EntityOperator.EQUALS,
						inventoryItemDetailSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemDetail.fromValues(out.getListIt()
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
	public Optional<InventoryItem> getInventoryItem(
			InventoryItemDetail inventoryItemDetail) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemDetail
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
	 * Get work effort
	 */
	public Optional<WorkEffort> getWorkEffort(
			InventoryItemDetail inventoryItemDetail) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						inventoryItemDetail.getWorkEffortId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
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
			InventoryItemDetail inventoryItemDetail) {
		List<OrderItemShipGrpInvRes> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvRes.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						inventoryItemDetail.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						inventoryItemDetail.getOrderItemSeqId()),
				new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
						inventoryItemDetail.getShipGroupSeqId()),
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemDetail.getInventoryItemId())),
				EntityOperator.AND));
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
	 * Get fixed asset maint
	 */
	public Optional<FixedAssetMaint> getFixedAssetMaint(
			InventoryItemDetail inventoryItemDetail) {
		List<FixedAssetMaint> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						inventoryItemDetail.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						inventoryItemDetail.getMaintHistSeqId())),
				EntityOperator.AND));
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
	 * Get item issuance
	 */
	public Optional<ItemIssuance> getItemIssuance(
			InventoryItemDetail inventoryItemDetail) {
		List<ItemIssuance> entityList = null;
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("itemIssuanceId", EntityOperator.EQUALS,
						inventoryItemDetail.getItemIssuanceId())),
				EntityOperator.AND));
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
	 * Get work effort inventory assign
	 */
	public Optional<WorkEffortInventoryAssign> getWorkEffortInventoryAssign(
			InventoryItemDetail inventoryItemDetail) {
		List<WorkEffortInventoryAssign> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortInventoryAssign.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						inventoryItemDetail.getWorkEffortId()), new EntityExpr(
						"inventoryItemId", EntityOperator.EQUALS,
						inventoryItemDetail.getInventoryItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortInventoryAssign.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get work effort inventory produced
	 */
	public Optional<WorkEffortInventoryProduced> getWorkEffortInventoryProduced(
			InventoryItemDetail inventoryItemDetail) {
		List<WorkEffortInventoryProduced> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortInventoryProduced.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						inventoryItemDetail.getWorkEffortId()), new EntityExpr(
						"inventoryItemId", EntityOperator.EQUALS,
						inventoryItemDetail.getInventoryItemId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortInventoryProduced.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get shipment receipt
	 */
	public Optional<ShipmentReceipt> getShipmentReceipt(
			InventoryItemDetail inventoryItemDetail) {
		List<ShipmentReceipt> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentReceipt.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("receiptId", EntityOperator.EQUALS,
						inventoryItemDetail.getReceiptId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceipt.fromValues(out.getListIt()
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
	 * Get physical inventory
	 */
	public Optional<PhysicalInventory> getPhysicalInventory(
			InventoryItemDetail inventoryItemDetail) {
		List<PhysicalInventory> entityList = null;
		In in = new In();
		in.setEntityName(PhysicalInventory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("physicalInventoryId",
						EntityOperator.EQUALS, inventoryItemDetail
								.getPhysicalInventoryId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PhysicalInventory.fromValues(out.getListIt()
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
	 * Get reason enumeration
	 */
	public Optional<Enumeration> getReasonEnumeration(
			InventoryItemDetail inventoryItemDetail) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						inventoryItemDetail.getReasonEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
	 * Get inventory item variance
	 */
	public Optional<InventoryItemVariance> getInventoryItemVariance(
			InventoryItemDetail inventoryItemDetail) {
		List<InventoryItemVariance> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItemVariance.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemDetail.getInventoryItemId()),
				new EntityExpr("physicalInventoryId", EntityOperator.EQUALS,
						inventoryItemDetail.getPhysicalInventoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemVariance.fromValues(out.getListIt()
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