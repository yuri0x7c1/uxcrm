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
import org.apache.ofbiz.shipment.shipment.ShippingDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.content.document.Document;
import org.apache.ofbiz.shipment.shipment.ShipmentItem;
import org.apache.ofbiz.shipment.shipment.ShipmentPackage;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShippingDocumentBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShippingDocumentBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShippingDocuments
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShippingDocument.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShippingDocuments
	 */
	public List<ShippingDocument> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShippingDocument> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShippingDocument.NAME);
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
				entityList = ShippingDocument.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShippingDocument
	 */
	public Optional<ShippingDocument> findOne(Object documentId) {
		List<ShippingDocument> entityList = null;
		In in = new In();
		in.setEntityName(ShippingDocument.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						documentId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShippingDocument.fromValues(out.getListIt()
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
	 * Get document
	 */
	public Optional<Document> getDocument(ShippingDocument shippingDocument) {
		List<Document> entityList = null;
		In in = new In();
		in.setEntityName(Document.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("documentId", EntityOperator.EQUALS,
						shippingDocument.getDocumentId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Document.fromValues(out.getListIt()
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
			ShippingDocument shippingDocument) {
		List<ShipmentItem> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shippingDocument.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shippingDocument.getShipmentItemSeqId())),
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
	 * Get shipment package
	 */
	public Optional<ShipmentPackage> getShipmentPackage(
			ShippingDocument shippingDocument) {
		List<ShipmentPackage> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentPackage.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shippingDocument.getShipmentId()), new EntityExpr(
						"shipmentPackageSeqId", EntityOperator.EQUALS,
						shippingDocument.getShipmentPackageSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackage.fromValues(out.getListIt()
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