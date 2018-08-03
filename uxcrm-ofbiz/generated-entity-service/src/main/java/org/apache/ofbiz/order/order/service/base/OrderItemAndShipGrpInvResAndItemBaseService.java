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
import org.apache.ofbiz.order.order.OrderItemAndShipGrpInvResAndItem;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemAndShipGrpInvResAndItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemAndShipGrpInvResAndItemBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItemAndShipGrpInvResAndItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItemAndShipGrpInvResAndItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItemAndShipGrpInvResAndItems
	 */
	public List<OrderItemAndShipGrpInvResAndItem> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<OrderItemAndShipGrpInvResAndItem> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(OrderItemAndShipGrpInvResAndItem.NAME);
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
				entityList = OrderItemAndShipGrpInvResAndItem.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItemAndShipGrpInvResAndItem
	 */
	public Optional<OrderItemAndShipGrpInvResAndItem> findOne(Object orderId,
			Object orderItemSeqId, Object shipGroupSeqId, Object inventoryItemId) {
		List<OrderItemAndShipGrpInvResAndItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemAndShipGrpInvResAndItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderId),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId), new EntityExpr("shipGroupSeqId",
						EntityOperator.EQUALS, shipGroupSeqId), new EntityExpr(
						"inventoryItemId", EntityOperator.EQUALS,
						inventoryItemId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAndShipGrpInvResAndItem.fromValues(out
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
}