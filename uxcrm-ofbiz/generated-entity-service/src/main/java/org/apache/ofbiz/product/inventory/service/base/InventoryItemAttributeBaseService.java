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
import org.apache.ofbiz.product.inventory.InventoryItemAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.product.inventory.InventoryItemTypeAttr;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InventoryItemAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InventoryItemAttributeBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InventoryItemAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InventoryItemAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InventoryItemAttributes
	 */
	public List<InventoryItemAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InventoryItemAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemAttribute.NAME);
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
				entityList = InventoryItemAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InventoryItemAttribute
	 */
	public Optional<InventoryItemAttribute> findOne(Object inventoryItemId,
			Object attrName) {
		List<InventoryItemAttribute> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItemAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("inventoryItemId", EntityOperator.EQUALS,
						inventoryItemId), new EntityExpr("attrName",
						EntityOperator.EQUALS, attrName)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemAttribute.fromValues(out.getListIt()
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
			InventoryItemAttribute inventoryItemAttribute) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, inventoryItemAttribute
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
	 * Get inventory item type attrs
	 */
	public List<InventoryItemTypeAttr> getInventoryItemTypeAttrs(
			InventoryItemAttribute inventoryItemAttribute, Integer start,
			Integer number, List<String> orderBy) {
		List<InventoryItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InventoryItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("attrName", EntityOperator.EQUALS,
						inventoryItemAttribute.getAttrName())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}