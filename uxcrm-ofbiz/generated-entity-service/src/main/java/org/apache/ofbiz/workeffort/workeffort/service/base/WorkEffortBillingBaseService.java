package org.apache.ofbiz.workeffort.workeffort.service.base;

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
import org.apache.ofbiz.workeffort.workeffort.WorkEffortBilling;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.workeffort.workeffort.WorkEffort;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class WorkEffortBillingBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public WorkEffortBillingBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count WorkEffortBillings
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(WorkEffortBilling.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find WorkEffortBillings
	 */
	public List<WorkEffortBilling> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<WorkEffortBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkEffortBilling.NAME);
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
				entityList = WorkEffortBilling.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one WorkEffortBilling
	 */
	public Optional<WorkEffortBilling> findOne(Object workEffortId,
			Object invoiceId, Object invoiceItemSeqId) {
		List<WorkEffortBilling> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffortBilling.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortId), new EntityExpr("invoiceId",
						EntityOperator.EQUALS, invoiceId), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						invoiceItemSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkEffortBilling.fromValues(out.getListIt()
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
	public Optional<WorkEffort> getWorkEffort(
			WorkEffortBilling workEffortBilling) {
		List<WorkEffort> entityList = null;
		In in = new In();
		in.setEntityName(WorkEffort.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("workEffortId", EntityOperator.EQUALS,
						workEffortBilling.getWorkEffortId())),
				EntityOperator.AND));
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
	 * Get invoice
	 */
	public Optional<Invoice> getInvoice(WorkEffortBilling workEffortBilling) {
		List<Invoice> entityList = null;
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceId", EntityOperator.EQUALS,
						workEffortBilling.getInvoiceId())), EntityOperator.AND));
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
	public Optional<InvoiceItem> getInvoiceItem(
			WorkEffortBilling workEffortBilling) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceId", EntityOperator.EQUALS,
						workEffortBilling.getInvoiceId()), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						workEffortBilling.getInvoiceItemSeqId())),
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