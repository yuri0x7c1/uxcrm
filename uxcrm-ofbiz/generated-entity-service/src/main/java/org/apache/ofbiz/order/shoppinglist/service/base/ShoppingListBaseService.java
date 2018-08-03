package org.apache.ofbiz.order.shoppinglist.service.base;

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
import org.apache.ofbiz.order.shoppinglist.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ofbiz.order.shoppinglist.ShoppingListType;
import org.apache.ofbiz.product.store.ProductStore;
import org.apache.ofbiz.party.party.Party;
import org.apache.ofbiz.product.store.ProductStoreShipmentMeth;
import org.apache.ofbiz.shipment.shipment.CarrierShipmentMethod;
import org.apache.ofbiz.party.contact.ContactMech;
import org.apache.ofbiz.party.contact.PostalAddress;
import org.apache.ofbiz.accounting.payment.PaymentMethod;
import org.apache.ofbiz.service.schedule.RecurrenceInfo;
import org.apache.ofbiz.product.promo.ProductPromoCode;
import org.apache.ofbiz.order.order.OrderHeader;
import org.apache.ofbiz.order.shoppinglist.ShoppingListItem;
import org.apache.ofbiz.order.shoppinglist.ShoppingListItemSurvey;
import org.apache.ofbiz.order.shoppinglist.ShoppingListWorkEffort;

@Slf4j
@Component
@SuppressWarnings("unchecked")
public class ShoppingListBaseService {

	protected ExecuteFindService executeFindService;

	@Autowired
	public ShoppingListBaseService(ExecuteFindService executeFindService) {
		this.executeFindService = executeFindService;
	}

	/**
	 * Count ShoppingLists
	 */
	public Integer count(EntityConditionList conditions) {
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		if (conditions == null) {
			in.setNoConditionFind(OfbizUtil.Y);
		} else {
			in.setEntityConditionList(conditions);
		}
		Out out = executeFindService.runSync(in);
		return out.getListSize();
	}

	/**
	 * Find ShoppingLists
	 */
	public List<ShoppingList> find(Integer start, Integer number,
			List<String> orderBy, EntityConditionList conditions) {
		List<ShoppingList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
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
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Find one ShoppingList
	 */
	public Optional<ShoppingList> findOne(Object shoppingListId) {
		List<ShoppingList> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingListId)), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
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
	 * Get parent shopping list
	 */
	public Optional<ShoppingList> getParentShoppingList(
			ShoppingList shoppingList) {
		List<ShoppingList> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingList.getParentShoppingListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
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
	 * Get sibling shopping lists
	 */
	public List<ShoppingList> getSiblingShoppingLists(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<ShoppingList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("parentShoppingListId",
						EntityOperator.EQUALS, shoppingList
								.getParentShoppingListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping list type
	 */
	public Optional<ShoppingListType> getShoppingListType(
			ShoppingList shoppingList) {
		List<ShoppingListType> entityList = null;
		In in = new In();
		in.setEntityName(ShoppingListType.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListTypeId",
						EntityOperator.EQUALS, shoppingList
								.getShoppingListTypeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListType.fromValues(out.getListIt()
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
	 * Get product store
	 */
	public Optional<ProductStore> getProductStore(ShoppingList shoppingList) {
		List<ProductStore> entityList = null;
		In in = new In();
		in.setEntityName(ProductStore.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productStoreId", EntityOperator.EQUALS,
						shoppingList.getProductStoreId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStore.fromValues(out.getListIt()
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
	public Optional<Party> getParty(ShoppingList shoppingList) {
		List<Party> entityList = null;
		In in = new In();
		in.setEntityName(Party.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("partyId", EntityOperator.EQUALS,
						shoppingList.getPartyId())), EntityOperator.AND));
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
	 * Get product store shipment meths
	 */
	public List<ProductStoreShipmentMeth> getProductStoreShipmentMeths(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<ProductStoreShipmentMeth> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ProductStoreShipmentMeth.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("productStoreId", EntityOperator.EQUALS,
						shoppingList.getProductStoreId()),
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						shoppingList.getShipmentMethodTypeId()),
				new EntityExpr("partyId", EntityOperator.EQUALS, shoppingList
						.getCarrierPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						shoppingList.getCarrierRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductStoreShipmentMeth.fromValues(out
						.getListIt().getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get carrier shipment method
	 */
	public Optional<CarrierShipmentMethod> getCarrierShipmentMethod(
			ShoppingList shoppingList) {
		List<CarrierShipmentMethod> entityList = null;
		In in = new In();
		in.setEntityName(CarrierShipmentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays.asList(
				new EntityExpr("shipmentMethodTypeId", EntityOperator.EQUALS,
						shoppingList.getShipmentMethodTypeId()),
				new EntityExpr("partyId", EntityOperator.EQUALS, shoppingList
						.getCarrierPartyId()),
				new EntityExpr("roleTypeId", EntityOperator.EQUALS,
						shoppingList.getCarrierRoleTypeId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = CarrierShipmentMethod.fromValues(out.getListIt()
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
	 * Get contact mech
	 */
	public Optional<ContactMech> getContactMech(ShoppingList shoppingList) {
		List<ContactMech> entityList = null;
		In in = new In();
		in.setEntityName(ContactMech.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shoppingList.getContactMechId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ContactMech.fromValues(out.getListIt()
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
	 * Get postal address
	 */
	public Optional<PostalAddress> getPostalAddress(ShoppingList shoppingList) {
		List<PostalAddress> entityList = null;
		In in = new In();
		in.setEntityName(PostalAddress.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("contactMechId", EntityOperator.EQUALS,
						shoppingList.getContactMechId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PostalAddress.fromValues(out.getListIt()
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
	 * Get payment method
	 */
	public Optional<PaymentMethod> getPaymentMethod(ShoppingList shoppingList) {
		List<PaymentMethod> entityList = null;
		In in = new In();
		in.setEntityName(PaymentMethod.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("paymentMethodId",
						EntityOperator.EQUALS, shoppingList
								.getPaymentMethodId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = PaymentMethod.fromValues(out.getListIt()
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
	 * Get recurrence info
	 */
	public Optional<RecurrenceInfo> getRecurrenceInfo(ShoppingList shoppingList) {
		List<RecurrenceInfo> entityList = null;
		In in = new In();
		in.setEntityName(RecurrenceInfo.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("recurrenceInfoId",
						EntityOperator.EQUALS, shoppingList
								.getRecurrenceInfoId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = RecurrenceInfo.fromValues(out.getListIt()
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
	 * Get product promo code
	 */
	public Optional<ProductPromoCode> getProductPromoCode(
			ShoppingList shoppingList) {
		List<ProductPromoCode> entityList = null;
		In in = new In();
		in.setEntityName(ProductPromoCode.NAME);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("productPromoCodeId",
						EntityOperator.EQUALS, shoppingList
								.getProductPromoCodeId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ProductPromoCode.fromValues(out.getListIt()
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
	 * Get auto order order headers
	 */
	public List<OrderHeader> getAutoOrderOrderHeaders(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<OrderHeader> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(OrderHeader.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("autoOrderShoppingListId",
						EntityOperator.EQUALS, shoppingList.getShoppingListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = OrderHeader.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get child shopping lists
	 */
	public List<ShoppingList> getChildShoppingLists(ShoppingList shoppingList,
			Integer start, Integer number, List<String> orderBy) {
		List<ShoppingList> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingList.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(
				Arrays.asList(new EntityExpr("parentShoppingListId",
						EntityOperator.EQUALS, shoppingList.getShoppingListId())),
				EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingList.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping list items
	 */
	public List<ShoppingListItem> getShoppingListItems(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<ShoppingListItem> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingListItem.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingList.getShoppingListId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListItem.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping list item surveys
	 */
	public List<ShoppingListItemSurvey> getShoppingListItemSurveys(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<ShoppingListItemSurvey> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingListItemSurvey.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingList.getShoppingListId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListItemSurvey.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}

	/**
	 * Get shopping list work efforts
	 */
	public List<ShoppingListWorkEffort> getShoppingListWorkEfforts(
			ShoppingList shoppingList, Integer start, Integer number,
			List<String> orderBy) {
		List<ShoppingListWorkEffort> entityList = Collections.emptyList();
		In in = new In();
		in.setEntityName(ShoppingListWorkEffort.NAME);
		if (start == null) {
			start = OfbizUtil.DEFAULT_FIND_START;
		}
		if (number == null) {
			number = OfbizUtil.DEFAULT_FIND_NUMBER;
		}
		in.setOrderByList(orderBy);
		in.setEntityConditionList(new EntityConditionList<>(Arrays
				.asList(new EntityExpr("shoppingListId", EntityOperator.EQUALS,
						shoppingList.getShoppingListId())), EntityOperator.AND));
		Out out = executeFindService.runSync(in);
		try {
			if (out.getListIt() != null) {
				entityList = ShoppingListWorkEffort.fromValues(out.getListIt()
						.getPartialList(start, number));
				out.getListIt().close();
			}
		} catch (GenericEntityException e) {
			log.error(e.getMessage(), e);
		}
		return entityList;
	}
}