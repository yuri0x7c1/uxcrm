package org.apache.ofbiz.order._return;

import lombok.experimental.FieldNameConstants;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import org.apache.ofbiz.entity.GenericValue;
import java.util.List;
import java.util.ArrayList;

/**
 * Return Header
 */
@FieldNameConstants
public class ReturnHeader implements Serializable {

	public static final long serialVersionUID = 1727830903009327104L;
	public static final String NAME = "ReturnHeader";
	/**
	 * Return Id
	 */
	@Getter
	@Setter
	private String returnId;
	/**
	 * Return Header Type Id
	 */
	@Getter
	@Setter
	private String returnHeaderTypeId;
	/**
	 * Status Id
	 */
	@Getter
	@Setter
	private String statusId;
	/**
	 * Created By
	 */
	@Getter
	@Setter
	private String createdBy;
	/**
	 * From Party Id
	 */
	@Getter
	@Setter
	private String fromPartyId;
	/**
	 * To Party Id
	 */
	@Getter
	@Setter
	private String toPartyId;
	/**
	 * Payment Method Id
	 */
	@Getter
	@Setter
	private String paymentMethodId;
	/**
	 * Fin Account Id
	 */
	@Getter
	@Setter
	private String finAccountId;
	/**
	 * Billing Account Id
	 */
	@Getter
	@Setter
	private String billingAccountId;
	/**
	 * Entry Date
	 */
	@Getter
	@Setter
	private Timestamp entryDate;
	/**
	 * Origin Contact Mech Id
	 */
	@Getter
	@Setter
	private String originContactMechId;
	/**
	 * Destination Facility Id
	 */
	@Getter
	@Setter
	private String destinationFacilityId;
	/**
	 * Needs Inventory Receive
	 */
	@Getter
	@Setter
	private String needsInventoryReceive;
	/**
	 * Currency Uom Id
	 */
	@Getter
	@Setter
	private String currencyUomId;
	/**
	 * Supplier Rma Id
	 */
	@Getter
	@Setter
	private String supplierRmaId;
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

	public ReturnHeader(GenericValue value) {
		returnId = (String) value.get(FIELD_RETURN_ID);
		returnHeaderTypeId = (String) value.get(FIELD_RETURN_HEADER_TYPE_ID);
		statusId = (String) value.get(FIELD_STATUS_ID);
		createdBy = (String) value.get(FIELD_CREATED_BY);
		fromPartyId = (String) value.get(FIELD_FROM_PARTY_ID);
		toPartyId = (String) value.get(FIELD_TO_PARTY_ID);
		paymentMethodId = (String) value.get(FIELD_PAYMENT_METHOD_ID);
		finAccountId = (String) value.get(FIELD_FIN_ACCOUNT_ID);
		billingAccountId = (String) value.get(FIELD_BILLING_ACCOUNT_ID);
		entryDate = (Timestamp) value.get(FIELD_ENTRY_DATE);
		originContactMechId = (String) value.get(FIELD_ORIGIN_CONTACT_MECH_ID);
		destinationFacilityId = (String) value
				.get(FIELD_DESTINATION_FACILITY_ID);
		needsInventoryReceive = (String) value
				.get(FIELD_NEEDS_INVENTORY_RECEIVE);
		currencyUomId = (String) value.get(FIELD_CURRENCY_UOM_ID);
		supplierRmaId = (String) value.get(FIELD_SUPPLIER_RMA_ID);
		lastUpdatedStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_STAMP);
		lastUpdatedTxStamp = (Timestamp) value.get(FIELD_LAST_UPDATED_TX_STAMP);
		createdStamp = (Timestamp) value.get(FIELD_CREATED_STAMP);
		createdTxStamp = (Timestamp) value.get(FIELD_CREATED_TX_STAMP);
	}

	public static ReturnHeader fromValue(
			org.apache.ofbiz.entity.GenericValue value) {
		return new ReturnHeader(value);
	}

	public static List<ReturnHeader> fromValues(List<GenericValue> values) {
		List<ReturnHeader> entities = new ArrayList<>();
		for (GenericValue value : values) {
			entities.add(new ReturnHeader(value));
		}
		return entities;
	}
}