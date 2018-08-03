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
import org.apache.ofbiz.product.inventory.InventoryItemAndLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.facility.ProductFacilityLocation;
import org.apache.ofbiz.product.facility.FacilityLocation;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.shipment.picklist.PicklistItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InventoryItemAndLocationBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InventoryItemAndLocationBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InventoryItemAndLocations
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InventoryItemAndLocation.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InventoryItemAndLocations
	 */
	public List<InventoryItemAndLocation> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InventoryItemAndLocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemAndLocation.NAME);
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
				entityList = InventoryItemAndLocation.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InventoryItemAndLocation
	 */
	public Optional<InventoryItemAndLocation> findOne(Object inventoryItemId) {
		List<InventoryItemAndLocation> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItemAndLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemAndLocation.fromValues(out
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
	 * Get product facility location
	 */
	public Optional<ProductFacilityLocation> getProductFacilityLocation(
			InventoryItemAndLocation inventoryItemAndLocation) {
		List<ProductFacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(ProductFacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productId", EntityOperator.EQUALS,
						inventoryItemAndLocation.getProductId()),
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						inventoryItemAndLocation.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						inventoryItemAndLocation.getLocationSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocation.fromValues(out.getListIt()
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
			InventoryItemAndLocation inventoryItemAndLocation) {
		List<FacilityLocation> entityList = null;
		In in = new In();
		in.setEntityName(FacilityLocation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("facilityId", EntityOperator.EQUALS,
						inventoryItemAndLocation.getFacilityId()),
				new EntityExpr("locationSeqId", EntityOperator.EQUALS,
						inventoryItemAndLocation.getLocationSeqId())),
				EntityOperator.AND));
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
	 * Get inventory item
	 */
	public Optional<InventoryItem> getInventoryItem(
			InventoryItemAndLocation inventoryItemAndLocation) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemAndLocation
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
	 * Get picklist items
	 */
	public List<PicklistItem> getPicklistItems(
			InventoryItemAndLocation inventoryItemAndLocation, Integer start,
			Integer number, List<String> orderBy) {
		List<PicklistItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemAndLocation
								.getInventoryItemId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}