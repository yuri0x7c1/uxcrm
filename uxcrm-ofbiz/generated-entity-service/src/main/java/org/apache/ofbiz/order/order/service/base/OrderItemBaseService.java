package org.apache.ofbiz.order.order.service.base;

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
import org.apache.ofbiz.order.order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.order.OrderItemType;
import org.apache.ofbiz.order.order.OrderItemGroup;
import org.apache.ofbiz.order.order.OrderItemTypeAttr;
import org.apache.ofbiz.product.product.Product;
import org.apache.ofbiz.product.inventory.InventoryItem;
import org.apache.ofbiz.common.uom.Uom;
import org.apache.ofbiz.common.status.StatusItem;
import org.apache.ofbiz.product.facility.ProductFacilityLocation;
import org.apache.ofbiz.common.status.StatusValidChange;
import org.apache.ofbiz.security.login.UserLogin;
import org.apache.ofbiz.order.quote.QuoteItem;
import org.apache.ofbiz.accounting.ledger.GlAccount;
import org.apache.ofbiz.marketing.opportunity.SalesOpportunity;
import org.apache.ofbiz.accounting.finaccount.FinAccountTrans;
import org.apache.ofbiz.accounting.fixedasset.FixedAsset;
import org.apache.ofbiz.accounting.fixedasset.FixedAssetMaintOrder;
import org.apache.ofbiz.accounting.payment.GiftCardFulfillment;
import org.apache.ofbiz.shipment.issuance.ItemIssuance;
import org.apache.ofbiz.order.order.OldOrderItemAssociation;
import org.apache.ofbiz.order.order.OldOrderItemInventoryRes;
import org.apache.ofbiz.order.order.OldOrderShipmentPreference;
import org.apache.ofbiz.accounting.payment.OldValueLinkFulfillment;
import org.apache.ofbiz.order.order.OrderAdjustment;
import org.apache.ofbiz.order.order.OrderDeliverySchedule;
import org.apache.ofbiz.order.order.OrderItemAssoc;
import org.apache.ofbiz.order.order.OrderItemAttribute;
import org.apache.ofbiz.order.order.OrderItemBilling;
import org.apache.ofbiz.order.order.OrderItemChange;
import org.apache.ofbiz.order.order.OrderItemContactMech;
import org.apache.ofbiz.order.order.OrderItemGroupOrder;
import org.apache.ofbiz.order.order.OrderItemPriceInfo;
import org.apache.ofbiz.order.order.OrderItemRole;
import org.apache.ofbiz.order.order.OrderItemShipGroupAssoc;
import org.apache.ofbiz.order.order.OrderItemShipGrpInvRes;
import org.apache.ofbiz.order.order.OrderPaymentPreference;
import org.apache.ofbiz.order.requirement.OrderRequirementCommitment;
import org.apache.ofbiz.order.order.OrderShipment;
import org.apache.ofbiz.order.order.OrderStatus;
import org.apache.ofbiz.order.order.OrderTerm;
import org.apache.ofbiz.shipment.picklist.PicklistItem;
import org.apache.ofbiz.order.order.ProductOrderItem;
import org.apache.ofbiz.order._return.ReturnItem;
import org.apache.ofbiz.shipment.receipt.ShipmentReceipt;
import org.apache.ofbiz.product.subscription.Subscription;
import org.apache.ofbiz.content.survey.SurveyResponse;
import org.apache.ofbiz.order.order.WorkOrderItemFulfillment;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class OrderItemBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public OrderItemBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count OrderItems
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find OrderItems
	 */
	public List<OrderItem> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<OrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItem.NAME);
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
				entityList = OrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one OrderItem
	 */
	public Optional<OrderItem> findOne(Object orderId, Object orderItemSeqId) {
		List<OrderItem> entityList = null;
		In in = new In();
		in.setEntityName(OrderItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderId),
				new EntityExpr("orderItemSeqId", EntityOperator.EQUALS,
						orderItemSeqId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItem.fromValues(out.getListIt()
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
	 * Get order header
	 */
	public Optional<OrderHeader> getOrderHeader(OrderItem orderItem) {
		List<OrderHeader> entityList = null;
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("orderId", EntityOperator.EQUALS,
						orderItem.getOrderId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
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
	 * Get order item type
	 */
	public Optional<OrderItemType> getOrderItemType(OrderItem orderItem) {
		List<OrderItemType> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItem.getOrderItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemType.fromValues(out.getListIt()
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
	 * Get order item group
	 */
	public Optional<OrderItemGroup> getOrderItemGroup(OrderItem orderItem) {
		List<OrderItemGroup> entityList = null;
		In in = new In();
		in.setEntityName(OrderItemGroup.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()),
				new EntityExpr("orderItemGroupSeqId", EntityOperator.EQUALS,
						orderItem.getOrderItemGroupSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemGroup.fromValues(out.getListIt()
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
	 * Get order item type attrs
	 */
	public List<OrderItemTypeAttr> getOrderItemTypeAttrs(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemTypeAttr> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemTypeAttr.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("orderItemTypeId",
						EntityOperator.EQUALS, orderItem.getOrderItemTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemTypeAttr.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product
	 */
	public Optional<Product> getProduct(OrderItem orderItem) {
		List<Product> entityList = null;
		In in = new In();
		in.setEntityName(Product.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						orderItem.getProductId())), EntityOperator.AND));
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
	 * Get from inventory item
	 */
	public Optional<InventoryItem> getFromInventoryItem(OrderItem orderItem) {
		List<InventoryItem> entityList = null;
		In in = new In();
		in.setEntityName(InventoryItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("inventoryItemId",
						EntityOperator.EQUALS, orderItem
								.getFromInventoryItemId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = InventoryItem.fromValues(out.getListIt()
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
	 * Get recurring freq uom
	 */
	public Optional<Uom> getRecurringFreqUom(OrderItem orderItem) {
		List<Uom> entityList = null;
		In in = new In();
		in.setEntityName(Uom.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("uomId", EntityOperator.EQUALS,
						orderItem.getRecurringFreqUomId())), EntityOperator.AND));
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
	 * Get status item
	 */
	public Optional<StatusItem> getStatusItem(OrderItem orderItem) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						orderItem.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get product facility locations
	 */
	public List<ProductFacilityLocation> getProductFacilityLocations(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductFacilityLocation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductFacilityLocation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productId", EntityOperator.EQUALS,
						orderItem.getProductId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductFacilityLocation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get status valid changes
	 */
	public List<StatusValidChange> getStatusValidChanges(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<StatusValidChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(StatusValidChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						orderItem.getStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusValidChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get sync status item
	 */
	public Optional<StatusItem> getSyncStatusItem(OrderItem orderItem) {
		List<StatusItem> entityList = null;
		In in = new In();
		in.setEntityName(StatusItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("statusId", EntityOperator.EQUALS,
						orderItem.getSyncStatusId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = StatusItem.fromValues(out.getListIt()
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
	 * Get dont cancel set user login
	 */
	public Optional<UserLogin> getDontCancelSetUserLogin(OrderItem orderItem) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						orderItem.getDontCancelSetUserLogin())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get quote item
	 */
	public Optional<QuoteItem> getQuoteItem(OrderItem orderItem) {
		List<QuoteItem> entityList = null;
		In in = new In();
		in.setEntityName(QuoteItem.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("quoteId", EntityOperator.EQUALS, orderItem
						.getQuoteId()), new EntityExpr("quoteItemSeqId",
						EntityOperator.EQUALS, orderItem.getQuoteItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = QuoteItem.fromValues(out.getListIt()
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
	 * Get override gl account
	 */
	public Optional<GlAccount> getOverrideGlAccount(OrderItem orderItem) {
		List<GlAccount> entityList = null;
		In in = new In();
		in.setEntityName(GlAccount.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("glAccountId", EntityOperator.EQUALS,
						orderItem.getOverrideGlAccountId())),
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
	 * Get sales opportunity
	 */
	public Optional<SalesOpportunity> getSalesOpportunity(OrderItem orderItem) {
		List<SalesOpportunity> entityList = null;
		In in = new In();
		in.setEntityName(SalesOpportunity.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("salesOpportunityId",
						EntityOperator.EQUALS, orderItem
								.getSalesOpportunityId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SalesOpportunity.fromValues(out.getListIt()
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
	 * Get change by user login
	 */
	public Optional<UserLogin> getChangeByUserLogin(OrderItem orderItem) {
		List<UserLogin> entityList = null;
		In in = new In();
		in.setEntityName(UserLogin.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("userLoginId", EntityOperator.EQUALS,
						orderItem.getChangeByUserLoginId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = UserLogin.fromValues(out.getListIt()
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
	 * Get fin account transes
	 */
	public List<FinAccountTrans> getFinAccountTranses(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<FinAccountTrans> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FinAccountTrans.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FinAccountTrans.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get acquire fixed assets
	 */
	public List<FixedAsset> getAcquireFixedAssets(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<FixedAsset> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAsset.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("acquireOrderId", EntityOperator.EQUALS,
						orderItem.getOrderId()), new EntityExpr(
						"acquireOrderItemSeqId", EntityOperator.EQUALS,
						orderItem.getOrderItemSeqId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAsset.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get fixed asset maint orders
	 */
	public List<FixedAssetMaintOrder> getFixedAssetMaintOrders(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<FixedAssetMaintOrder> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(FixedAssetMaintOrder.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = FixedAssetMaintOrder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get gift card fulfillments
	 */
	public List<GiftCardFulfillment> getGiftCardFulfillments(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<GiftCardFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(GiftCardFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = GiftCardFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get item issuances
	 */
	public List<ItemIssuance> getItemIssuances(OrderItem orderItem,
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
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
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
	 * Get sales old order item associations
	 */
	public List<OldOrderItemAssociation> getSalesOldOrderItemAssociations(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OldOrderItemAssociation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldOrderItemAssociation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("salesOrderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("soItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderItemAssociation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get purchase old order item associations
	 */
	public List<OldOrderItemAssociation> getPurchaseOldOrderItemAssociations(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OldOrderItemAssociation> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldOrderItemAssociation.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("purchaseOrderId", EntityOperator.EQUALS,
						orderItem.getOrderId()), new EntityExpr("poItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderItemAssociation.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old order item inventory reses
	 */
	public List<OldOrderItemInventoryRes> getOldOrderItemInventoryReses(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OldOrderItemInventoryRes> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldOrderItemInventoryRes.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderItemInventoryRes.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get old order shipment preference
	 */
	public Optional<OldOrderShipmentPreference> getOldOrderShipmentPreference(
			OrderItem orderItem) {
		List<OldOrderShipmentPreference> entityList = null;
		In in = new In();
		in.setEntityName(OldOrderShipmentPreference.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldOrderShipmentPreference.fromValues(out
						.getListIt().getCompleteList());
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
	 * Get old value link fulfillments
	 */
	public List<OldValueLinkFulfillment> getOldValueLinkFulfillments(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OldValueLinkFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OldValueLinkFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OldValueLinkFulfillment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order adjustments
	 */
	public List<OrderAdjustment> getOrderAdjustments(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderAdjustment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderAdjustment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderAdjustment.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order delivery schedule
	 */
	public Optional<OrderDeliverySchedule> getOrderDeliverySchedule(
			OrderItem orderItem) {
		List<OrderDeliverySchedule> entityList = null;
		In in = new In();
		in.setEntityName(OrderDeliverySchedule.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderDeliverySchedule.fromValues(out.getListIt()
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
	 * Get from order item assocs
	 */
	public List<OrderItemAssoc> getFromOrderItemAssocs(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get to order item assocs
	 */
	public List<OrderItemAssoc> getToOrderItemAssocs(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("toOrderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("toOrderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item attributes
	 */
	public List<OrderItemAttribute> getOrderItemAttributes(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemAttribute> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemAttribute.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemAttribute.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item billings
	 */
	public List<OrderItemBilling> getOrderItemBillings(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemBilling> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemBilling.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemBilling.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item changes
	 */
	public List<OrderItemChange> getOrderItemChanges(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemChange> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemChange.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemChange.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item contact meches
	 */
	public List<OrderItemContactMech> getOrderItemContactMeches(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemContactMech> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemContactMech.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemContactMech.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item group orders
	 */
	public List<OrderItemGroupOrder> getOrderItemGroupOrders(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemGroupOrder> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemGroupOrder.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemGroupOrder.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item price infoes
	 */
	public List<OrderItemPriceInfo> getOrderItemPriceInfoes(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemPriceInfo> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemPriceInfo.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemPriceInfo.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item roles
	 */
	public List<OrderItemRole> getOrderItemRoles(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderItemRole> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemRole.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemRole.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item ship group assocs
	 */
	public List<OrderItemShipGroupAssoc> getOrderItemShipGroupAssocs(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemShipGroupAssoc> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGroupAssoc.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGroupAssoc.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order item ship grp inv reses
	 */
	public List<OrderItemShipGrpInvRes> getOrderItemShipGrpInvReses(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderItemShipGrpInvRes> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderItemShipGrpInvRes.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderItemShipGrpInvRes.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order payment preferences
	 */
	public List<OrderPaymentPreference> getOrderPaymentPreferences(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderPaymentPreference> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderPaymentPreference.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderPaymentPreference.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order requirement commitments
	 */
	public List<OrderRequirementCommitment> getOrderRequirementCommitments(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderRequirementCommitment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderRequirementCommitment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderRequirementCommitment.fromValues(out
						.getListIt().getPartialList(start, number));
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
	public List<OrderShipment> getOrderShipments(OrderItem orderItem,
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
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
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
	 * Get order statuses
	 */
	public List<OrderStatus> getOrderStatuses(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<OrderStatus> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderStatus.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderStatus.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get order terms
	 */
	public List<OrderTerm> getOrderTerms(OrderItem orderItem, Integer start,
			Integer number, List<String> orderBy) {
		List<OrderTerm> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderTerm.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderTerm.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get picklist items
	 */
	public List<PicklistItem> getPicklistItems(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<PicklistItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(PicklistItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PicklistItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get product order items
	 */
	public List<ProductOrderItem> getProductOrderItems(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<ProductOrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductOrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductOrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get engagement product order items
	 */
	public List<ProductOrderItem> getEngagementProductOrderItems(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductOrderItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductOrderItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("engagementId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("engagementItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductOrderItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get return items
	 */
	public List<ReturnItem> getReturnItems(OrderItem orderItem, Integer start,
			Integer number, List<String> orderBy) {
		List<ReturnItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ReturnItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ReturnItem.fromValues(out.getListIt()
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
	public List<ShipmentReceipt> getShipmentReceipts(OrderItem orderItem,
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
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
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
	 * Get subscriptions
	 */
	public List<Subscription> getSubscriptions(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<Subscription> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(Subscription.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = Subscription.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get survey responses
	 */
	public List<SurveyResponse> getSurveyResponses(OrderItem orderItem,
			Integer start, Integer number, List<String> orderBy) {
		List<SurveyResponse> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(SurveyResponse.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = SurveyResponse.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get work order item fulfillments
	 */
	public List<WorkOrderItemFulfillment> getWorkOrderItemFulfillments(
			OrderItem orderItem, Integer start, Integer number,
			List<String> orderBy) {
		List<WorkOrderItemFulfillment> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(WorkOrderItemFulfillment.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("orderId", EntityOperator.EQUALS, orderItem
						.getOrderId()), new EntityExpr("orderItemSeqId",
						EntityOperator.EQUALS, orderItem.getOrderItemSeqId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = WorkOrderItemFulfillment.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}