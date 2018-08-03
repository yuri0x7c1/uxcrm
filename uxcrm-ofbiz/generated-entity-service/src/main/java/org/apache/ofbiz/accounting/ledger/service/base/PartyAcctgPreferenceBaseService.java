package org.apache.ofbiz.accounting.ledger.service.base;

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
import org.apache.ofbiz.accounting.ledger.PartyAcctgPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.common._enum.Enumeration;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.common.method.CustomMethod;
import org.apache.ofbiz.accounting.payment.PaymentMethod;
import org.apache.ofbiz.accounting.ledger.GlJournal;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class PartyAcctgPreferenceBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public PartyAcctgPreferenceBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count PartyAcctgPreferences
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find PartyAcctgPreferences
	 */
	public List<PartyAcctgPreference> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<PartyAcctgPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
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
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one PartyAcctgPreference
	 */
	public Optional<PartyAcctgPreference> findOne(Object partyId) {
		List<PartyAcctgPreference> entityList = null;
		In in = new In();
		in.setEntityName(PartyAcctgPreference.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PartyAcctgPreference.fromValues(out.getListIt()
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
	public Optional<Party> getParty(PartyAcctgPreference partyAcctgPreference) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						partyAcctgPreference.getPartyId())), EntityOperator.AND));
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
	 * Get tax form enumeration
	 */
	public Optional<Enumeration> getTaxFormEnumeration(
			PartyAcctgPreference partyAcctgPreference) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						partyAcctgPreference.getTaxFormId())),
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
	 * Get cogs enumeration
	 */
	public Optional<Enumeration> getCogsEnumeration(
			PartyAcctgPreference partyAcctgPreference) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						partyAcctgPreference.getCogsMethodId())),
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
	 * Get uom
	 */
	public Optional<Uom> getUom(PartyAcctgPreference partyAcctgPreference) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						partyAcctgPreference.getBaseCurrencyUomId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Uom.fromValues(out.getListIt().getCompleteList());
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
	 * Get invoice custom method
	 */
	public Optional<CustomMethod> getInvoiceCustomMethod(
			PartyAcctgPreference partyAcctgPreference) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						partyAcctgPreference.getInvoiceSeqCustMethId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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
	 * Get quote custom method
	 */
	public Optional<CustomMethod> getQuoteCustomMethod(
			PartyAcctgPreference partyAcctgPreference) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						partyAcctgPreference.getQuoteSeqCustMethId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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
	 * Get order custom method
	 */
	public Optional<CustomMethod> getOrderCustomMethod(
			PartyAcctgPreference partyAcctgPreference) {
		List<CustomMethod> entityList = null;
		In in = new In();
		in.setEntityName(CustomMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("customMethodId", EntityOperator.EQUALS,
						partyAcctgPreference.getOrderSeqCustMethId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CustomMethod.fromValues(out.getListIt()
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
	 * Get payment method
	 */
	public Optional<PaymentMethod> getPaymentMethod(
			PartyAcctgPreference partyAcctgPreference) {
		List<PaymentMethod> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodId",
						EntityOperator.EQUALS, partyAcctgPreference
								.getRefundPaymentMethodId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethod.fromValues(out.getListIt()
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
	 * Get gl journal
	 */
	public Optional<GlJournal> getGlJournal(
			PartyAcctgPreference partyAcctgPreference) {
		List<GlJournal> entityList = null;
		In in = new In();
		in.setEntityName(GlJournal.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glJournalId", EntityOperator.EQUALS,
						partyAcctgPreference.getErrorGlJournalId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlJournal.fromValues(out.getListIt()
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
	 * Get invoice sequence enumeration
	 */
	public Optional<Enumeration> getInvoiceSequenceEnumeration(
			PartyAcctgPreference partyAcctgPreference) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						partyAcctgPreference.getOldInvoiceSequenceEnumId())),
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
	 * Get quote sequence enumeration
	 */
	public Optional<Enumeration> getQuoteSequenceEnumeration(
			PartyAcctgPreference partyAcctgPreference) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						partyAcctgPreference.getOldQuoteSequenceEnumId())),
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
	 * Get order sequence enumeration
	 */
	public Optional<Enumeration> getOrderSequenceEnumeration(
			PartyAcctgPreference partyAcctgPreference) {
		List<Enumeration> entityList = null;
		In in = new In();
		in.setEntityName(Enumeration.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("enumId", EntityOperator.EQUALS,
						partyAcctgPreference.getOldOrderSequenceEnumId())),
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
}