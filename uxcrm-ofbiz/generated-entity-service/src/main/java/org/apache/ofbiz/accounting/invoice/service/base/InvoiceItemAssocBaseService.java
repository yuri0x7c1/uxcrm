package org.apache.ofbiz.accounting.invoice.service.base;

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
import org.apache.ofbiz.accounting.invoice.InvoiceItemAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.invoice.InvoiceItemAssocType;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.party.party.Party;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class InvoiceItemAssocBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public InvoiceItemAssocBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count InvoiceItemAssocs
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(InvoiceItemAssoc.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find InvoiceItemAssocs
	 */
	public List<InvoiceItemAssoc> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<InvoiceItemAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(InvoiceItemAssoc.NAME);
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
				entityList = InvoiceItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one InvoiceItemAssoc
	 */
	public Optional<InvoiceItemAssoc> findOne(Object invoiceIdFrom,
			Object invoiceItemSeqIdFrom, Object invoiceIdTo,
			Object invoiceItemSeqIdTo, Object invoiceItemAssocTypeId,
			Object fromDate) {
		List<InvoiceItemAssoc> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItemAssoc.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceIdFrom", EntityOperator.EQUALS,
						invoiceIdFrom), new EntityExpr("invoiceItemSeqIdFrom",
						EntityOperator.EQUALS, invoiceItemSeqIdFrom),
				new EntityExpr("invoiceIdTo", EntityOperator.EQUALS,
						invoiceIdTo), new EntityExpr("invoiceItemSeqIdTo",
						EntityOperator.EQUALS, invoiceItemSeqIdTo),
				new EntityExpr("invoiceItemAssocTypeId", EntityOperator.EQUALS,
						invoiceItemAssocTypeId), new EntityExpr("fromDate",
						EntityOperator.EQUALS, fromDate)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemAssoc.fromValues(out.getListIt()
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
	 * Get invoice item assoc type
	 */
	public Optional<InvoiceItemAssocType> getInvoiceItemAssocType(
			InvoiceItemAssoc invoiceItemAssoc) {
		List<InvoiceItemAssocType> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItemAssocType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceItemAssocTypeId",
						EntityOperator.EQUALS, invoiceItemAssoc
								.getInvoiceItemAssocTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItemAssocType.fromValues(out.getListIt()
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
	 * Get from invoice item
	 */
	public Optional<InvoiceItem> getFromInvoiceItem(
			InvoiceItemAssoc invoiceItemAssoc) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceId", EntityOperator.EQUALS,
						invoiceItemAssoc.getInvoiceIdFrom()), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						invoiceItemAssoc.getInvoiceItemSeqIdFrom())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItem.fromValues(out.getListIt()
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
	 * Get to invoice item
	 */
	public Optional<InvoiceItem> getToInvoiceItem(
			InvoiceItemAssoc invoiceItemAssoc) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceId", EntityOperator.EQUALS,
						invoiceItemAssoc.getInvoiceIdTo()), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						invoiceItemAssoc.getInvoiceItemSeqIdTo())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InvoiceItem.fromValues(out.getListIt()
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
	 * Get from party
	 */
	public Optional<Party> getFromParty(InvoiceItemAssoc invoiceItemAssoc) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						invoiceItemAssoc.getPartyIdFrom())), EntityOperator.AND));
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
	 * Get to party
	 */
	public Optional<Party> getToParty(InvoiceItemAssoc invoiceItemAssoc) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						invoiceItemAssoc.getPartyIdTo())), EntityOperator.AND));
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
}