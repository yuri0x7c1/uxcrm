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
import org.apache.ofbiz.order.order.OrderAdjustmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.order.OrderAdjustmentTypeAttr;
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.apache.ofbiz.order.quote.QuoteAdjustment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderAdjustmentTypeBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderAdjustmentTypeBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderAdjustmentTypes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderAdjustmentTypes
	 */
	public List<OrderAdjustmentType> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderAdjustmentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
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
				entityList = OrderAdjustmentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderAdjustmentType
	 */
	public Optional<OrderAdjustmentType> findOne(Object orderAdjustmentTypeId) {
		List<OrderAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentTypeId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentType.fromValues(out.getListIt()
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
	 * Get parent order adjustment type
	 */
	public Optional<OrderAdjustmentType> getParentOrderAdjustmentType(
			OrderAdjustmentType orderAdjustmentType) {
		List<OrderAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentType
								.getParentTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentType.fromValues(out.getListIt()
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
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(
			OrderAdjustmentType orderAdjustmentType, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentType
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child order adjustment types
	 */
	public List<OrderAdjustmentType> getChildOrderAdjustmentTypes(
			OrderAdjustmentType orderAdjustmentType, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustmentType> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentTypeId", EntityOperator.EQUALS,
						orderAdjustmentType.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentType.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustment type attrs
	 */
	public List<OrderAdjustmentTypeAttr> getOrderAdjustmentTypeAttrs(
			OrderAdjustmentType orderAdjustmentType, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderAdjustmentTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustmentTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentType
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustmentTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promo actions
	 */
	public List<ProductPromoAction> getProductPromoActions(
			OrderAdjustmentType orderAdjustmentType, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPromoAction> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentType
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoAction.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get quote adjustments
	 */
	public List<QuoteAdjustment> getQuoteAdjustments(
			OrderAdjustmentType orderAdjustmentType, Integer start,
			Integer number, List<String> orderBy) {
		List<QuoteAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(QuoteAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteAdjustmentTypeId",
						EntityOperator.EQUALS, orderAdjustmentType
								.getOrderAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}