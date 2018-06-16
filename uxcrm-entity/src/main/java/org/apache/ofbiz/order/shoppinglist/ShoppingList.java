package org.apache.ofbiz.order.shoppinglist;

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
public class ShoppingList implements Serializable {

	public static final long serialVersionUID = 6225470044276196352L;
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

	public enum Fields {
		shoppingListId, shoppingListTypeId, parentShoppingListId, productStoreId, visitorId, partyId, listName, description, isPublic, isActive, currencyUom, shipmentMethodTypeId, carrierPartyId, carrierRoleTypeId, contactMechId, paymentMethodId, recurrenceInfoId, lastOrderedDate, lastAdminModified, productPromoCodeId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ShoppingList(GenericValue value) {
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		shoppingListTypeId = (String) value.get(Fields.shoppingListTypeId
				.name());
		parentShoppingListId = (String) value.get(Fields.parentShoppingListId
				.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		visitorId = (String) value.get(Fields.visitorId.name());
		partyId = (String) value.get(Fields.partyId.name());
		listName = (String) value.get(Fields.listName.name());
		description = (String) value.get(Fields.description.name());
		isPublic = (String) value.get(Fields.isPublic.name());
		isActive = (String) value.get(Fields.isActive.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		lastOrderedDate = (Timestamp) value.get(Fields.lastOrderedDate.name());
		lastAdminModified = (Timestamp) value.get(Fields.lastAdminModified
				.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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