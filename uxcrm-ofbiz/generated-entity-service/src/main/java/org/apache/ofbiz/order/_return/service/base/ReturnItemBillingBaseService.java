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
import org.apache.ofbiz.order._return.ReturnItemBilling;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order._return.ReturnHeader;
import org.apache.ofbiz.order._return.ReturnItem;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ReturnItemBillingBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ReturnItemBillingBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ReturnItemBillings
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ReturnItemBilling.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ReturnItemBillings
	 */
	public List<ReturnItemBilling> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ReturnItemBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemBilling.NAME);
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
				entityList = ReturnItemBilling.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ReturnItemBilling
	 */
	public Optional<ReturnItemBilling> findOne(Object returnId,
			Object returnItemSeqId, Object invoiceId, Object invoiceItemSeqId) {
		List<ReturnItemBilling> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItemBilling.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("returnId", EntityOperator.EQUALS, returnId),
				new EntityExpr("returnItemSeqId", EntityOperator.EQUALS,
						returnItemSeqId), new EntityExpr("invoiceId",
						EntityOperator.EQUALS, invoiceId), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						invoiceItemSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemBilling.fromValues(out.getListIt()
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
			ReturnItemBilling returnItemBilling) {
		List<ReturnHeader> entityList = null;
		In in = new In();
		in.setEntityName(ReturnHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("returnId", EntityOperator.EQUALS,
						returnItemBilling.getReturnId())), EntityOperator.AND));
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
	 * Get return item
	 */
	public Optional<ReturnItem> getReturnItem(
			ReturnItemBilling returnItemBilling) {
		List<ReturnItem> entityList = null;
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("returnId", EntityOperator.EQUALS,
						returnItemBilling.getReturnId()), new EntityExpr(
						"returnItemSeqId", EntityOperator.EQUALS,
						returnItemBilling.getReturnItemSeqId())),
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
	 * Get invoice
	 */
	public Optional<Invoice> getInvoice(ReturnItemBilling returnItemBilling) {
		List<Invoice> entityList = null;
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceId", EntityOperator.EQUALS,
						returnItemBilling.getInvoiceId())), EntityOperator.AND));
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
			ReturnItemBilling returnItemBilling) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceId", EntityOperator.EQUALS,
						returnItemBilling.getInvoiceId()), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						returnItemBilling.getInvoiceItemSeqId())),
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
	 * Get shipment receipt
	 */
	public Optional<ShipmentReceipt> getShipmentReceipt(
			ReturnItemBilling returnItemBilling) {
		List<ShipmentReceipt> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentReceipt.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("receiptId", EntityOperator.EQUALS,
						returnItemBilling.getShipmentReceiptId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceipt.fromValues(out.getListIt()
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