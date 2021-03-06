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
import org.apache.ofbiz.order.order.OrderRoleAndProductContentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.product.Product;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderRoleAndProductContentInfoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderRoleAndProductContentInfoBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderRoleAndProductContentInfoes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderRoleAndProductContentInfo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderRoleAndProductContentInfoes
	 */
	public List<OrderRoleAndProductContentInfo> find(Integer start,
			Integer number, List<String> orderBy, EntityConditionList conditions) {
		List<OrderRoleAndProductContentInfo> entityList = Collections
				.emptyList();
		In in = new In();
		in.setEntityName(OrderRoleAndProductContentInfo.NAME);
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
				entityList = OrderRoleAndProductContentInfo.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderRoleAndProductContentInfo
	 */
	public Optional<OrderRoleAndProductContentInfo> findOne(Object roleTypeId,
			Object orderId, Object partyId, Object orderItemSeqId,
			Object contentId, Object productContentTypeId, Object fromDate) {
		List<OrderRoleAndProductContentInfo> entityList = null;
		In in = new In();
		in.setEntityName(OrderRoleAndProductContentInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						roleTypeId), new EntityExpr("orderId",
						EntityOperator.EQUALS, orderId), new EntityExpr(
						"partyId", EntityOperator.EQUALS, partyId),
						new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
								orderItemSeqId), new EntityExpr("contentId",
								EntityOperator.EQUALS, contentId),
						new EntityExpr("productContentTypeId",
								EntityOperator.EQUALS, productContentTypeId),
						new EntityExpr("fromDate", EntityOperator.EQUALS,
								fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderRoleAndProductContentInfo.fromValues(out
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
	 * Get product
	 */
	public Optional<Product> getProduct(
			OrderRoleAndProductContentInfo orderRoleAndProductContentInfo) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						orderRoleAndProductContentInfo.getProductId())),
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
}