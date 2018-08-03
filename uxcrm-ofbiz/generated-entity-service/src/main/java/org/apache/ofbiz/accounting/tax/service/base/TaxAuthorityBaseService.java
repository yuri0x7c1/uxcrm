package org.apache.ofbiz.accounting.tax.service.base;

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
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.common.geo.Geo;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.accounting.tax.PartyTaxAuthInfo;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.order.quote.QuoteAdjustment;
import org.apache.ofbiz.order._return.ReturnAdjustment;
import org.apache.ofbiz.accounting.tax.TaxAuthorityAssoc;
import org.apache.ofbiz.accounting.tax.TaxAuthorityCategory;
import org.apache.ofbiz.accounting.tax.TaxAuthorityGlAccount;
import org.apache.ofbiz.accounting.tax.TaxAuthorityRateProduct;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TaxAuthorityBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TaxAuthorityBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TaxAuthorities
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TaxAuthorities
	 */
	public List<TaxAuthority> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TaxAuthority> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
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
				entityList = TaxAuthority.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TaxAuthority
	 */
	public Optional<TaxAuthority> findOne(Object taxAuthGeoId,
			Object taxAuthPartyId) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthGeoId), new EntityExpr("taxAuthPartyId",
						EntityOperator.EQUALS, taxAuthPartyId)),
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
	 * Get tax auth geo
	 */
	public Optional<Geo> getTaxAuthGeo(TaxAuthority taxAuthority) {
		List<Geo> entityList = null;
		In in = new In();
		in.setEntityName(Geo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("geoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId())), EntityOperator.AND));
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
	 * Get tax auth party
	 */
	public Optional<Party> getTaxAuthParty(TaxAuthority taxAuthority) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Party
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
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(TaxAuthority taxAuthority,
			Integer start, Integer number, List<String> orderBy) {
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
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
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
	 * Get party tax auth infoes
	 */
	public List<PartyTaxAuthInfo> getPartyTaxAuthInfoes(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<PartyTaxAuthInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyTaxAuthInfo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyTaxAuthInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get vat product stores
	 */
	public List<ProductStore> getVatProductStores(TaxAuthority taxAuthority,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductStore> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("vatTaxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()), new EntityExpr(
						"vatTaxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	public List<QuoteAdjustment> getQuoteAdjustments(TaxAuthority taxAuthority,
			Integer start, Integer number, List<String> orderBy) {
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
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
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
			TaxAuthority taxAuthority, Integer start, Integer number,
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
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
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
	 * Get tax authority assocs
	 */
	public List<TaxAuthorityAssoc> getTaxAuthorityAssocs(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to tax authority assocs
	 */
	public List<TaxAuthorityAssoc> getToTaxAuthorityAssocs(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("toTaxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("toTaxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority categories
	 */
	public List<TaxAuthorityCategory> getTaxAuthorityCategories(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityCategory> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityCategory.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityCategory.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority gl accounts
	 */
	public List<TaxAuthorityGlAccount> getTaxAuthorityGlAccounts(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityGlAccount> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityGlAccount.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityGlAccount.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get tax authority rate products
	 */
	public List<TaxAuthorityRateProduct> getTaxAuthorityRateProducts(
			TaxAuthority taxAuthority, Integer start, Integer number,
			List<String> orderBy) {
		List<TaxAuthorityRateProduct> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TaxAuthorityRateProduct.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthGeoId()),
				new EntityExpr("taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthority.getTaxAuthPartyId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityRateProduct.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}