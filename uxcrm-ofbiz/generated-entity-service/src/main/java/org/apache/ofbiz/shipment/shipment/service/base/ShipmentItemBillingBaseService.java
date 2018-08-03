package org.apache.ofbiz.shipment.shipment.service.base;

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
import org.apache.ofbiz.shipment.shipment.ShipmentItemBilling;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.shipment.shipment.ShipmentItem;
import org.apache.ofbiz.accounting.invoice.Invoice;
import org.apache.ofbiz.accounting.invoice.InvoiceItem;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentItemBillingBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentItemBillingBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentItemBillings
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentItemBilling.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentItemBillings
	 */
	public List<ShipmentItemBilling> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShipmentItemBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentItemBilling.NAME);
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
				entityList = ShipmentItemBilling.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShipmentItemBilling
	 */
	public Optional<ShipmentItemBilling> findOne(Object shipmentId,
			Object shipmentItemSeqId, Object invoiceId, Object invoiceItemSeqId) {
		List<ShipmentItemBilling> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentItemBilling.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentId), new EntityExpr("shipmentItemSeqId",
						EntityOperator.EQUALS, shipmentItemSeqId),
						new EntityExpr("invoiceId", EntityOperator.EQUALS,
								invoiceId), new EntityExpr("invoiceItemSeqId",
								EntityOperator.EQUALS, invoiceItemSeqId)),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentItemBilling.fromValues(out.getListIt()
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
	 * Get shipment
	 */
	public Optional<Shipment> getShipment(
			ShipmentItemBilling shipmentItemBilling) {
		List<Shipment> entityList = null;
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItemBilling.getShipmentId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Shipment.fromValues(out.getListIt()
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
	 * Get shipment item
	 */
	public Optional<ShipmentItem> getShipmentItem(
			ShipmentItemBilling shipmentItemBilling) {
		List<ShipmentItem> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItemBilling.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItemBilling.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentItem.fromValues(out.getListIt()
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
	public Optional<Invoice> getInvoice(ShipmentItemBilling shipmentItemBilling) {
		List<Invoice> entityList = null;
		In in = new In();
		in.setEntityName(Invoice.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("invoiceId", EntityOperator.EQUALS,
						shipmentItemBilling.getInvoiceId())),
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
	 * Get invoice item
	 */
	public Optional<InvoiceItem> getInvoiceItem(
			ShipmentItemBilling shipmentItemBilling) {
		List<InvoiceItem> entityList = null;
		In in = new In();
		in.setEntityName(InvoiceItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("invoiceId", EntityOperator.EQUALS,
						shipmentItemBilling.getInvoiceId()), new EntityExpr(
						"invoiceItemSeqId", EntityOperator.EQUALS,
						shipmentItemBilling.getInvoiceItemSeqId())),
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