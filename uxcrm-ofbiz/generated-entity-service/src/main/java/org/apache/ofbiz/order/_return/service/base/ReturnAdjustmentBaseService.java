package org.apache.ofbiz.order._return.service.base;

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
import org.apache.ofbiz.order._return.ReturnAdjustment;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order._return.ReturnAdjustmentType;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.order._return.ReturnItem;
import org.apache.ofbiz.product.promo.ProductPromo;
import org.apache.ofbiz.product.promo.ProductPromoRule;
import org.apache.ofbiz.product.promo.ProductPromoAction;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.apache.ofbiz.order._return.ReturnType;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnAdjustmentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnAdjustmentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnAdjustments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnAdjustment.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnAdjustments
	 */
	public List<ReturnAdjustment> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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

	/**
	 * Find one ReturnAdjustment
	 */
	public Optional<ReturnAdjustment> findOne(Object returnAdjustmentId) {
		List<ReturnAdjustment> entityList = null;
		In in = new In();
		in.setEntityName(ReturnAdjustment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnAdjustmentId",
						EntityOperator.EQUALS, returnAdjustmentId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustment.fromValues(out.getListIt()
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
	 * Get return adjustment type
	 */
	public Optional<ReturnAdjustmentType> getReturnAdjustmentType(
			ReturnAdjustment returnAdjustment) {
		List<ReturnAdjustmentType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnAdjustmentType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnAdjustmentTypeId",
						EntityOperator.EQUALS, returnAdjustment
								.getReturnAdjustmentTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnAdjustmentType.fromValues(out.getListIt()
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
	 * Get return header
	 */
	public Optional<ReturnHeader> getReturnHeader(
			ReturnAdjustment returnAdjustment) {
		List<ReturnHeader> entityList = null;
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnId", EntityOperator.EQUALS,
						returnAdjustment.getReturnId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnHeader.fromValues(out.getListIt()
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
	 * Get user login
	 */
	public Optional<UserLogin> getUserLogin(ReturnAdjustment returnAdjustment) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						returnAdjustment.getCreatedByUserLogin())),
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
	 * Get return item
	 */
	public Optional<ReturnItem> getReturnItem(ReturnAdjustment returnAdjustment) {
		List<ReturnItem> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("returnId", EntityOperator.EQUALS,
						returnAdjustment.getReturnId()), new EntityExpr(
						"returnItemSeqId", EntityOperator.EQUALS,
						returnAdjustment.getReturnItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItem.fromValues(out.getListIt()
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
			ReturnAdjustment returnAdjustment) {
		List<ProductPromo> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoId", EntityOperator.EQUALS,
						returnAdjustment.getProductPromoId())),
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
			ReturnAdjustment returnAdjustment) {
		List<ProductPromoRule> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoRule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						returnAdjustment.getProductPromoId()), new EntityExpr(
						"productPromoRuleId", EntityOperator.EQUALS,
						returnAdjustment.getProductPromoRuleId())),
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
			ReturnAdjustment returnAdjustment) {
		List<ProductPromoAction> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoAction.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productPromoId", EntityOperator.EQUALS,
						returnAdjustment.getProductPromoId()),
				new EntityExpr("productPromoRuleId", EntityOperator.EQUALS,
						returnAdjustment.getProductPromoRuleId()),
				new EntityExpr("productPromoActionSeqId",
						EntityOperator.EQUALS, returnAdjustment
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
	public Optional<Geo> getPrimaryGeo(ReturnAdjustment returnAdjustment) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						returnAdjustment.getPrimaryGeoId())),
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
	 * Get secondary geo
	 */
	public Optional<Geo> getSecondaryGeo(ReturnAdjustment returnAdjustment) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						returnAdjustment.getSecondaryGeoId())),
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
			ReturnAdjustment returnAdjustment) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						returnAdjustment.getTaxAuthGeoId()), new EntityExpr(
						"taxAuthPartyId", EntityOperator.EQUALS,
						returnAdjustment.getTaxAuthPartyId())),
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
			ReturnAdjustment returnAdjustment) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						returnAdjustment.getOverrideGlAccountId())),
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

	/**
	 * Get return type
	 */
	public Optional<ReturnType> getReturnType(ReturnAdjustment returnAdjustment) {
		List<ReturnType> entityList = null;
		In in = new In();
		in.setEntityName(ReturnType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnTypeId", EntityOperator.EQUALS,
						returnAdjustment.getReturnTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnType.fromValues(out.getListIt()
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
	 * Get order adjustment
	 */
	public Optional<OrderAdjustment> getOrderAdjustment(
			ReturnAdjustment returnAdjustment) {
		List<OrderAdjustment> entityList = null;
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderAdjustmentId",
						EntityOperator.EQUALS, returnAdjustment
								.getOrderAdjustmentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
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
	 * Get tax authority rate product
	 */
	public Optional<TaxAuthorityRateProduct> getTaxAuthorityRateProduct(
			ReturnAdjustment returnAdjustment) {
		List<TaxAuthorityRateProduct> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityRateSeqId",
						EntityOperator.EQUALS, returnAdjustment
								.getTaxAuthorityRateSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateProduct.fromValues(out.getListIt()
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