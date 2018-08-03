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
import org.apache.ofbiz.accounting.tax.PartyTaxAuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.tax.TaxAuthority;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyTaxAuthInfoBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyTaxAuthInfoBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyTaxAuthInfoes
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyTaxAuthInfo.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyTaxAuthInfoes
	 */
	public List<PartyTaxAuthInfo> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
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
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
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
	 * Find one PartyTaxAuthInfo
	 */
	public Optional<PartyTaxAuthInfo> findOne(Object partyId,
			Object taxAuthGeoId, Object taxAuthPartyId, Object fromDate) {
		List<PartyTaxAuthInfo> entityList = null;
		In in = new In();
		in.setEntityName(PartyTaxAuthInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("partyId", EntityOperator.EQUALS, partyId),
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						taxAuthGeoId), new EntityExpr("taxAuthPartyId",
						EntityOperator.EQUALS, taxAuthPartyId), new EntityExpr(
						"fromDate", EntityOperator.EQUALS, fromDate)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyTaxAuthInfo.fromValues(out.getListIt()
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
	 * Get party
	 */
	public Optional<Party> getParty(PartyTaxAuthInfo partyTaxAuthInfo) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyTaxAuthInfo.getPartyId())), EntityOperator.AND));
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
	 * Get tax authority
	 */
	public Optional<TaxAuthority> getTaxAuthority(
			PartyTaxAuthInfo partyTaxAuthInfo) {
		List<TaxAuthority> entityList = null;
		In in = new In();
		in.setEntityName(TaxAuthority.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("taxAuthGeoId", EntityOperator.EQUALS,
						partyTaxAuthInfo.getTaxAuthGeoId()), new EntityExpr(
						"taxAuthPartyId", EntityOperator.EQUALS,
						partyTaxAuthInfo.getTaxAuthPartyId())),
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
}