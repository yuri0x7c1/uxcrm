package org.apache.ofbiz.product.price.service.base;

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
import org.apache.ofbiz.product.price.ProductPriceAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.price.ProductPriceActionType;
import org.apache.ofbiz.product.price.ProductPriceRule;
import org.apache.ofbiz.order.order.OrderItemPriceInfo;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPriceActionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPriceActionBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPriceActions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPriceAction.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPriceActions
	 */
	public List<ProductPriceAction> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductPriceAction> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceAction.NAME);
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
				entityList = ProductPriceAction.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductPriceAction
	 */
	public Optional<ProductPriceAction> findOne(Object productPriceRuleId,
			Object productPriceActionSeqId) {
		List<ProductPriceAction> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceAction.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPriceRuleId", EntityOperator.EQUALS,
						productPriceRuleId), new EntityExpr(
						"productPriceActionSeqId", EntityOperator.EQUALS,
						productPriceActionSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceAction.fromValues(out.getListIt()
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
	 * Get product price action type
	 */
	public Optional<ProductPriceActionType> getProductPriceActionType(
			ProductPriceAction productPriceAction) {
		List<ProductPriceActionType> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceActionType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceActionTypeId",
						EntityOperator.EQUALS, productPriceAction
								.getProductPriceActionTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceActionType.fromValues(out.getListIt()
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
	 * Get product price rule
	 */
	public Optional<ProductPriceRule> getProductPriceRule(
			ProductPriceAction productPriceAction) {
		List<ProductPriceRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceAction
								.getProductPriceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceRule.fromValues(out.getListIt()
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
	 * Get order item price infoes
	 */
	public List<OrderItemPriceInfo> getOrderItemPriceInfoes(
			ProductPriceAction productPriceAction, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderItemPriceInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemPriceInfo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPriceRuleId", EntityOperator.EQUALS,
						productPriceAction.getProductPriceRuleId()),
				new EntityExpr("productPriceActionSeqId",
						EntityOperator.EQUALS, productPriceAction
								.getProductPriceActionSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemPriceInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}