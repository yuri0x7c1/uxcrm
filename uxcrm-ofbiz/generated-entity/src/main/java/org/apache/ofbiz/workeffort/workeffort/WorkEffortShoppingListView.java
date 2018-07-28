package org.apache.ofbiz.workeffort.workeffort;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Work Effort Shopping List View
 */
public class WorkEffortShoppingListView implements Serializable {

	public static final long serialVersionUID = 589443360349827072L;
	public static final String NAME = "WorkEffortShoppingListView";
	/**
	 * Shopping List Type Description
	 */
	@Getter
	@Setter
	private String shoppingListTypeDescription;
	/**
	 * Work Effort Id
	 */
	@Getter
	@Setter
	private String workEffortId;
	/**
	 * Shopping List Id
	 */
	@Getter
	@Setter
	private String shoppingListId;
	/**
	 * Recurrence Info Id
	 */
	@Getter
	@Setter
	private String recurrenceInfoId;
	/**
	 * Parent Shopping List Id
	 */
	@Getter
	@Setter
	private String parentShoppingListId;
	/**
	 * Product Promo Code Id
	 */
	@Getter
	@Setter
	private String productPromoCodeId;
	/**
	 * Description
	 */
	@Getter
	@Setter
	private String description;
	/**
	 * Is Active
	 */
	@Getter
	@Setter
	private String isActive;
	/**
	 * Shopping List Type Id
	 */
	@Getter
	@Setter
	private String shoppingListTypeId;
	/**
	 * Contact Mech Id
	 */
	@Getter
	@Setter
	private String contactMechId;
	/**
	 * Carrier Party Id
	 */
	@Getter
	@Setter
	private String carrierPartyId;
	/**
	 * Currency Uom
	 */
	@Getter
	@Setter
	private String currencyUom;
	/**
	 * Last Ordered Date
	 */
	@Getter
	@Setter
	private Timestamp lastOrderedDate;
	/**
	 * Carrier Role Type Id
	 */
	@Getter
	@Setter
	private String carrierRoleTypeId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Is Public
	 */
	@Getter
	@Setter
	private String isPublic;
	/**
	 * Product Store Id
	 */
	@Getter
	@Setter
	private String productStoreId;
	/**
	 * List Name
	 */
	@Getter
	@Setter
	private String listName;
	/**
	 * Last Admin Modified
	 */
	@Getter
	@Setter
	private Timestamp lastAdminModified;
	/**
	 * Party Id
	 */
	@Getter
	@Setter
	private String partyId;
	/**
	 * Shipment Method Type Id
	 */
	@Getter
	@Setter
	private String shipmentMethodTypeId;
	/**
	 * Visitor Id
	 */
	@Getter
	@Setter
	private String visitorId;

	public enum Fields {
		shoppingListTypeDescription, workEffortId, shoppingListId, recurrenceInfoId, parentShoppingListId, productPromoCodeId, description, isActive, shoppingListTypeId, contactMechId, carrierPartyId, currencyUom, lastOrderedDate, carrierRoleTypeId, paymentMethodId, isPublic, productStoreId, listName, lastAdminModified, partyId, shipmentMethodTypeId, visitorId
	}

	public WorkEffortShoppingListView(GenericValue value) {
		shoppingListTypeDescription = (String) value
				.get(Fields.shoppingListTypeDescription.name());
		workEffortId = (String) value.get(Fields.workEffortId.name());
		shoppingListId = (String) value.get(Fields.shoppingListId.name());
		recurrenceInfoId = (String) value.get(Fields.recurrenceInfoId.name());
		parentShoppingListId = (String) value.get(Fields.parentShoppingListId
				.name());
		productPromoCodeId = (String) value.get(Fields.productPromoCodeId
				.name());
		description = (String) value.get(Fields.description.name());
		isActive = (String) value.get(Fields.isActive.name());
		shoppingListTypeId = (String) value.get(Fields.shoppingListTypeId
				.name());
		contactMechId = (String) value.get(Fields.contactMechId.name());
		carrierPartyId = (String) value.get(Fields.carrierPartyId.name());
		currencyUom = (String) value.get(Fields.currencyUom.name());
		lastOrderedDate = (Timestamp) value.get(Fields.lastOrderedDate.name());
		carrierRoleTypeId = (String) value.get(Fields.carrierRoleTypeId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		isPublic = (String) value.get(Fields.isPublic.name());
		productStoreId = (String) value.get(Fields.productStoreId.name());
		listName = (String) value.get(Fields.listName.name());
		lastAdminModified = (Timestamp) value.get(Fields.lastAdminModified
				.name());
		partyId = (String) value.get(Fields.partyId.name());
		shipmentMethodTypeId = (String) value.get(Fields.shipmentMethodTypeId
				.name());
		visitorId = (String) value.get(Fields.visitorId.name());
	}

	public static WorkEffortShoppingListView fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new WorkEffortShoppingListView(value);
	}

	public static List<WorkEffortShoppingListView> fromValues(
			List<GenericValue> values) {
		List<WorkEffortShoppingListView> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new WorkEffortShoppingListView(value));
		}
		return entities;
	}
}