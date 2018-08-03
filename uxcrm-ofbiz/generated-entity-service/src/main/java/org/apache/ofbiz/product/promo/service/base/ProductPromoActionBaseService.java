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
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.product.promo.ProductPromoRule;
import org.apache.ofbiz.order.order.OrderAdjustmentType;
import org.apache.ofbiz.product.promo.ProductPromoCategory;
import org.apache.ofbiz.product.promo.ProductPromoProduct;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.apache.ofbiz.order._return.ReturnAdjustment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ProductPromoActionBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ProductPromoActionBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ProductPromoActions
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ProductPromoActions
	 */
	public List<ProductPromoAction> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one ProductPromoAction
	 */
	public Optional<ProductPromoAction> findOne(Object productPromoId,
			Object productPromoRuleId, Object productPromoActionSeqId) {
		List<ProductPromoAction> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoId), new EntityExpr("productPromoRuleId",
						EntityOperator.EQUALS, productPromoRuleId),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoActionSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoAction.fromValues(out.getListIt()
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
	 * Get action enumeration
	 */
	public Optional<Enumeration> getActionEnumeration(
			ProductPromoAction productPromoAction) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoActionEnumId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Enumeration.fromValues(out.getListIt()
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
			ProductPromoAction productPromoAction) {
		List<ProductPromo> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId())),
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
	 * Get product promo rule
	 */
	public Optional<ProductPromoRule> getProductPromoRule(
			ProductPromoAction productPromoAction) {
		List<ProductPromoRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId())),
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
	 * Get order adjustment type
	 */
	public Optional<OrderAdjustmentType> getOrderAdjustmentType(
			ProductPromoAction productPromoAction) {
		List<OrderAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, productPromoAction
								.getOrderAdjustmentTypeId())),
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
	 * Get product promo categories
	 */
	public List<ProductPromoCategory> getProductPromoCategories(
			ProductPromoAction productPromoAction, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPromoCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoAction
								.getProductPromoActionSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product promo products
	 */
	public List<ProductPromoProduct> getProductPromoProducts(
			ProductPromoAction productPromoAction, Integer start,
			Integer number, List<String> orderBy) {
		List<ProductPromoProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductPromoProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoAction
								.getProductPromoActionSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(
			ProductPromoAction productPromoAction, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoAction
								.getProductPromoActionSeqId())),
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
	 * Get quote adjustments
	 */
	public List<QuoteAdjustment> getQuoteAdjustments(
			ProductPromoAction productPromoAction, Integer start,
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoAction
								.getProductPromoActionSeqId())),
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
			ProductPromoAction productPromoAction, Integer start,
			Integer number, List<String> orderBy) {
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
						productPromoAction.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						productPromoAction.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, productPromoAction
								.getProductPromoActionSeqId())),
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