package org.apache.ofbiz.workeffort.workeffort;

import lombok.experimental.FieldNameConstants;
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
@FieldNameConstants
public class WorkEffortShoppingListView implements Serializable {

	public static final long serialVersionUID = 1133805736460829696L;
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

	public WorkEffortShoppingListView(GenericValue value) {
		shoppingListTypeDescription = (String) value
				.get(FIELD_SHOPPING_LIST_TYPE_DESCRIPTION);
		workEffortId = (String) value.get(FIELD_WORK_EFFORT_ID);
		shoppingListId = (String) value.get(FIELD_SHOPPING_LIST_ID);
		recurrenceInfoId = (String) value.get(FIELD_RECURRENCE_INFO_ID);
		parentShoppingListId = (String) value
				.get(FIELD_PARENT_SHOPPING_LIST_ID);
		productPromoCodeId = (String) value.get(FIELD_PRODUCT_PROMO_CODE_ID);
		description = (String) value.get(FIELD_DESCRIPTION);
		isActive = (String) value.get(FIELD_IS_ACTIVE);
		shoppingListTypeId = (String) value.get(FIELD_SHOPPING_LIST_TYPE_ID);
		contactMechId = (String) value.get(FIELD_CONTACT_MECH_ID);
		carrierPartyId = (String) value.get(FIELD_CARRIER_PARTY_ID);
		currencyUom = (String) value.get(FIELD_CURRENCY_UOM);
		lastOrderedDate = (Timestamp) value.get(FIELD_LAST_ORDERED_DATE);
		carrierRoleTypeId = (String) value.get(FIELD_CARRIER_ROLE_TYPE_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		isPublic = (String) value.get(FIELD_IS_PUBLIC);
		productStoreId = (String) value.get(FIELD_PRODUCT_STORE_ID);
		listName = (String) value.get(FIELD_LIST_NAME);
		lastAdminModified = (Timestamp) value.get(FIELD_LAST_ADMIN_MODIFIED);
		partyId = (String) value.get(FIELD_PARTY_ID);
		shipmentMethodTypeId = (String) value
				.get(FIELD_SHIPMENT_METHOD_TYPE_ID);
		visitorId = (String) value.get(FIELD_VISITOR_ID);
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