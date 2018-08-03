package org.apache.ofbiz.product.promo.service.base;

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
import org.apache.ofbiz.product.promo.ProductPromoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.apache.ofbiz.product.promo.ProductPromoCond;
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.apache.ofbiz.order._return.ReturnAdjustment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPromoRuleBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPromoRuleBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPromoRules
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPromoRules
	 */
	public List<ProductPromoRule> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ProductPromoRule> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
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
				entityList = ProductPromoRule.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ProductPromoRule
	 */
	public Optional<ProductPromoRule> findOne(Object productPromoId,
			Object productPromoRuleId) {
		List<ProductPromoRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoId), new EntityExpr("productPromoRuleId",
						EntityOperator.EQUALS, productPromoRuleId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoRule.fromValues(out.getListIt()
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
	 * Get product promo
	 */
	public Optional<ProductPromo> getProductPromo(
			ProductPromoRule productPromoRule) {
		List<ProductPromo> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromo.fromValues(out.getListIt()
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
			ProductPromoRule productPromoRule, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoRuleId())),
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
	 * Get product promo actions
	 */
	public List<ProductPromoAction> getProductPromoActions(
			ProductPromoRule productPromoRule, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoRuleId())),
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
	 * Get product promo conds
	 */
	public List<ProductPromoCond> getProductPromoConds(
			ProductPromoRule productPromoRule, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductPromoCond> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCond.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoRuleId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCond.fromValues(out.getListIt()
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
			ProductPromoRule productPromoRule, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoRuleId())),
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

	/**
	 * Get return adjustments
	 */
	public List<ReturnAdjustment> getReturnAdjustments(
			ProductPromoRule productPromoRule, Integer start, Integer number,
			List<String> orderBy) {
		List<ReturnAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						productPromoRule.getProductPromoRuleId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}