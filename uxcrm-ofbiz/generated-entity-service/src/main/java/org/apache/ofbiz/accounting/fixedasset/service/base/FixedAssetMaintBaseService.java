package org.apache.ofbiz.accounting.fixedasset.service.base;

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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.product.product.ProductMaintType;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.product.product.ProductMeterType;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaintMeter;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMeter;
import org.apache.ofbiz.product.inventory.InventoryItemDetail;
import org.apache.ofbiz.shipment.issuance.ItemIssuance;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetMaintBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetMaintBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetMaints
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetMaints
	 */
	public List<FixedAssetMaint> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetMaint> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
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
				entityList = FixedAssetMaint.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetMaint
	 */
	public Optional<FixedAssetMaint> findOne(Object fixedAssetId,
			Object maintHistSeqId) {
		List<FixedAssetMaint> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaint.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetId), new EntityExpr("maintHistSeqId",
						EntityOperator.EQUALS, maintHistSeqId)),
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
	 * Get fixed asset
	 */
	public Optional<FixedAsset> getFixedAsset(FixedAssetMaint fixedAssetMaint) {
		List<FixedAsset> entityList = null;
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaint.getFixedAssetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
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
	 * Get product maint type
	 */
	public Optional<ProductMaintType> getProductMaintType(
			FixedAssetMaint fixedAssetMaint) {
		List<ProductMaintType> entityList = null;
		In in = new In();
		in.setEntityName(ProductMaintType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMaintTypeId",
						EntityOperator.EQUALS, fixedAssetMaint
								.getProductMaintTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMaintType.fromValues(out.getListIt()
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
	 * Get schedule work effort
	 */
	public Optional<WorkEffort> getScheduleWorkEffort(
			FixedAssetMaint fixedAssetMaint) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						fixedAssetMaint.getScheduleWorkEffortId())),
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
	 * Get interval uom
	 */
	public Optional<Uom> getIntervalUom(FixedAssetMaint fixedAssetMaint) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						fixedAssetMaint.getIntervalUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get interval product meter type
	 */
	public Optional<ProductMeterType> getIntervalProductMeterType(
			FixedAssetMaint fixedAssetMaint) {
		List<ProductMeterType> entityList = null;
		In in = new In();
		in.setEntityName(ProductMeterType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productMeterTypeId",
						EntityOperator.EQUALS, fixedAssetMaint
								.getIntervalMeterTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductMeterType.fromValues(out.getListIt()
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
	 * Get purchase order header
	 */
	public Optional<OrderHeader> getPurchaseOrderHeader(
			FixedAssetMaint fixedAssetMaint) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						fixedAssetMaint.getPurchaseOrderId())),
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(FixedAssetMaint fixedAssetMaint) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						fixedAssetMaint.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get fixed asset maint meters
	 */
	public List<FixedAssetMaintMeter> getFixedAssetMaintMeters(
			FixedAssetMaint fixedAssetMaint, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetMaintMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaintMeter.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaint.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMaint.getMaintHistSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaintMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset meters
	 */
	public List<FixedAssetMeter> getFixedAssetMeters(
			FixedAssetMaint fixedAssetMaint, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetMeter> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMeter.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaint.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMaint.getMaintHistSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMeter.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get inventory item details
	 */
	public List<InventoryItemDetail> getInventoryItemDetails(
			FixedAssetMaint fixedAssetMaint, Integer start, Integer number,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaint.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMaint.getMaintHistSeqId())),
				EntityOperator.AND));
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
	 * Get item issuances
	 */
	public List<ItemIssuance> getItemIssuances(FixedAssetMaint fixedAssetMaint,
			Integer start, Integer number, List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaint.getFixedAssetId()), new EntityExpr(
						"maintHistSeqId", EntityOperator.EQUALS,
						fixedAssetMaint.getMaintHistSeqId())),
				EntityOperator.AND));
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
}