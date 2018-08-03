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
import org.apache.ofbiz.accounting.tax.TaxAuthorityAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.tax.TaxAuthority;
import org.apache.ofbiz.accounting.tax.TaxAuthorityAssocType;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TaxAuthorityAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TaxAuthorityAssocBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TaxAuthorityAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TaxAuthorityAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TaxAuthorityAssocs
	 */
	public List<TaxAuthorityAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one TaxAuthorityAssoc
	 */
	public Optional<TaxAuthorityAssoc> findOne(Object taxAuthGeoId,
			Object taxAuthPartyId, Object toTaxAuthGeoId,
			Object toTaxAuthPartyId, Object fromDate) {
		List<TaxAuthorityAssoc> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthGeoId), new EntityExpr("taxAuthPartyId",
						EntityOperator.EQUALS, taxAuthPartyId),
				new EntityExpr("toTaxAuthGeoId", EntityOperator.EQUALS,
						toTaxAuthGeoId), new EntityExpr("toTaxAuthPartyId",
						EntityOperator.EQUALS, toTaxAuthPartyId),
				new EntityExpr("fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssoc.fromValues(out.getListIt()
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
	 * Get tax authority
	 */
	public Optional<TaxAuthority> getTaxAuthority(
			TaxAuthorityAssoc taxAuthorityAssoc) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthorityAssoc.getTaxAuthGeoId()), new EntityExpr(
						"taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthorityAssoc.getTaxAuthPartyId())),
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
	 * Get to tax authority
	 */
	public Optional<TaxAuthority> getToTaxAuthority(
			TaxAuthorityAssoc taxAuthorityAssoc) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthorityAssoc.getToTaxAuthGeoId()), new EntityExpr(
						"taxAuthPartyId", EntityOperator.EQUALS,
						taxAuthorityAssoc.getToTaxAuthPartyId())),
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
	 * Get tax authority assoc type
	 */
	public Optional<TaxAuthorityAssocType> getTaxAuthorityAssocType(
			TaxAuthorityAssoc taxAuthorityAssoc) {
		List<TaxAuthorityAssocType> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthorityAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("taxAuthorityAssocTypeId",
						EntityOperator.EQUALS, taxAuthorityAssoc
								.getTaxAuthorityAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TaxAuthorityAssocType.fromValues(out.getListIt()
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