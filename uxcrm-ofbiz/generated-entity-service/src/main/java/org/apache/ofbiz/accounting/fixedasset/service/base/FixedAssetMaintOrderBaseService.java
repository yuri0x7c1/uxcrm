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
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaintOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class FixedAssetMaintOrderBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public FixedAssetMaintOrderBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count FixedAssetMaintOrders
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(FixedAssetMaintOrder.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find FixedAssetMaintOrders
	 */
	public List<FixedAssetMaintOrder> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<FixedAssetMaintOrder> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaintOrder.NAME);
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
				entityList = FixedAssetMaintOrder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one FixedAssetMaintOrder
	 */
	public Optional<FixedAssetMaintOrder> findOne(Object fixedAssetId,
			Object maintHistSeqId, Object orderId, Object orderItemSeqId) {
		List<FixedAssetMaintOrder> entityList = null;
		In in = new In();
		in.setEntityName(FixedAssetMaintOrder.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetId), new EntityExpr("maintHistSeqId",
						EntityOperator.EQUALS, maintHistSeqId), new EntityExpr(
						"orderId", EntityOperator.EQUALS, orderId),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaintOrder.fromValues(out.getListIt()
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
	public Optional<FixedAsset> getFixedAsset(
			FixedAssetMaintOrder fixedAssetMaintOrder) {
		List<FixedAsset> entityList = null;
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("fixedAssetId", EntityOperator.EQUALS,
						fixedAssetMaintOrder.getFixedAssetId())),
				EntityOperator.AND));
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
	 * Get order header
	 */
	public Optional<OrderHeader> getOrderHeader(
			FixedAssetMaintOrder fixedAssetMaintOrder) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						fixedAssetMaintOrder.getOrderId())), EntityOperator.AND));
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
			FixedAssetMaintOrder fixedAssetMaintOrder) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS,
						fixedAssetMaintOrder.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						fixedAssetMaintOrder.getOrderItemSeqId())),
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
}