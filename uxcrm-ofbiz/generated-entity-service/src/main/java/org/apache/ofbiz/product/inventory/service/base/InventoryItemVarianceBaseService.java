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
import org.apache.ofbiz.product.inventory.InventoryItemVariance;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.PhysicalInventory;
import org.apache.ofbiz.product.inventory.VarianceReason;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;
import org.apache.ofbiz.product.inventory.InventoryItemDetail;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InventoryItemVarianceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InventoryItemVarianceBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InventoryItemVariances
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InventoryItemVariance.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InventoryItemVariances
	 */
	public List<InventoryItemVariance> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InventoryItemVariance> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemVariance.NAME);
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
				entityList = InventoryItemVariance.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InventoryItemVariance
	 */
	public Optional<InventoryItemVariance> findOne(Object inventoryItemId,
			Object physicalInventoryId) {
		List<InventoryItemVariance> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItemVariance.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemId), new EntityExpr("physicalInventoryId",
						EntityOperator.EQUALS, physicalInventoryId)),
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

	/**
	 * Get physical inventory
	 */
	public Optional<PhysicalInventory> getPhysicalInventory(
			InventoryItemVariance inventoryItemVariance) {
		List<PhysicalInventory> entityList = null;
		In in = new In();
		in.setEntityName(PhysicalInventory.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("physicalInventoryId",
						EntityOperator.EQUALS, inventoryItemVariance
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
	 * Get variance reason
	 */
	public Optional<VarianceReason> getVarianceReason(
			InventoryItemVariance inventoryItemVariance) {
		List<VarianceReason> entityList = null;
		In in = new In();
		in.setEntityName(VarianceReason.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("varianceReasonId",
						EntityOperator.EQUALS, inventoryItemVariance
								.getVarianceReasonId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = VarianceReason.fromValues(out.getListIt()
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
			InventoryItemVariance inventoryItemVariance) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemVariance
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
	 * Get acctg transes
	 */
	public List<AcctgTrans> getAcctgTranses(
			InventoryItemVariance inventoryItemVariance, Integer start,
			Integer number, List<String> orderBy) {
		List<AcctgTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemVariance.getInventoryItemId()),
				new EntityExpr("physicalInventoryId", EntityOperator.EQUALS,
						inventoryItemVariance.getPhysicalInventoryId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTrans.fromValues(out.getListIt()
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
			InventoryItemVariance inventoryItemVariance, Integer start,
			Integer number, List<String> orderBy) {
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
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemVariance.getInventoryItemId()),
				new EntityExpr("physicalInventoryId", EntityOperator.EQUALS,
						inventoryItemVariance.getPhysicalInventoryId())),
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
}