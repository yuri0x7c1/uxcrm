package org.apache.ofbiz.order._return;

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
public class ReturnHeader implements Serializable {

	public static final long serialVersionUID = 6150113486677615616L;
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

	public enum Fields {
		returnId, returnHeaderTypeId, statusId, createdBy, fromPartyId, toPartyId, paymentMethodId, finAccountId, billingAccountId, entryDate, originContactMechId, destinationFacilityId, needsInventoryReceive, currencyUomId, supplierRmaId, lastUpdatedStamp, lastUpdatedTxStamp, createdStamp, createdTxStamp
	}

	public ReturnHeader(GenericValue value) {
		returnId = (String) value.get(Fields.returnId.name());
		returnHeaderTypeId = (String) value.get(Fields.returnHeaderTypeId
				.name());
		statusId = (String) value.get(Fields.statusId.name());
		createdBy = (String) value.get(Fields.createdBy.name());
		fromPartyId = (String) value.get(Fields.fromPartyId.name());
		toPartyId = (String) value.get(Fields.toPartyId.name());
		paymentMethodId = (String) value.get(Fields.paymentMethodId.name());
		finAccountId = (String) value.get(Fields.finAccountId.name());
		billingAccountId = (String) value.get(Fields.billingAccountId.name());
		entryDate = (Timestamp) value.get(Fields.entryDate.name());
		originContactMechId = (String) value.get(Fields.originContactMechId
				.name());
		destinationFacilityId = (String) value.get(Fields.destinationFacilityId
				.name());
		needsInventoryReceive = (String) value.get(Fields.needsInventoryReceive
				.name());
		currencyUomId = (String) value.get(Fields.currencyUomId.name());
		supplierRmaId = (String) value.get(Fields.supplierRmaId.name());
		lastUpdatedStamp = (Timestamp) value
				.get(Fields.lastUpdatedStamp.name());
		lastUpdatedTxStamp = (Timestamp) value.get(Fields.lastUpdatedTxStamp
				.name());
		createdStamp = (Timestamp) value.get(Fields.createdStamp.name());
		createdTxStamp = (Timestamp) value.get(Fields.createdTxStamp.name());
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