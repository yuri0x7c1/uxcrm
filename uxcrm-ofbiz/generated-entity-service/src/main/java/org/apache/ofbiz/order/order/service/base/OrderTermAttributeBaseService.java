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
import org.apache.ofbiz.order.order.OrderTermAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderTerm;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderTermAttributeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderTermAttributeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderTermAttributes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderTermAttribute.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderTermAttributes
	 */
	public List<OrderTermAttribute> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderTermAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderTermAttribute.NAME);
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
				entityList = OrderTermAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderTermAttribute
	 */
	public Optional<OrderTermAttribute> findOne(Object termTypeId,
			Object orderId, Object orderItemSeqId, Object attrName) {
		List<OrderTermAttribute> entityList = null;
		In in = new In();
		in.setEntityName(OrderTermAttribute.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("termTypeId", EntityOperator.EQUALS,
						termTypeId), new EntityExpr("orderId",
						EntityOperator.EQUALS, orderId),
						new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
								orderItemSeqId), new EntityExpr("attrName",
								EntityOperator.EQUALS, attrName)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderTermAttribute.fromValues(out.getListIt()
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
	 * Get order term
	 */
	public Optional<OrderTerm> getOrderTerm(
			OrderTermAttribute orderTermAttribute) {
		List<OrderTerm> entityList = null;
		In in = new In();
		in.setEntityName(OrderTerm.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("termTypeId", EntityOperator.EQUALS,
						orderTermAttribute.getTermTypeId()),
				new EntityExpr("orderId", EntityOperator.EQUALS,
						orderTermAttribute.getOrderId()), new EntityExpr(
						"orderItemSeqId", EntityOperator.EQUALS,
						orderTermAttribute.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderTerm.fromValues(out.getListIt()
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