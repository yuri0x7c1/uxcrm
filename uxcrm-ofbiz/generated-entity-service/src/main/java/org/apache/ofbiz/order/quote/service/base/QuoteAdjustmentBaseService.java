package org.apache.ofbiz.order.quote.service.base;

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
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderAdjustmentType;
import org.apache.ofbiz.order.quote.Quote;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.product.promo.ProductPromoRule;
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.apache.ofbiz.accounting.ledger.GlAccount;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class QuoteAdjustmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public QuoteAdjustmentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count QuoteAdjustments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(QuoteAdjustment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find QuoteAdjustments
	 */
	public List<QuoteAdjustment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one QuoteAdjustment
	 */
	public Optional<QuoteAdjustment> findOne(Object quoteAdjustmentId) {
		List<QuoteAdjustment> entityList = null;
		In in = new In();
		in.setEntityName(QuoteAdjustment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteAdjustmentId",
						EntityOperator.EQUALS, quoteAdjustmentId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteAdjustment.fromValues(out.getListIt()
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
			QuoteAdjustment quoteAdjustment) {
		List<OrderAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentTypeId",
						EntityOperator.EQUALS, quoteAdjustment
								.getQuoteAdjustmentTypeId())),
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
	 * Get quote
	 */
	public Optional<Quote> getQuote(QuoteAdjustment quoteAdjustment) {
		List<Quote> entityList = null;
		In in = new In();
		in.setEntityName(Quote.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("quoteId", EntityOperator.EQUALS,
						quoteAdjustment.getQuoteId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Quote
						.fromValues(out.getListIt().getCompleteList());
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
	 * Get user login
	 */
	public Optional<UserLogin> getUserLogin(QuoteAdjustment quoteAdjustment) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						quoteAdjustment.getCreatedByUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get quote item
	 */
	public Optional<QuoteItem> getQuoteItem(QuoteAdjustment quoteAdjustment) {
		List<QuoteItem> entityList = null;
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("quoteId", EntityOperator.EQUALS,
						quoteAdjustment.getQuoteId()), new EntityExpr(
						"quoteItemSeqId", EntityOperator.EQUALS,
						quoteAdjustment.getQuoteItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
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
			QuoteAdjustment quoteAdjustment) {
		List<ProductPromo> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoId", EntityOperator.EQUALS,
						quoteAdjustment.getProductPromoId())),
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
			QuoteAdjustment quoteAdjustment) {
		List<ProductPromoRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						quoteAdjustment.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						quoteAdjustment.getProductPromoRuleId())),
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
	 * Get product promo action
	 */
	public Optional<ProductPromoAction> getProductPromoAction(
			QuoteAdjustment quoteAdjustment) {
		List<ProductPromoAction> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						quoteAdjustment.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						quoteAdjustment.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, quoteAdjustment
								.getProductPromoActionSeqId())),
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
	 * Get primary geo
	 */
	public Optional<Geo> getPrimaryGeo(QuoteAdjustment quoteAdjustment) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						quoteAdjustment.getPrimaryGeoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get secondary geo
	 */
	public Optional<Geo> getSecondaryGeo(QuoteAdjustment quoteAdjustment) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						quoteAdjustment.getSecondaryGeoId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Geo.fromValues(out.getListIt().getCompleteList());
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
	 * Get tax authority
	 */
	public Optional<TaxAuthority> getTaxAuthority(
			QuoteAdjustment quoteAdjustment) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						quoteAdjustment.getTaxAuthGeoId()), new EntityExpr(
						"taxAuthPartyId", EntityOperator.EQUALS,
						quoteAdjustment.getTaxAuthPartyId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthority.fromValues(out.getListIt()
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
	 * Get override gl account
	 */
	public Optional<GlAccount> getOverrideGlAccount(
			QuoteAdjustment quoteAdjustment) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						quoteAdjustment.getOverrideGlAccountId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccount.fromValues(out.getListIt()
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