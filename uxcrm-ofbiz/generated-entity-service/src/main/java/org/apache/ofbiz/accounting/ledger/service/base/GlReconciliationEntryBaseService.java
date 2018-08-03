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
import org.apache.ofbiz.accounting.ledger.GlReconciliationEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.accounting.ledger.GlReconciliation;
import org.apache.ofbiz.accounting.ledger.AcctgTransEntry;
import org.apache.ofbiz.accounting.ledger.AcctgTrans;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class GlReconciliationEntryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public GlReconciliationEntryBaseService(
			ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count GlReconciliationEntries
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(GlReconciliationEntry.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find GlReconciliationEntries
	 */
	public List<GlReconciliationEntry> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<GlReconciliationEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GlReconciliationEntry.NAME);
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
				entityList = GlReconciliationEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one GlReconciliationEntry
	 */
	public Optional<GlReconciliationEntry> findOne(Object glReconciliationId,
			Object acctgTransId, Object acctgTransEntrySeqId) {
		List<GlReconciliationEntry> entityList = null;
		In in = new In();
		in.setEntityName(GlReconciliationEntry.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("glReconciliationId", EntityOperator.EQUALS,
						glReconciliationId), new EntityExpr("acctgTransId",
						EntityOperator.EQUALS, acctgTransId), new EntityExpr(
						"acctgTransEntrySeqId", EntityOperator.EQUALS,
						acctgTransEntrySeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlReconciliationEntry.fromValues(out.getListIt()
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
	 * Get gl reconciliation
	 */
	public Optional<GlReconciliation> getGlReconciliation(
			GlReconciliationEntry glReconciliationEntry) {
		List<GlReconciliation> entityList = null;
		In in = new In();
		in.setEntityName(GlReconciliation.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glReconciliationId",
						EntityOperator.EQUALS, glReconciliationEntry
								.getGlReconciliationId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GlReconciliation.fromValues(out.getListIt()
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
	 * Get acctg trans entry
	 */
	public Optional<AcctgTransEntry> getAcctgTransEntry(
			GlReconciliationEntry glReconciliationEntry) {
		List<AcctgTransEntry> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTransEntry.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("acctgTransId", EntityOperator.EQUALS,
						glReconciliationEntry.getAcctgTransId()),
				new EntityExpr("acctgTransEntrySeqId", EntityOperator.EQUALS,
						glReconciliationEntry.getAcctgTransEntrySeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTransEntry.fromValues(out.getListIt()
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
	 * Get acctg trans
	 */
	public Optional<AcctgTrans> getAcctgTrans(
			GlReconciliationEntry glReconciliationEntry) {
		List<AcctgTrans> entityList = null;
		In in = new In();
		in.setEntityName(AcctgTrans.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("acctgTransId", EntityOperator.EQUALS,
						glReconciliationEntry.getAcctgTransId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = AcctgTrans.fromValues(out.getListIt()
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