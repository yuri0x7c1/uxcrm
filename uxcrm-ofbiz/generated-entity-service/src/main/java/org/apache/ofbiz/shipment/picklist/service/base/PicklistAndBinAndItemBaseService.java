package org.apache.ofbiz.shipment.picklist.service.base;

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
import org.apache.ofbiz.shipment.picklist.PicklistAndBinAndItem;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PicklistAndBinAndItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PicklistAndBinAndItemBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PicklistAndBinAndItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PicklistAndBinAndItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PicklistAndBinAndItems
	 */
	public List<PicklistAndBinAndItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PicklistAndBinAndItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistAndBinAndItem.NAME);
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
				entityList = PicklistAndBinAndItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PicklistAndBinAndItem
	 */
	public Optional<PicklistAndBinAndItem> findOne(Object picklistId,
			Object picklistBinId, Object orderItemSeqId,
			Object inventoryItemId, Object orderId, Object shipGroupSeqId) {
		List<PicklistAndBinAndItem> entityList = null;
		In in = new In();
		in.setEntityName(PicklistAndBinAndItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("picklistId", EntityOperator.EQUALS,
						picklistId), new EntityExpr("picklistBinId",
						EntityOperator.EQUALS, picklistBinId),
						new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
								orderItemSeqId), new EntityExpr(
								"inventoryItemId", EntityOperator.EQUALS,
								inventoryItemId), new EntityExpr("orderId",
								EntityOperator.EQUALS, orderId),
						new EntityExpr("shipGroupSeqId", EntityOperator.EQUALS,
								shipGroupSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistAndBinAndItem.fromValues(out.getListIt()
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