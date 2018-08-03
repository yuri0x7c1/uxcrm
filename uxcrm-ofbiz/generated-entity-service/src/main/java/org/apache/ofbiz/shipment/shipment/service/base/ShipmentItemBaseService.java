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
import org.apache.ofbiz.shipment.shipment.ShipmentItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.shipment.shipment.Shipment;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.shipment.issuance.ItemIssuance;
import org.apache.ofbiz.order.order.OrderShipment;
import org.apache.ofbiz.order._return.ReturnItemShipment;
import org.apache.ofbiz.shipment.shipment.ShipmentItemBilling;
import org.apache.ofbiz.shipment.shipment.ShipmentItemFeature;
import org.apache.ofbiz.shipment.shipment.ShipmentPackageContent;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;
import org.apache.ofbiz.shipment.shipment.ShippingDocument;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShipmentItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShipmentItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShipmentItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShipmentItems
	 */
	public List<ShipmentItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShipmentItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
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
				entityList = ShipmentItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShipmentItem
	 */
	public Optional<ShipmentItem> findOne(Object shipmentId,
			Object shipmentItemSeqId) {
		List<ShipmentItem> entityList = null;
		In in = new In();
		in.setEntityName(ShipmentItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentId), new EntityExpr("shipmentItemSeqId",
						EntityOperator.EQUALS, shipmentItemSeqId)),
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
	 * Get shipment
	 */
	public Optional<Shipment> getShipment(ShipmentItem shipmentItem) {
		List<Shipment> entityList = null;
		In in = new In();
		in.setEntityName(Shipment.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId())), EntityOperator.AND));
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
	 * Get product
	 */
	public Optional<Product> getProduct(ShipmentItem shipmentItem) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						shipmentItem.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Product.fromValues(out.getListIt()
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
	 * Get item issuances
	 */
	public List<ItemIssuance> getItemIssuances(ShipmentItem shipmentItem,
			Integer start, Integer number, List<String> orderBy) {
		List<ItemIssuance> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ItemIssuance.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ItemIssuance.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order shipments
	 */
	public List<OrderShipment> getOrderShipments(ShipmentItem shipmentItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderShipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderShipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderShipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return item shipments
	 */
	public List<ReturnItemShipment> getReturnItemShipments(
			ShipmentItem shipmentItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ReturnItemShipment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItemShipment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItemShipment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment item billings
	 */
	public List<ShipmentItemBilling> getShipmentItemBillings(
			ShipmentItem shipmentItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
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
	 * Get shipment item features
	 */
	public List<ShipmentItemFeature> getShipmentItemFeatures(
			ShipmentItem shipmentItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentItemFeature> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentItemFeature.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentItemFeature.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment package contents
	 */
	public List<ShipmentPackageContent> getShipmentPackageContents(
			ShipmentItem shipmentItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ShipmentPackageContent> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentPackageContent.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentPackageContent.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipment receipts
	 */
	public List<ShipmentReceipt> getShipmentReceipts(ShipmentItem shipmentItem,
			Integer start, Integer number, List<String> orderBy) {
		List<ShipmentReceipt> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShipmentReceipt.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShipmentReceipt.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shipping documents
	 */
	public List<ShippingDocument> getShippingDocuments(
			ShipmentItem shipmentItem, Integer start, Integer number,
			List<String> orderBy) {
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
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentId", EntityOperator.EQUALS,
						shipmentItem.getShipmentId()), new EntityExpr(
						"shipmentItemSeqId", EntityOperator.EQUALS,
						shipmentItem.getShipmentItemSeqId())),
				EntityOperator.AND));
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
}