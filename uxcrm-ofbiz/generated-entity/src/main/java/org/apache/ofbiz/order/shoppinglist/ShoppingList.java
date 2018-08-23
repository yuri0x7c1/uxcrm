package org.apache.ofbiz.order.shoppinglist;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Shopping List
 */
@FieldNameConstants
public class ShoppingList implements Serializable {

	public static final long serialVersionUID = 3144457061355208704L;
	public static final String NAME = "ShoppingList";
	/**
	 * Shopping List Id
	 */
	@Getter
	@Setter
	private String shoppingListId;
	/**
	 * Shopping List Type Id
	 */
	@Getter
	@Setter
	private String shoppingListTypeId;
	/**
	 * Parent Shopping List Id
	 */
	@Getter
	@Setter
	private String parentShoppingListId;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * Visitor Id
	 */
	@Getter
	@Setter
	private String visitorId;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * List Name
	 */
	@Getter
	@Setter
	private String listName;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;
	/**
	 * Is Active
	 */
	@Getter
	@Setter
	private String isActive;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Last Ordered Date
	 */
	@Getter
	@Setter
	private Timestamp lastOrderedDate;
	/**
	 * Last Admin Modified
	 */
	@Getter
	@Setter
	private Timestamp lastAdminModified;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Last Updated Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedStamp;
	/**
	 * Last Updated Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp lastUpdatedTxStamp;
	/**
	 * Created Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdStamp;
	/**
	 * Created Tx Stamp
	 */
	@Getter
	@Setter
	private Timestamp createdTxStamp;

	public ShoppingList(GenericValue value) {
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		shoppingListTypeId = (String) value.get(FIELD_SHOPPING_LIST_TYPE_ID);
		parentShoppingListId = (String) value
				.get(FIELD_PARENT_SHOPPING_LIST_ID);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		visitorId = (String) value.get(FIELD_VISITOR_ID);
		partyId = (String) value.get(FIELD_PARTY_ID);
		listName = (String) value.get(FIELD_LIST_NAME);
		description = (String) value.get(FIELD_DESCRIPTION);
		isPublic = (String) value.get(FIELD_IS_PUBLIC);
		isActive = (String) value.get(FIELD_IS_ACTIVE);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		lastOrderedDate = (Timestamp) value.get(FIELD_LAST_ORDERED_DATE);
		lastAdminModified = (Timestamp) value.get(FIELD_LAST_ADMIN_MODIFIED);
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ShoppingList fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ShoppingList(value);
	}

	public static List<ShoppingList> fromValues(List<GenericValue> values) {
		List<ShoppingList> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ShoppingList(value));
		}
		return entities;
	}
}