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
import org.apache.ofbiz.product.price.ProductPriceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.marketing.campaign.MarketingCampaignPrice;
import org.apache.ofbiz.order.order.OrderItemPriceInfo;
import org.apache.ofbiz.product.price.ProductPriceAction;
import org.apache.ofbiz.product.price.ProductPriceCond;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPriceRuleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPriceRuleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPriceRules
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPriceRule.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPriceRules
	 */
	public List<ProductPriceRule> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductPriceRule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceRule.NAME);
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
				entityList = ProductPriceRule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductPriceRule
	 */
	public Optional<ProductPriceRule> findOne(Object productPriceRuleId) {
		List<ProductPriceRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPriceRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceRuleId)),
				EntityOperator.AND));
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
	 * Get marketing campaign prices
	 */
	public List<MarketingCampaignPrice> getMarketingCampaignPrices(
			ProductPriceRule productPriceRule, Integer start, Integer number,
			List<String> orderBy) {
		List<MarketingCampaignPrice> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(MarketingCampaignPrice.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceRule
								.getProductPriceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = MarketingCampaignPrice.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item price infoes
	 */
	public List<OrderItemPriceInfo> getOrderItemPriceInfoes(
			ProductPriceRule productPriceRule, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceRule
								.getProductPriceRuleId())), EntityOperator.AND));
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

	/**
	 * Get product price actions
	 */
	public List<ProductPriceAction> getProductPriceActions(
			ProductPriceRule productPriceRule, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceRule
								.getProductPriceRuleId())), EntityOperator.AND));
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
	 * Get product price conds
	 */
	public List<ProductPriceCond> getProductPriceConds(
			ProductPriceRule productPriceRule, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPriceCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPriceCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPriceRuleId",
						EntityOperator.EQUALS, productPriceRule
								.getProductPriceRuleId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPriceCond.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}