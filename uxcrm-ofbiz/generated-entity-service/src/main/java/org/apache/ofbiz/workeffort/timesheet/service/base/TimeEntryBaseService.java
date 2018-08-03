package org.apache.ofbiz.workeffort.timesheet.service.base;

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
import org.apache.ofbiz.workeffort.timesheet.TimeEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.accounting.rate.RateType;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.workeffort.timesheet.Timesheet;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class TimeEntryBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public TimeEntryBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count TimeEntries
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(TimeEntry.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find TimeEntries
	 */
	public List<TimeEntry> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<TimeEntry> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(TimeEntry.NAME);
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
				entityList = TimeEntry.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one TimeEntry
	 */
	public Optional<TimeEntry> findOne(Object timeEntryId) {
		List<TimeEntry> entityList = null;
		In in = new In();
		in.setEntityName(TimeEntry.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("timeEntryId", EntityOperator.EQUALS,
						timeEntryId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = TimeEntry.fromValues(out.getListIt()
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
	public Optional<Party> getParty(TimeEntry timeEntry) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						timeEntry.getPartyId())), EntityOperator.AND));
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
	 * Get rate type
	 */
	public Optional<RateType> getRateType(TimeEntry timeEntry) {
		List<RateType> entityList = null;
		In in = new In();
		in.setEntityName(RateType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("rateTypeId", EntityOperator.EQUALS,
						timeEntry.getRateTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RateType.fromValues(out.getListIt()
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
	 * Get work effort
	 */
	public Optional<WorkEffort> getWorkEffort(TimeEntry timeEntry) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						timeEntry.getWorkEffortId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffort.fromValues(out.getListIt()
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
	 * Get timesheet
	 */
	public Optional<Timesheet> getTimesheet(TimeEntry timeEntry) {
		List<Timesheet> entityList = null;
		In in = new In();
		in.setEntityName(Timesheet.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("timesheetId", EntityOperator.EQUALS,
						timeEntry.getTimesheetId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Timesheet.fromValues(out.getListIt()
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
	public Optional<Invoice> getInvoice(TimeEntry timeEntry) {
		List<Invoice> entityList = null;
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceId", EntityOperator.EQUALS,
						timeEntry.getInvoiceId())), EntityOperator.AND));
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
	 * Get invoice item
	 */
	public Optional<InvoiceItem> getInvoiceItem(TimeEntry timeEntry) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(
						new EntityExpr("invoiceId", EntityOperator.EQUALS,
								timeEntry.getInvoiceId()),
						new EntityExpr("invoiceItemSeqId",
								EntityOperator.EQUALS, timeEntry
										.getInvoiceItemSeqId())),
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
}