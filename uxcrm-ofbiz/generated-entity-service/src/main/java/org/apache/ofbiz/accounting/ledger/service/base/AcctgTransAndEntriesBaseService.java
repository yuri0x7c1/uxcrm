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
import org.apache.ofbiz.accounting.ledger.AcctgTransAndEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.apache.ofbiz.accounting.ledger.GlAccountClass;
import org.apache.ofbiz.accounting.ledger.AcctgTransType;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.payment.Payment;
import org.apache.ofbiz.accounting.ledger.GlJournal;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class AcctgTransAndEntriesBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public AcctgTransAndEntriesBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count AcctgTransAndEntrieses
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(AcctgTransAndEntries.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find AcctgTransAndEntrieses
	 */
	public List<AcctgTransAndEntries> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<AcctgTransAndEntries> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(AcctgTransAndEntries.NAME);
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
				entityList = AcctgTransAndEntries.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one AcctgTransAndEntries
	 */
	public Optional<AcctgTransAndEntries> findOne(Object acctgTransId,
			Object acctgTransEntrySeqId, Object glAccountClassId) {
		List<AcctgTransAndEntries> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransAndEntries.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("acctgTransId", EntityOperator.EQUALS,
						acctgTransId), new EntityExpr("acctgTransEntrySeqId",
						EntityOperator.EQUALS, acctgTransEntrySeqId),
				new EntityExpr("glAccountClassId", EntityOperator.EQUALS,
						glAccountClassId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransAndEntries.fromValues(out.getListIt()
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
	 * Get gl account
	 */
	public Optional<GlAccount> getGlAccount(
			AcctgTransAndEntries acctgTransAndEntries) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						acctgTransAndEntries.getGlAccountId())),
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
	 * Get gl account class
	 */
	public Optional<GlAccountClass> getGlAccountClass(
			AcctgTransAndEntries acctgTransAndEntries) {
		List<GlAccountClass> entityList = null;
		In in = new In();
		in.setEntityName(GlAccountClass.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountClassId",
						EntityOperator.EQUALS, acctgTransAndEntries
								.getGlAccountClassId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlAccountClass.fromValues(out.getListIt()
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
	 * Get acctg trans type
	 */
	public Optional<AcctgTransType> getAcctgTransType(
			AcctgTransAndEntries acctgTransAndEntries) {
		List<AcctgTransType> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransTypeId",
						EntityOperator.EQUALS, acctgTransAndEntries
								.getAcctgTransTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransType.fromValues(out.getListIt()
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
	 * Get invoice
	 */
	public Optional<Invoice> getInvoice(
			AcctgTransAndEntries acctgTransAndEntries) {
		List<Invoice> entityList = null;
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceId", EntityOperator.EQUALS,
						acctgTransAndEntries.getInvoiceId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Invoice.fromValues(out.getListIt()
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
	 * Get payment
	 */
	public Optional<Payment> getPayment(
			AcctgTransAndEntries acctgTransAndEntries) {
		List<Payment> entityList = null;
		In in = new In();
		in.setEntityName(Payment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentId", EntityOperator.EQUALS,
						acctgTransAndEntries.getPaymentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Payment.fromValues(out.getListIt()
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
			AcctgTransAndEntries acctgTransAndEntries) {
		List<GlJournal> entityList = null;
		In in = new In();
		in.setEntityName(GlJournal.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glJournalId", EntityOperator.EQUALS,
						acctgTransAndEntries.getGlJournalId())),
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
}